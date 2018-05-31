///*
// * Created by JFormDesigner on Wed Apr 11 14:23:17 EEST 2018
// */
//
//package GUI;
//
//
//
//import COM.PortHandler;
//
//import javax.swing.*;
//import javax.swing.border.EmptyBorder;
//import javax.swing.text.DefaultCaret;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author Roman Kosyiy
// */
//public class JformDesign extends JFrame {
//
//    private PortHandler portHandler;
//
//
//
//    public JformDesign() throws  IOException {
//
//
//        initComponents();
//        try {
//            portHandler = new PortHandler();
//
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, "Плата не найдена. \nПодключите плату после того, как \nприложение перезапуститься");
//            System.exit(1);
//        }
//    }
//
//    private void AddCommandActionPerformed(ActionEvent e) {
//        new AddAcommandJframe();
//    }
//
//    private void CheckQuery(ActionEvent e) {
//        // TODO show number of cmds to send
//    }
//
//    private void buttonClearListActionPerformed(ActionEvent e) {
//        commandsToSendListEXEC_NOW.clear();
//        commandsToSendListPROGRAM.clear();
//        JOptionPane.showMessageDialog(this, "Очищено");
//    }
//
//    private void button4ActionPerformed(ActionEvent e) {
//        new AddProgCmdsJframe();
//    }
//
//    private void button3ActionPerformed(ActionEvent e) {
//        JOptionPane.showMessageDialog(this, "Количество разовых команд в очереди: " + commandsToSendListEXEC_NOW.size() +
//                "\nКоличество программных команд в очереди: " + commandsToSendListPROGRAM.size());
//    }
//
//    private void button5ActionPerformed(ActionEvent e) {// program cmds
//        try {
//            CCSDSheader ccsdSheader;
//            ArrayList<CommandToSend> lst;
//            ArrayList<ArrayList> buffer = new ArrayList();
//
//            for (Map.Entry<CCSDSheader, ArrayList<CommandToSend>> entry : commandsToSendListPROGRAM.entrySet()) {
//                ccsdSheader = entry.getKey();
//                lst = entry.getValue();
//                buffer.add(SenderSCI.sendCCSDSHeader(ccsdSheader));
//                for (CommandToSend c : lst) {
//                    buffer.add(SenderSCI.sendCommandProgramm(c));
//                }
//            }
//
//            for (Object i : buffer) {
//                for (Object j : (ArrayList) i) {
//                    portHandler.sciSendInt((Integer) j);
//                }
//            }
//            JOptionPane.showMessageDialog(this, "Команды были успешно отправлены");
//            JformDesign.commandsToSendListPROGRAM.clear();
//        } catch (Exception err) {
//            JOptionPane.showMessageDialog(this, "Оп-оп, ощибочка при отправке...: " + err);
//        }
//    }
//
//
//    private void button1ActionPerformed(ActionEvent e) { //exec now commands
//        try {
//            ArrayList<ArrayList> buffer = new ArrayList();
//            CommandToSend cmd;
//            CCSDSheader ccsdSheader;
//            for (Map.Entry<CCSDSheader, CommandToSend> entry : commandsToSendListEXEC_NOW.entrySet()) {
//                ccsdSheader = entry.getKey();
//                cmd = entry.getValue();
//                buffer.add(SenderSCI.sendCCSDSHeader(ccsdSheader));
//                if (cmd.getCommandType().equals(GlobalVariables.TYPE_EXEC_NOW)) {
//                    buffer.add(SenderSCI.sendCommandProgramm(cmd));
//                } else if (cmd.getCommandType().equals(GlobalVariables.TYPE_OBT)) {
//                    buffer.add(SenderSCI.sendOBT(cmd));
//                } else if (cmd.getCommandType().equals(GlobalVariables.TYPE_YSTAVKI)) {
//                    buffer.add(SenderSCI.sendYstavki(cmd));
//                }
//            }
//
//            for (Object i : buffer) {
//                for (Object j : (ArrayList) i) {
//                    portHandler.sciSendInt((Integer) j);
//                }
//            }
//            JformDesign.commandsToSendListEXEC_NOW.clear();
//            JOptionPane.showMessageDialog(this, "Команды были успешно отправилены");
//        } catch (Exception err) {
//            JOptionPane.showMessageDialog(this, "Оп-оп, ощибочка при отправке...: " + err);
//        }
//    }
//
//    private void buttonDSS(ActionEvent e) {
//        new DebugServerScriptingFrame();
//    }
//
//    public static void textAreaAdd(byte b) {
//        textAreaConsole.append(String.valueOf(b));
//    }
//
//    public static void textAreaAdd(char b) {
//        textAreaConsole.append(String.valueOf(b));
//    }
//
//    private void button6ActionPerformed(ActionEvent e) {
//        portHandler.close();
//        try {
//            portHandler = new PortHandler();
//        } catch (Exception e1) {
//            e1.printStackTrace();
//        }
//        JOptionPane.showMessageDialog(this, "Done");
//    }
//
//    private void button7ActionPerformed(ActionEvent e) {
//        try {
//            portHandler.fileStream.flush();
//            portHandler.fileStream.close();
//        } catch (IOException e1) {
//            e1.printStackTrace();
//        }
//    }
//
//    private void buttonStartSendingDssSpeed(ActionEvent e) {
//        this.speeds = new SenderAnglesSpeedsFromFile();
//        JOptionPane.showMessageDialog(this, "Done");
//    }
//
//    private void buttonClearAnglesSpeedListAndBreak(ActionEvent e) {
//        this.speeds.doIt = false;
//        anglesSpeedToSendVIAdss.clear();
//        JOptionPane.showMessageDialog(this, "Done");
//    }
//
//
//    private void initComponents() throws IOException {
//
//
//        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
//        // Generated using JFormDesigner Evaluation license - Roman Kosyiy
//        window1 = new JWindow();
//
//        //======== window1 ========
//        {
//            Container window1ContentPane = window1.getContentPane();
//
//            GroupLayout window1ContentPaneLayout = new GroupLayout(window1ContentPane);
//            window1ContentPane.setLayout(window1ContentPaneLayout);
//            window1ContentPaneLayout.setHorizontalGroup(
//                window1ContentPaneLayout.createParallelGroup()
//                    .addGap(0, 415, Short.MAX_VALUE)
//            );
//            window1ContentPaneLayout.setVerticalGroup(
//                window1ContentPaneLayout.createParallelGroup()
//                    .addGap(0, 0, Short.MAX_VALUE)
//            );
//            window1.pack();
//            window1.setLocationRelativeTo(window1.getOwner());
//        }
//        // JFormDesigner - End of component initialization  //GEN-END:initComponents
//        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
//        DefaultCaret caret = (DefaultCaret) textAreaConsole.getCaret();
//        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
//    }
//
//    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
//    // Generated using JFormDesigner Evaluation license - Roman Kosyiy
//    public static JWindow window1;
//    // JFormDesigner - End of variables declaration  //GEN-END:variables
//
//
//}
