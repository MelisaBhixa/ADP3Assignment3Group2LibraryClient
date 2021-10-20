package za.ac.cput.views.book;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class deleteBook extends JFrame implements ActionListener {

    private JLabel lblMenuName;
    private JLabel lblId;
    private JTextField txtId;
    private JLabel lblAuthor;
    private JTextField txtAuthor;
    private JLabel lblName;
    private JTextField txtName;
    private JLabel  lblPadding;
    private JLabel  lblPadding1;
    private JLabel  lblPadding2;
    private JButton btnConfirm;
    private JButton btnExit;

    public deleteBook (){
        super("Library Loan Application");
        lblMenuName = new JLabel("Delete a Book", (int) CENTER_ALIGNMENT);
        lblPadding2 = new JLabel("          ");

        lblId = new JLabel("Book ID: ");
        txtId = new JTextField();

        lblAuthor = new JLabel("Author Name: ");
        txtAuthor = new JTextField();

        lblName = new JLabel("Book Name: ");
        txtName = new JTextField();

        lblPadding = new JLabel("             ");
        lblPadding1 = new JLabel("             ");

        btnConfirm = new JButton("Confirm");
        btnExit = new JButton("Exit");
    }

    public void setDeleteBookGUI() {
        this.setLayout(new GridLayout(6,2));
        this.add(lblMenuName);
        this.add(lblPadding2);

        this.add(lblId);
        this.add(txtId);

        this.add(lblAuthor);
        this.add(txtAuthor);

        this.add(lblName);
        this.add(txtName);

        this.add(lblPadding);
        this.add(lblPadding1);

        this.add(btnConfirm);
        btnConfirm.addActionListener(this);
        this.add(btnExit);

        this.setPreferredSize(new Dimension(300, 300));

        this.pack();
        this.setLocationRelativeTo(null); // Center screen
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnConfirm) {
            // Reference custom method here
            JOptionPane.showMessageDialog(null,"Book Deleted");
            // Call to user package and the UserMainGUI to show CRUD menu for that entity
        }
        if (e.getSource() == btnExit) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new deleteBook().setDeleteBookGUI();
    }
}
