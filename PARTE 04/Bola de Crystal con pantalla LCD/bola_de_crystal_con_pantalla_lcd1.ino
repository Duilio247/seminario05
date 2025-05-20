#include <LiquidCrystal.h>
LiquidCrystal lcd(12,11,5,4,3,2);
const int PindelSensor = 6;
int EstadodelSensor = 0;
int EstadoPreviodelSensor = 0;
int Contestar;

void setup() {
  lcd.begin(16,2);
  pinMode(PindelSensor,INPUT);
  lcd.print("Preguntame");
  lcd.setCursor(0,1);
  lcd.print("Bola de Cristal");
}

void loop(){
  EstadodelSensor = digitalRead(PindelSensor);
  if(EstadodelSensor != EstadoPreviodelSensor) {
    if (EstadodelSensor == LOW){
      Contestar = random(8);
      lcd.clear();
      lcd.setCursor(0,0);
      lcd.print("La bola dice:");
      lcd.setCursor(0,1);

      switch(Contestar){
        case 0:
        lcd.print("Si");
        break;
        case 1:
        lcd.print("Es probable");
        break;
        case 2:
        lcd.print("Ciertamente");
        break;
        case 3:
        lcd.print("Buenas perspectivas");
        break;
        case 4:
        lcd.print("No es seguro");
        break;
        case 5:
        lcd.print("Pregunta de nuevo");
        break;
        case 6:
        lcd.print("Ni idea");
        break;
        case 7:
        lcd.print("No");
        break;
      }
    }
  }
  EstadoPreviodelSensor = EstadodelSensor;
}




