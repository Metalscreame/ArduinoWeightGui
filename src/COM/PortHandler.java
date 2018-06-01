package COM;

import GUI.MainWindow;
import jssc.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class PortHandler extends Thread {
    private SerialPort port;

    private byte[] buffer;
    private byte writeBuffer;
    private File file;
    public FileOutputStream fileStream;
    public String strToPrint="";
    private MainWindow winRef;

    public PortHandler(MainWindow window) throws Exception {
        try {
            this.winRef=window;
            String[] ports = SerialPortList.getPortNames();
            System.out.println(Arrays.toString(ports));
            file = new File("report.dump");
            fileStream = new FileOutputStream(file);
            port = new SerialPort(ports[2]);
            port.openPort();
            port.setParams(SerialPort.BAUDRATE_9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
            port.setEventsMask(SerialPort.MASK_RXCHAR);
            port.addEventListener(new EventListener());
            System.out.println("Opening port " + port.getPortName());
            start();
        } catch (SerialPortException | FileNotFoundException e) {
            throw new Exception();
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public void run() {
        super.run();
        try {
            while (port.isOpened()) {
                Thread.sleep(1);//was 5
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            fileStream.flush();
            fileStream.close();
            port.closePort();
            System.out.println("Closing port " + port.getPortName());
        } catch (IOException | SerialPortException e) {
            e.printStackTrace();
        }
    }


    class EventListener implements SerialPortEventListener {
        @Override
        public void serialEvent(SerialPortEvent se) {
            if (se.isRXCHAR()) {
                try {
                    buffer = port.readBytes(21);//was 21
                    char temp;// to see whats happening while debug
//                    fileStream.write(buffer);
                    for (byte b : buffer) {
                        temp = (char) b;
                        if (b==13){// 13 is '\r'
                            winRef.SetSensorData(strToPrint);
                            strToPrint="";
                            continue;
                        }
                        strToPrint+=temp;
                        System.out.print(temp);

                    }
//                    fileStream.flush();
                } catch (SerialPortException | NullPointerException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
