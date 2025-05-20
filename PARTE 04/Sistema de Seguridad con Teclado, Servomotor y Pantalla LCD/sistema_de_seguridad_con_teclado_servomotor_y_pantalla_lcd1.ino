#include <LiquidCrystal.h>
#include <Keypad.h>
#include <Servo.h>

LiquidCrystal lcd(12, 11, 5, 4, 3, 2);

const byte FILAS = 4;
const byte COLUMNAS = 4;

char teclas[FILAS][COLUMNAS] = {
  {'1','2','3','A'},
  {'4','5','6','B'},
  {'7','8','9','C'},
  {'*','0','#','D'}
};

byte pinesFila[FILAS] = {A0, A1, A2, A3};
byte pinesCol[COLUMNAS] = {6, 7, 8, 9};

Keypad teclado = Keypad(makeKeymap(teclas), pinesFila, pinesCol, FILAS, COLUMNAS);

Servo servo;
const int pinServo = 10;

String clave = "1234";
String ingreso = "";
int intentos = 0;
bool bloqueado = false;
unsigned long tiempoBloqueo = 0;

void setup() {
  lcd.begin(16, 2);
  servo.attach(pinServo);
  servo.write(0);
  lcd.print("Ingrese clave:");
}

void loop() {
  if (bloqueado) {
    if (millis() - tiempoBloqueo >= 30000) {
      bloqueado = false;
      intentos = 0;
      lcd.clear();
      lcd.print("Reseteando...");
      delay(2000);
      lcd.clear();
      lcd.print("Ingrese clave:");
      ingreso = "";
    }
    return;
  }

  char tecla = teclado.getKey();
  if (tecla) {
    if (tecla == '#') {  //tecla enter
      if (ingreso == clave) {
        lcd.clear();
        lcd.print("Acceso otorgado");
        servo.write(90);
        delay(3000);
        servo.write(0);
        lcd.clear();
        lcd.print("Ingrese clave:");
        intentos = 0;
      } else {
        intentos++;
        lcd.clear();
        lcd.print("Clave errada");
        delay(2000);
        if (intentos >= 3) {
          bloqueado = true;
          tiempoBloqueo = millis();
          lcd.clear();
          lcd.print("Bloqueo x 30 s");
        } else {
          lcd.clear();
          lcd.print("Ingrese clave:");
        }
      }
      ingreso = "";
    } else if (tecla == '*') { //tecla del
      ingreso = "";
      lcd.clear();
      lcd.print("Ingrese clave:");
    } else {
      ingreso += tecla;
      lcd.setCursor(0, 1);
      lcd.print(ingreso);
    }
  }
}
