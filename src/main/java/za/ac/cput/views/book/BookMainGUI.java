package za.ac.cput.views.book;

import za.ac.cput.views.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookMainGUI extends JFrame implements ActionListener {
    //SAME ORDER:
    // View All Users, Add new User , update user, delete user

    //Menu:
    // Add Book
    // View All Books
    // Update Book
    // Delete Book

    //BookGenre - Add, view, update, delete
    //1. Set up objects (private labels, buttons, textfields)
    private JLabel lblMenuName;
    private JButton btnAddBook;
    private JButton btnGetBook;
    private JButton btnUpdateBook;
    private JButton btnDeleteBook;
    private JLabel  lblPadding;
    private JButton btnExit;

    public BookMainGUI(){
        super("Library Loan Application");
        lblMenuName = new JLabel("Book Menu", (int) CENTER_ALIGNMENT);
        btnAddBook = new JButton("Add a New Book");
        btnGetBook = new JButton("View All Books");
        btnUpdateBook = new JButton("Update Book Information");
        btnDeleteBook = new JButton("Delete a Book");
        lblPadding = new JLabel("             ");
        btnExit = new JButton("Exit");
    }

    public void setBookGUI(){
        this.setLayout(new GridLayout(7,1));
        this.add(lblMenuName);

        this.add(btnAddBook);
        btnAddBook.addActionListener(this);
        this.add(btnGetBook);
        //actionList
        this.add(btnUpdateBook);
        //actionList
        this.add(btnDeleteBook);
        //actionList


        this.add(lblPadding);

        this.add(btnExit);
        btnExit.addActionListener(this);

        this.setPreferredSize(new Dimension(300, 300));

        this.pack();
        this.setLocationRelativeTo(null); // Center screen
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnAddBook) {
            // Reference custom method here
            JOptionPane.showMessageDialog(null,"Book Menu Option Selected");
            // Call to user package and the UserMainGUI to show CRUD menu for that entity
        }
        if (e.getSource() == btnExit) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new BookMainGUI().setBookGUI();
    }
}
