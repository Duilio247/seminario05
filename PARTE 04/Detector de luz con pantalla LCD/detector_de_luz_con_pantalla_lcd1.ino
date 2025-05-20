#include <LiquidCrystal.h>

LiquidCrystal lcd(7,6,5,4,3,2);
const int pinLDR = A0;
String mensajeAnterior = "";

void setup() {
  lcd.begin(16,2);
  lcd.clear();
}

void loop() {
  int luz = analogRead(pinLDR);
  String mensajeActual;

  if (luz > 600) {
    mensajeActual = "DIA SOLEADO";
  } else {
    mensajeActual = "DIA NUBLADO";
  }

  if (mensajeActual != mensajeAnterior) {
    lcd.clear();
    lcd.setCursor(0,0);
    lcd.print(mensajeActual);
    mensajeAnterior = mensajeActual;
  }
  
  delay(1000);
}
