// C++ code
//
int pin3=3;
int pin4=4;
int pin5=5;
int pin2=2;
int switchState = 0;

int delay1 = 250; //tiempo de retraso

void setup()
{
  pinMode(pin3, OUTPUT);
  pinMode(pin4, OUTPUT);
  pinMode(pin5, OUTPUT);
  pinMode(pin2, INPUT);
}

void loop()
{
  switchState = digitalRead(pin2);
  //esto es un comentario
  
if(switchState == LOW){
  //el pulsador no esta presionado
  digitalWrite(pin3, HIGH); //LED verde
  digitalWrite(pin4, LOW);  //LED rojo
  digitalWrite(pin5, LOW);  //LED rojo   
}
  else {   //pulsador ta presionado
     digitalWrite(pin3, LOW);
     digitalWrite(pin4, LOW);
     digitalWrite(pin5, HIGH);
     
     delay(delay1); //pausa 1/4 seg
     //cambiar el estado de los LEDs
     digitalWrite(pin4, HIGH);
     digitalWrite(pin5, LOW);
     delay(delay1); //pausa 1/4 seg
  }
} //volver al comienzo de la instruccion loop