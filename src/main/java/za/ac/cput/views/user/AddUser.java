package za.ac.cput.views.user;

import com.google.gson.Gson;
import okhttp3.*;
import za.ac.cput.entity.User;
import za.ac.cput.factory.UserFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/*  AddUser.java
    GUI for Add function - User entity
    Author: Adriaan Burger(219014868)
    Date: October 2021
 */
public class AddUser extends JFrame implements ActionListener {
    //GUI for adding new Users

    public static final MediaType JSON =
            MediaType.get("application/json; charset=utf-8");

    private static OkHttpClient client = new OkHttpClient();

    private JLabel lblMenuName;

    private JLabel lblName;
    private JLabel lblSurname;
    private JLabel lblEmail;
    private JLabel lblNumber;
    private JLabel lblAddress;

    private JTextField txtName;
    private JTextField txtSurname;
    private JTextField txtEmail;
    private JTextField txtNumber;
    private JTextField txtAddress;

    private JLabel  lblPadding;
    private JLabel  lblPadding1;
    private JLabel  lblPadding2;

    private JButton btnSave;
    private JButton btnCancel;


    public AddUser(){
        super("Add new User");
        lblMenuName = new JLabel("Add a User", (int) CENTER_ALIGNMENT);

        lblName = new JLabel("First Name: ");
        lblSurname = new JLabel("Last Name: ");
        lblEmail = new JLabel("Email: ");
        lblNumber = new JLabel("Contact Number: ");
        lblAddress = new JLabel("Address: ");

        txtName = new JTextField();
        txtSurname = new JTextField();
        txtEmail = new JTextField();
        txtNumber = new JTextField();
        txtAddress = new JTextField();

        lblPadding = new JLabel("             ");
        lblPadding1 = new JLabel("             ");
        lblPadding2 = new JLabel("          ");

        btnSave = new JButton("Save");
        btnCancel = new JButton("Cancel");
    }

    public void setGUI(){
        this.setLayout(new GridLayout(8,2));
        this.add(lblMenuName);
        this.add(lblPadding2);

        this.add(lblName);
        this.add(txtName);

        this.add(lblSurname);
        this.add(txtSurname);

        this.add(lblEmail);
        this.add(txtEmail);

        this.add(lblNumber);
        this.add(txtNumber);

        this.add(lblAddress);
        this.add(txtAddress);

        this.add(lblPadding);
        this.add(lblPadding1);

        this.add(btnSave);
        btnSave.addActionListener(this);
        this.add(btnCancel);
        btnCancel.addActionListener(this);

        this.setPreferredSize(new Dimension(300, 300));

        this.pack();
        this.setLocationRelativeTo(null); // Center screen
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSave) {
            saveToDb(txtName.getText(),
                    txtSurname.getText(),
                    txtEmail.getText(),
                    txtNumber.getText(),
                    txtAddress.getText());
        } else if (e.getSource() == btnCancel) {
            UserMainGUI.main(null);
            this.setVisible(false);
        }

    }

    public void saveToDb(String fName, String lName, String email, String phoneNumber, String address) {
        try {
            final String URL = "http://localhost:8080/user/create";

            User user = UserFactory.createUser(fName, lName, email, phoneNumber, address);
            Gson g = new Gson();
            String jsonString = g.toJson(user);
            String r = post(URL, jsonString);
            if (r != null) {
                JOptionPane.showMessageDialog(null, "Success! User saved.");
                UserMainGUI.main(null);
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Oh no! User not saved.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public String post(final String url, String json) throws IOException {
        RequestBody body = RequestBody.create(json, JSON);
        Request request = new Request
                .Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
    public static void main(String[] args) {
        new AddUser().setGUI();
    }
}
