int pinROJO = 13;
int pinAMARILLO = 12;
int pinVERDE = 11;
int segmentos[7] = {2, 3, 4, 5, 6, 7, 8};

byte digitos[10][7] = {
  {1,1,1,1,1,1,0}, 
  {0,1,1,0,0,0,0}, 
  {1,1,0,1,1,0,1}, 
  {1,1,1,1,0,0,1}, 
  {0,1,1,0,0,1,1}, 
  {1,0,1,1,0,1,1}, 
  {1,0,1,1,1,1,1}, 
  {1,1,1,0,0,0,0}, 
  {1,1,1,1,1,1,1}, 
  {1,1,1,1,0,1,1}  
};

void mostrarNumero(int n) {
  for (int i = 0; i < 7; i++) {
    digitalWrite(segmentos[i], digitos[n][i]);
  }
}

void setup() {
  pinMode(pinROJO, OUTPUT);
  pinMode(pinAMARILLO, OUTPUT);
  pinMode(pinVERDE, OUTPUT);
  
  for (int i = 0; i < 7; i++) {
    pinMode(segmentos[i], OUTPUT);
  }
}

void cuentaRegresiva(int segundos, int pinLuz) {
  digitalWrite(pinROJO, LOW);
  digitalWrite(pinAMARILLO, LOW);
  digitalWrite(pinVERDE, LOW);

  digitalWrite(pinLuz, HIGH);

  for (int t = segundos; t > 0; t--) {
    mostrarNumero(t % 10); 
  	delay(1000);
  }
  digitalWrite(pinLuz, LOW);
}

void loop() {
  cuentaRegresiva(9, pinROJO);     
  cuentaRegresiva(2, pinAMARILLO); 
  cuentaRegresiva(7, pinVERDE);    
  cuentaRegresiva(2, pinAMARILLO); 
      
}
