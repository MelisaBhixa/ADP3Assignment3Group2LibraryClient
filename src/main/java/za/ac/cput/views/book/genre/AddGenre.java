package za.ac.cput.views.book.genre;

import za.ac.cput.views.book.addBook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddGenre extends JFrame implements ActionListener
{
    private JLabel MenuName;
    private JLabel lblGenreName;
    private JTextField txtGenreName;

    private JLabel  lblPadding;
    private JLabel  lblPadding1;
    private JLabel  lblPadding2;

    private JButton btnSave;
    private JButton btnExit;

    public AddGenre (){
        super("Library Loan Application");
        MenuName = new JLabel("Add a Genre", (int) CENTER_ALIGNMENT);
        lblPadding2 = new JLabel("          ");

        lblGenreName = new JLabel("Book Genre: ");
        txtGenreName= new JTextField();

        lblPadding1= new JLabel("          ");
        lblPadding= new JLabel("          ");

        btnSave = new JButton("Save");
        btnExit = new JButton("Exit");
    }

    public void setAddGenreGUI() {

        this.setLayout(new GridLayout(0,2));

        this.add(MenuName);
        this.add(lblPadding);

        this.add(lblGenreName);
        this.add(txtGenreName);

        this.add(lblPadding1);
        this.add(lblPadding2);



//        this.add(lblGenreName);
//        this.add(txtGenreName);





        this.add(btnSave);
        btnSave.addActionListener(this);
        this.add(btnExit);

        this.setPreferredSize(new Dimension(300, 300));

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnSave) {

            JOptionPane.showMessageDialog(null,"Genre added");

        }
        if (e.getSource() == btnExit) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new AddGenre().setAddGenreGUI();
    }
}


