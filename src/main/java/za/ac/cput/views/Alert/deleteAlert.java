package za.ac.cput.views.Alert;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class deleteAlert extends JFrame implements ActionListener {
    private JLabel lblHeading;
    private JLabel lblAlertId;
    private JLabel lblPadding;
    private JLabel lblPadding1;
    private JLabel lblPadding2;
    private JButton btnConfirm;
    private JButton btnExit;

    public deleteAlert(JLabel lblheading) {
        super("Library Loan Application");
        lblheading = new JLabel("Delete Alert", (int) CENTER_ALIGNMENT);
        lblPadding2 = new JLabel("          ");

        lblPadding = new JLabel("             ");
        lblPadding1 = new JLabel("             ");

        btnConfirm = new JButton("Confirm");
        btnExit = new JButton("Exit");
    }

    public void setDeleteBookGUI() {
        this.setLayout(new GridLayout(6, 2));
        this.add(lblHeading);
        this.add(lblPadding2);

        this.add(lblPadding);
        this.add(lblPadding1);

        this.add(btnConfirm);
        btnConfirm.addActionListener(this);
        this.add(btnExit);

        this.setPreferredSize(new Dimension(300, 300));

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnConfirm) {

            JOptionPane.showMessageDialog(null, "Book Deleted");
        }
        if (e.getSource() == btnExit) {
            System.exit(0);
        }
    }

    public static void main(String[] args, JLabel lblheading) {
        new deleteAlert(lblheading).setDeleteAlertGUI();
    }

    private void setDeleteAlertGUI() {
    }
}
