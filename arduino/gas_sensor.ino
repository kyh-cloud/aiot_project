#include <DHT11.h>
#include <Servo.h>
int pin= 12;
Servo myservo1;
DHT11 dht11(pin);
const int gasPin = A0 ; //가스 핀을 A0에 연결합니다.
const int gasPin2 = A1 ;
const int ledPin = 8; // led핀을 12번에 연결합니다.
int GasValue; // gas라는 정수의 값을 설정합니다.
int GasValue2;
int buzzer =2;
float temp, humi;
void setup()
{
 myservo1.attach(10);
 Serial.begin(9600); //serial포트를 시작하고
 pinMode(ledPin, OUTPUT); //핀의 LED를 빛을 내주는 OUTPUT의 단자로 활용합니다.
 pinMode(buzzer,OUTPUT);
}
void loop(){
  GasValue = analogRead(gasPin); //gasvalue는 gaspin의 값을 읽어옵니다.
  GasValue2 = analogRead(gasPin2);
  dht11.read(humi, temp);
  if ((GasValue>=50 && GasValue2 >= 50)&& temp>=26) //500보다 크거나 같을시에
  {
    digitalWrite(ledPin, HIGH); //LED의 빛이 나옵니다.
    digitalWrite(buzzer, HIGH);
    myservo1.write(30);
    delay(10);
  }
  else
  {
    digitalWrite(ledPin, LOW); // 작을시에는 꺼집니다.
    digitalWrite(buzzer, LOW); // led가 꺼질경우 부저도 꺼짐
    myservo1.write(150);
     delay(10);
  }
  Serial.print("GG"+String(GasValue)+",");
  Serial.print("SS"+String(GasValue2)+",");
  Serial.print("TT"+String(temp)+",");
  Serial.println("HH"+String(humi)+",");
  delay(1000);
}
