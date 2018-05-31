package COM;

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

    public PortHandler() throws Exception {
        try {
            String[] ports = SerialPortList.getPortNames();
            System.out.println(Arrays.toString(ports));
            file = new File("report.dump");
            fileStream = new FileOutputStream(file);
            port = new SerialPort(ports[2]);// 2 for windows, 0 for linux
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

    public void sciSendInt(Integer i) throws SerialPortException {
        port.writeInt(i);
    }

    @Override
    public void run() {
        super.run();
        try {
            while (port.isOpened()) {
                Thread.sleep(5);//was 5
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
                    fileStream.write(buffer);
                    for (byte b : buffer) {
                        if (b == 0 || b == 1) {
                            System.out.print(b);
//                            JformDesign.textAreaAdd(b);
                            // 35 is #, start marker
                        } else {
                            temp = (char) b;
//                            JformDesign.textAreaAdd(temp);
                            System.out.print(temp); // to char if text
                        }
                    }
                    fileStream.flush();
                } catch (SerialPortException | IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
