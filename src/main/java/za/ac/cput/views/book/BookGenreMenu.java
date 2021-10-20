package za.ac.cput.views.book;

import com.google.gson.Gson;
import okhttp3.*;
import za.ac.cput.views.Menu;
//import za.ac.cput.views.book.genre.AddGenre;
import za.ac.cput.views.book.genre.DeleteGenre;
import za.ac.cput.views.book.genre.GetAllGenre;
import za.ac.cput.views.book.genre.UpdateGenre;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.DriverManager;

/*  Book Genre Menu.java
        Menu GUI for the Library Loan Application
        Author: Plamedie Bitota Bukasa 219260532
        Date: October 2021
     */
public class BookGenreMenu extends JFrame implements ActionListener {

        public static final MediaType JSON
            =MediaType.get("application/json; charset=utf-8");

        private static OkHttpClient client = new OkHttpClient();

        // (private labels, buttons, textfields)
        private JLabel lblMenuName;
        private JButton btnListAllGenre;
        private JButton btnAddGenre;
        private JButton btnUpdateGenre;
        private JButton btnDeleteGenre;
        private JLabel  lblPadding;
        private JButton btnExit;

        // Instantiate objects
        public BookGenreMenu(){
            super("Library Loan Application");
            lblMenuName = new JLabel("Book Genre Menu", (int) CENTER_ALIGNMENT);
            btnListAllGenre = new JButton("List all genre");
            btnAddGenre = new JButton("Add Genre");
            btnUpdateGenre = new JButton("Update  Genre ");
            btnDeleteGenre = new JButton("Delete Genre");
            lblPadding = new JLabel("             ");
            btnExit = new JButton("Back");
        }

        public void setGUI(){
            this.setLayout(new GridLayout(9,1));
            this.add(lblMenuName);

            this.add(btnListAllGenre);
            btnListAllGenre.addActionListener(this);

            this.add(btnAddGenre);
            btnAddGenre.addActionListener(this);

            this.add(btnUpdateGenre);
            btnUpdateGenre.addActionListener(this);

            this.add(btnDeleteGenre);
            btnDeleteGenre.addActionListener(this);

            this.add(lblPadding);
            this.add(btnExit);
            btnExit.addActionListener(this);


            this.setPreferredSize(new Dimension(500, 300));

            this.pack();
            this.setLocationRelativeTo(null);
            this.setVisible(true);
        }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()){
            case "List all genre":
                GetAllGenre.main(null);
                this.setVisible(false);
                break;
            case "Add  Genre": // Go to AddUser
//                AddGenre.main(null);
//                this.setVisible(false);
//                break;
//            case "Update Genre": // Go to UpdateUser
//                UpdateGenre.main(null);
//                this.setVisible(false);
//                break;
//            case "Delete Genre": // Go to DeleteUser
//                DeleteGenre.main(null);
//                this.setVisible(false);
//                break;
            case "Back": //Back to main menu
                BookGenreMenu.main(null);
                this.setVisible(false);
                break;
        }
        }


        public static void main(String[] args) {
            new za.ac.cput.views.book.BookGenreMenu().setGUI();
        }
    }

