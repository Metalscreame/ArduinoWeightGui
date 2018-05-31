/*
 * Created by JFormDesigner on Thu May 31 09:35:41 EEST 2018
 */

package GUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
import javax.swing.table.*;

/**
 * @author Roman Kosyiy
 */
public class MainWindow extends JFrame {
    public MainWindow() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Roman Kosyiy
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        panel1 = new JPanel();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        panel2 = new JPanel();
        scrollPane1 = new JScrollPane();
        DataTable1 = new JTable();

        //======== this ========
        setVisible(true);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));

            // JFormDesigner evaluation mark
            dialogPane.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), dialogPane.getBorder())); dialogPane.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {

                //======== panel1 ========
                {

                    //---- button1 ----
                    button1.setText("text");

                    //---- button2 ----
                    button2.setText("text");

                    //---- button3 ----
                    button3.setText("text");

                    GroupLayout panel1Layout = new GroupLayout(panel1);
                    panel1.setLayout(panel1Layout);
                    panel1Layout.setHorizontalGroup(
                        panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(button1, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                                    .addComponent(button2, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                                    .addComponent(button3, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE))
                                .addContainerGap())
                    );
                    panel1Layout.setVerticalGroup(
                        panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(button1)
                                .addGap(18, 18, 18)
                                .addComponent(button2)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 553, Short.MAX_VALUE)
                                .addComponent(button3)
                                .addContainerGap())
                    );
                }

                //======== panel2 ========
                {
                    panel2.setFont(new Font("Segoe UI", Font.PLAIN, 16));

                    //======== scrollPane1 ========
                    {

                        //---- DataTable1 ----
                        DataTable1.setModel(new DefaultTableModel(
                            new Object[][] {
                                {null, null},
                                {null, null},
                                {null, null},
                                {null, null},
                                {null, null},
                                {null, null},
                                {null, null},
                            },
                            new String[] {
                                "\u041d\u043e\u043c\u0435\u0440", "\u0417\u043d\u0430\u0447\u0435\u043d\u0438\u0435"
                            }
                        ));
                        DataTable1.setAlignmentX(1.5F);
                        DataTable1.setRowMargin(3);
                        DataTable1.setFont(DataTable1.getFont().deriveFont(DataTable1.getFont().getSize() + 4f));
                        scrollPane1.setViewportView(DataTable1);
                    }

                    GroupLayout panel2Layout = new GroupLayout(panel2);
                    panel2.setLayout(panel2Layout);
                    panel2Layout.setHorizontalGroup(
                        panel2Layout.createParallelGroup()
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(763, Short.MAX_VALUE))
                    );
                    panel2Layout.setVerticalGroup(
                        panel2Layout.createParallelGroup()
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(473, Short.MAX_VALUE))
                    );
                }

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addContainerGap())
                );
            }
            dialogPane.add(contentPanel, BorderLayout.NORTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Roman Kosyiy
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JPanel panel1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JPanel panel2;
    private JScrollPane scrollPane1;
    private JTable DataTable1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
