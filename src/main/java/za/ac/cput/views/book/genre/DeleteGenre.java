package za.ac.cput.views.book.genre;

import za.ac.cput.views.book.deleteBook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteGenre extends JFrame implements ActionListener
{

    private JLabel MenuName;
    private JLabel lblId;
    private JTextField txtId;
    private JLabel lblGenreName;
    private JTextField txtGenreName;
    private JLabel  lblPadding;
    private JLabel  lblPadding1;
    private JLabel  lblPadding2;
    private JButton btnConfirm;
    private JButton btnExit;

    public DeleteGenre (){
        super("Library Loan Application");
        MenuName = new JLabel("Delete Genre", (int) CENTER_ALIGNMENT);
        lblPadding2 = new JLabel("          ");

        lblId = new JLabel("Genre Id: ");
        txtId = new JTextField();

        lblGenreName = new JLabel("Genre Name: ");
        txtGenreName = new JTextField();

        lblPadding = new JLabel("             ");
        lblPadding1 = new JLabel("             ");

        btnConfirm = new JButton("Confirm");
        btnExit = new JButton("Exit");
    }

    public void setDeleteGenreGUI() {
        this.setLayout(new GridLayout(6,2));
        this.add(MenuName);
        this.add(lblPadding2);

        this.add(lblId);
        this.add(txtId);

        this.add(lblGenreName);
        this.add(txtGenreName);


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
            JOptionPane.showMessageDialog(null,"Genre Deleted");
            // Call to user package and the UserMainGUI to show CRUD menu for that entity
        }
        if (e.getSource() == btnExit) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new DeleteGenre().setDeleteGenreGUI();
    }
}


