#include <LiquidCrystal.h>

LiquidCrystal lcd(7,6,5,4,3,2);

const int pinTemp = A0;

void setup() {
  lcd.begin(16,2); 
  lcd.print("Termometro listo");
  delay(1500);
  lcd.clear();
}

void loop() {
  int valorAnalog = analogRead(pinTemp);

  float voltaje = valorAnalog * (5.0 / 1023.0);
  float tempC = voltaje * 100.0;          
  float tempF = (tempC * 9.0 / 5.0) + 32; 

  lcd.setCursor(0,0);
  lcd.print("C: ");
  lcd.print(tempC,1);  
  

  lcd.setCursor(0,1);
  lcd.print("F: ");
  lcd.print(tempF,1);
  

  delay(1000);
}
