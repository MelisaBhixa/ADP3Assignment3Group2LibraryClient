package za.ac.cput.views;

import com.google.gson.Gson;
import okhttp3.*;
import za.ac.cput.entity.User;
import za.ac.cput.factory.UserFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/*  Menu.java
    Menu GUI for the Library Loan Application
    Author: Group02 & Adriaan Burger(219014868)
    Date: October 2021
 */
public class Menu extends JFrame implements ActionListener {

    public static final MediaType JSON
            =MediaType.get("application/json; charset=utf-8");

    private static OkHttpClient client = new OkHttpClient();

    //1. Set up objects (private labels, buttons, textfields)
    private JLabel lblMenuName;
    private JButton btnUserConfig;
    private JButton btnAuthors;
    private JButton btnBooks;
    private JButton btnLoanBook;
    private JButton btnReturnBook;
    private JButton btnTrackBook;
    private JLabel  lblPadding;
    private JButton btnExit;

    //2. Instantiate objects
    public Menu(){
        super("Library Loan Application");
        lblMenuName = new JLabel("Library Loan Application", (int) CENTER_ALIGNMENT);
        btnUserConfig = new JButton("User Configuration");
        btnAuthors = new JButton("Authors");
        btnBooks = new JButton("Books");
        btnLoanBook = new JButton("Loan Book");
        btnReturnBook = new JButton("Return Book");
        btnTrackBook = new JButton("Track Book");
        lblPadding = new JLabel("             ");
        btnExit = new JButton("Exit");
    }

    public void setGUI(){
        this.setLayout(new GridLayout(9,1));
        this.add(lblMenuName);

        this.add(btnUserConfig);
        btnUserConfig.addActionListener(this);
        this.add(btnAuthors);
        //actionList
        this.add(btnBooks);
        //actionList
        this.add(btnLoanBook);
        //actionList
        this.add(btnReturnBook);
        //actionList
        this.add(btnTrackBook);
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
        if(e.getSource() == btnUserConfig) {
            // Reference custom method here
            JOptionPane.showMessageDialog(null,"User Config Menu Option Selected");
            // Call to user package and the UserMainGUI to show CRUD menu for that entity
        }
        if (e.getSource() == btnExit) {
            System.exit(0);
        }
    }

    // Custom methods:

    // saveToDB
    // These type of functions will be moved to relevant entity's package
    public void saveToDB(String name, String surname, String cellNum, String email, String address){
        try{
            final String URL = "http://localhost:8080/user/create";
            User user = UserFactory.createUser(name, surname, cellNum, email, address);
            Gson g = new Gson();
            String jsonString = g.toJson(user);
            String u = post(URL, jsonString);
            if(u != null)
                JOptionPane.showMessageDialog(null, "Successfully Saved");
            else
                JOptionPane.showMessageDialog(null,"Could not save");

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    // Post method
    public String post(final String url, String json) throws IOException{
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try(Response response = client.newCall(request).execute()){
            return response.body().string();
        }
    }

    //3.Run with main method
    public static void main(String[] args) {
        new Menu().setGUI();
    }
}
