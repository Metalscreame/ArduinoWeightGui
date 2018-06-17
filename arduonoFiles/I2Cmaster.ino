#include <EEPROM.h>
#include <Wire.h>

#define PAYLOAD_SIZE 2 // how many bytes to expect from each I2C salve node
#define NODE_MAX 3 // maximum number of slave nodes (I2C addresses) to probe
#define START_NODE 2 // The starting I2C address of slave nodes
#define NODE_READ_DELAY 100 // Some delay between I2C node reads

int needToCalibrateAddr;
bool needToCalibrate;

int addr = 0;
int val = 0;

void setup()
{
    needToCalibrate = EEPROMReadInt(needToCalibrateAddr);
    if (needToCalibrate){
        // calibrating here
    }

    Serial.begin(9600);
    
}

void loop()
{
    val = EEPROMReadInt(addr);
    Serial.println(val);
    val++;

    EEPROMWriteInt(addr, val);
    delay(100);
}




//This function will write a 2 byte integer to the eeprom at the specified address and address + 1
void EEPROMWriteInt(int p_address, int p_value)
{
    byte lowByte = ((p_value >> 0) & 0xFF);
    byte highByte = ((p_value >> 8) & 0xFF);
    EEPROM.write(p_address, lowByte);
    EEPROM.write(p_address + 1, highByte);
}

//This function will read a 2 byte integer from the eeprom at the specified address and address + 1
unsigned int EEPROMReadInt(int p_address)
{
    byte lowByte = EEPROM.read(p_address);
    byte highByte = EEPROM.read(p_address + 1);
    return ((lowByte << 0) & 0xFF) + ((highByte << 8) & 0xFF00);
}