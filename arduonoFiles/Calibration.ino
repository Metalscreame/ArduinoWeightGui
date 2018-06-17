#include "HX711.h"
#define DOUT A3
#define CLK A2
HX711 balanza(DOUT, CLK);
void setup() {
Serial.begin(9600);
Serial.print("Reading: ");
Serial.println(balanza.read());
Serial.println("dont put anything on scales");
Serial.println("Calibrating...");
balanza.set_scale(); //Типовий масштаб 1
balanza.tare(20); //Поточний вага з врахуванням тари.
Serial.println("Put weight:");
}
void loop() {
Serial.print("reading: ");
Serial.println(balanza.get_value(10),0);
delay(1000);
}
