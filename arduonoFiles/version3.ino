#include <HX711.h>
#define DOUT  6, A3, A5
#define CLK  5, A2, A4

#include <SoftwareSerial.h>
// Объявляем задействованные дискретные каналы контроллера для связи
SoftwareSerial softSerial(0, 1); // RX, TX>

HX711 scale_1 (6, 5);

HX711 scale_2 (8, 7);

HX711 scale_3 (10, 9);

HX711 scale_4 (12, 11);

HX711 scale_5 (A1, A0);

HX711 scale_6 (A3, A2);

HX711 scale_7 (A5, A4);
HX711 scale_8 (17, 16);
HX711 scale_9 (19, 18);
void setup() {
Serial.begin(9600);
softSerial.begin(9600); // инициализация программного последовательного порта
Serial.print("Reading:  ");
Serial.println("dont put anything on scales");
Serial.println("Calibration...");
Serial.println("...");
  
scale_1.set_scale(1632.34); 
scale_1.tare(1);  

scale_2.set_scale(2178.82); 
scale_2.tare(1);  

scale_3.set_scale(1632.34); 
scale_3.tare(1); 

scale_4.set_scale(1632.34); 
scale_4.tare(1);  

scale_5.set_scale(2178.82); 
scale_5.tare(1);  

scale_6.set_scale(1632.34); 
scale_6.tare(1);

scale_8.set_scale(1632.34); 
scale_8.tare(1);
scale_9.set_scale(1632.34); 
scale_9.tare(1);


}

void loop() {

Serial.print("Weight 1: ");
Serial.print(scale_1.get_units(20),3);
Serial.println(" kg");
delay(500);

Serial.print("Weight 2: ");
Serial.print(scale_2.get_units(20),3);
Serial.println(" kg");
delay(500);

Serial.print("Weight 3: ");
Serial.print(scale_3.get_units(20),3);
Serial.println(" kg");
delay(500);

Serial.print("Weight 4: ");
Serial.print(scale_4.get_units(20),3);
Serial.println(" kg");
delay(500);

Serial.print("Weight 5: ");
Serial.print(scale_5.get_units(20),3);
Serial.println(" kg");
delay(500);

Serial.print("Weight 6: ");
Serial.print(scale_6.get_units(20),3);
Serial.println(" kg");
delay(500);

Serial.print("Weight 7: ");
Serial.print(scale_7.get_units(20),3);
Serial.println(" kg");
delay(500);
Serial.print("Weight 8: ");
Serial.print(scale_8.get_units(20),3);
Serial.println(" kg");
delay(500);
Serial.print("Weight 9: ");
Serial.print(scale_9.get_units(20),3);
Serial.println(" kg");
delay(500);


Serial.println(" ________");
  delay(5000);
}
