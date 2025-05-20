const int pinPIR = 2; 
const int pinZumbador = 8; 

void setup() {
  pinMode(pinPIR, INPUT);
  pinMode(pinZumbador, OUTPUT);
  Serial.begin(9600); 
}

void loop() {
  int movimiento = digitalRead(pinPIR);

  if (movimiento == HIGH) {
    digitalWrite(pinZumbador, HIGH); // on alarma (con mov)
    delay(1000); // alarma suena 1 seg
  } else {
    digitalWrite(pinZumbador, LOW);  // off alarma (sin mov)
  }
  delay(100); 
}
