package za.ac.cput.views.Alert;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlertMainGUI extends JFrame implements ActionListener {
    private JLabel lblHeading;
    private JButton btnAddAlert;
    private JButton btnGetAlert;
    private JButton btnUpdateAlert;
    
    private JButton btnDeleteAlert;
    private JLabel lblPadding;
    private JButton btnExit;
    private AlertMainGUI DeleteAlert;


    public AlertMainGUI() {
       super("Library Loan Application");
        lblHeading = new JLabel("Alert", (int) CENTER_ALIGNMENT);
        btnAddAlert = new JButton("Add new Alert");
        btnUpdateAlert = new JButton("Update Alert");
        btnDeleteAlert = new JButton("Delete Alert");
        btnGetAlert = new JButton("View All Alerts");
        lblPadding = new JLabel("             ");
        btnExit = new JButton("Exit");
    }

    public void setAlertGUI() {
        this.setLayout(new GridLayout(7,1));
        this.add(lblHeading);

        this.add(btnAddAlert);
        btnAddAlert.addActionListener(this);
        this.add(btnUpdateAlert);
        btnUpdateAlert.addActionListener(this);
        this.add(btnDeleteAlert);
        btnDeleteAlert.addActionListener(this);
        this.add(btnGetAlert);
        btnGetAlert.addActionListener(this);

        this.add(lblPadding);
        this.add(btnExit);
        btnExit.addActionListener(this);

        this.setPreferredSize(new Dimension(400, 300));
        this.pack();
        this.setLocationRelativeTo(null); // Center screen
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object btnAlert = null;
        if(e.getSource() == btnAlert) {
            JOptionPane.showMessageDialog(null,"Alert Menu selected");

        }
        if (e.getSource() == btnExit) {
            System.exit(0);
        }
    }


    public static void main(String[] args) {
        new AlertMainGUI().setAlertGUI();
    }
}
