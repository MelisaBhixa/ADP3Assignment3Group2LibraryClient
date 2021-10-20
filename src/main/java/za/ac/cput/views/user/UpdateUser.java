package za.ac.cput.views.user;

import okhttp3.OkHttpClient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*  UpdateUser.java
    GUI for Update function - User entity
    Author: Adriaan Burger(219014868)
    Date: October 2021
 */
public class UpdateUser extends JFrame implements ActionListener {
    //show table of users and edit field on the same window, save button, back button (back to UserMainGUI.main)
    private static OkHttpClient client = new OkHttpClient();

    @Override
    public void actionPerformed(ActionEvent e) {
        // Future implementation - watch this space :)
    }

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null,"UpdateUser reached");
    }

}
