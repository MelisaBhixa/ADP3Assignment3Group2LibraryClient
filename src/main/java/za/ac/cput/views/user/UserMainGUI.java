package za.ac.cput.views.user;

import za.ac.cput.views.Menu;
import za.ac.cput.views.user.*;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*  UserMainGUI.java
    CRUD Menu for the User entity
    Author: Adriaan Burger(219014868)
    Date: October 2021
 */
public class UserMainGUI extends JFrame implements ActionListener {
    //Main Menu for User Config with options:
    // View All Users, Add new User , update user, delete user

    public static final MediaType JSON
            =MediaType.get("application/json; charset=utf-8");

    private static OkHttpClient client = new OkHttpClient();

    //1. Set up objects (private labels, buttons, textfields)
    private JLabel lblHeading;
    private JButton btnGetUsers;
    private JButton btnAddUsers;
    private JButton btnUpdateUsers;
    private JButton btnDeleteUsers;
    private JLabel  lblPadding;
    private JButton btnBack;

    //2. Instantiate objects
    public UserMainGUI(){
        super("Library Loan Application - User Main Menu");
        lblHeading = new JLabel("Users", (int) CENTER_ALIGNMENT);
        btnGetUsers = new JButton("View All Users");
        btnAddUsers = new JButton("Add new User");
        btnUpdateUsers = new JButton("Update User");
        btnDeleteUsers = new JButton("Delete User");
        lblPadding = new JLabel("             ");
        btnBack = new JButton("Back");
    }

    public void setGUI(){
        this.setLayout(new GridLayout(7,1));

        this.add(lblHeading);

        this.add(btnGetUsers);
        btnGetUsers.addActionListener(this);
        this.add(btnAddUsers);
        btnAddUsers.addActionListener(this);
        this.add(btnUpdateUsers);
        btnUpdateUsers.addActionListener(this);
        this.add(btnDeleteUsers);
        btnDeleteUsers.addActionListener(this);

        this.add(lblPadding);
        this.add(btnBack);
        btnBack.addActionListener(this);

        this.setPreferredSize(new Dimension(500, 300));

        this.pack();
        this.setLocationRelativeTo(null); // Center screen
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()){
            case "View All Users": // Go to GetUsers
                GetUsers.main(null);
                this.setVisible(false);
                break;
            case "Add new User": // Go to AddUser
                AddUser.main(null);
                this.setVisible(false);
                break;
            case "Update User": // Go to UpdateUser
                UpdateUser.main(null);
                this.setVisible(false);
                break;
            case "Delete User": // Go to DeleteUser
                DeleteUser.main(null);
                this.setVisible(false);
                break;
            case "Back": //Back to main menu
                Menu.main(null);
                this.setVisible(false);
                break;
        }
    }

    //3.Run with main method
    public static void main(String[] args) {
        new UserMainGUI().setGUI();
    }
}
