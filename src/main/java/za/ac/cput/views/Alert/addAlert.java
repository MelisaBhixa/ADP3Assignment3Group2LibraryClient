package za.ac.cput.views.Alert;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addAlert extends JFrame implements ActionListener {

    private JLabel lblHeading;
    private JLabel lblAlertId;
    private JLabel  lblPadding;
    private JLabel  lblPadding1;
    private JLabel  lblPadding2;
    private JButton btnSave;
    private JButton btnExit;

   public addAlert(JLabel lblheading) {
       super("Library Loan Application");
       lblheading = new JLabel("Add Alert", (int) CENTER_ALIGNMENT);

       lblPadding2 = new JLabel("          ");
       lblPadding = new JLabel("             ");
       lblPadding1 = new JLabel("             ");

       btnSave = new JButton("Save");
       btnExit = new JButton("Exit");
   }

   public void setAddBookGUI() {
       this.setLayout(new GridLayout(12,2));
       this.add(lblHeading);
       this.add(lblPadding2);

       this.add(lblPadding);
       this.add(lblPadding1);

       this.add(btnSave);
       btnSave.addActionListener(this);
       this.add(btnExit);
       btnExit.addActionListener(this);

       this.setPreferredSize(new Dimension(300, 300));

       this.pack();
       this.setLocationRelativeTo(null);
       this.setVisible(true);
   }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSave) {
            JOptionPane.showMessageDialog(null, "Alert Saved");
        }
        if (e.getSource() == btnExit) {
            System.exit(0);
        }
    }

    public static void main(String[] args, JLabel lblheading) {
        new addAlert(lblheading).setAddAlertGUI();
    }

    private void setAddAlertGUI() {
    }
}



