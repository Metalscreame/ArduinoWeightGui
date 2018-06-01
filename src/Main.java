import COM.PortHandler;
import GUI.MainWindow;

public class Main {

   public static MainWindow window;

    public static void main(String[] args) throws Exception {
        window = new MainWindow();
        new PortHandler(window);
    }
}
