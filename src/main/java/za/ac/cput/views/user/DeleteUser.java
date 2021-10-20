package za.ac.cput.views.user;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*  DeleteUser.java
    GUI for Delete function - User entity
    Author: Adriaan Burger(219014868)
    Date: October 2021
 */
public class DeleteUser extends JFrame implements ActionListener {
    //Show table and ask for id of user to delete (text field)

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "DeleteUser reached");
    }

}
