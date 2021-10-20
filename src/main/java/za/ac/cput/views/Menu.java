package za.ac.cput.views;

import org.json.JSONArray;
import org.json.JSONObject;
import za.ac.cput.entity.BookLoanLog;
import za.ac.cput.factory.BookLoanLogFactory;
import za.ac.cput.views.user.UserMainGUI;
import com.google.gson.Gson;
import okhttp3.*;
import za.ac.cput.entity.User;
import za.ac.cput.factory.UserFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        btnLoanBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loan_book_menu();
            }
        });
        this.add(btnLoanBook);
        //actionList
        this.add(btnReturnBook);
        //actionList
        this.add(btnTrackBook);
        //actionList

        this.add(lblPadding);

        this.add(btnExit);
        btnExit.addActionListener(this);

        this.setPreferredSize(new Dimension(500, 300));

        this.pack();
        this.setLocationRelativeTo(null); // Center screen
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnUserConfig) {
            // Reference custom method here
            // JOptionPane.showMessageDialog(null,"User Config Menu Option Selected");
            // Call to user package and the UserMainGUI to show CRUD menu for that entity
            UserMainGUI.main(null);
            this.setVisible(false);
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


    public  void loan_book_menu() {
        JFrame f = new JFrame("Loan Book Menu");
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JButton update = new JButton("Update");
        update.setBounds(20, 60, 120, 25);

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateLoan();
            }

        });



        JButton add = new JButton("Add");//creating instance of JButton to view users
        add.setBounds(150, 20, 120, 25);//x axis, y axis, width, height

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addLoan();
            }

        });

        JButton delete = new JButton("Delete");
        delete.setBounds(280, 20, 160, 25);//x axis, y axis, width, height
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteLoan();
            }

        });



        JButton search = new JButton("Search"); //creating instance of JButton for Reports
        search.setBounds(450, 20, 130, 25);

        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchLoan();
            }

        });


        f.add(add);
        f.add(update);
        f.add(delete);
        f.add(search);
        f.setSize(600, 200);//400 width and 500 height
        f.setLayout(null);//using no layout managers
        f.setVisible(true);//making the frame visible
        f.setLocationRelativeTo(null);
    }

    public  void addLoan() {
        JFrame g = new JFrame("Add new Record");
        g.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JLabel l1, l2, l3, l4, l5, l6;

        l1 = new JLabel("User");  //label 1 for cust number
        l1.setBounds(30, 15, 100, 30);

        l2 = new JLabel("Book");  //label 2 for firstname
        l2.setBounds(30, 50, 100, 30);

        l3 = new JLabel("Lent From");  //label 3 for surname
        l3.setBounds(30, 85, 100, 30);

        l4 = new JLabel("Lent To");  //label 4 for Phone number
        l4.setBounds(30, 120, 100, 30);

        l5 = new JLabel("Checkout ?");  //label 4 for Phone number
        l5.setBounds(30, 155, 100, 30);



        JTextField  F_user = new JTextField ();
        F_user.setBounds(110, 15, 200, 30);
        F_user.setText("Auto-generated");
        F_user.setDisabledTextColor(Color.gray);


        JTextField F_book = new JTextField();
        F_book.setBounds(110, 50, 200, 30);
        F_user.setText("Auto-generated");
        F_user.setDisabledTextColor(Color.gray);


        //set text field for surname
        JTextField F_lentfrom = new JTextField();
        F_lentfrom.setBounds(110, 85, 200, 30);

        //set text field for phone number
        JTextField F_lentto = new JTextField();
        F_lentto.setBounds(110, 120, 200, 30);

        //set text field for phone number

        JRadioButton F_ischeckout = new JRadioButton();
        F_ischeckout.setBounds(110, 155, 200, 30);



        JButton create_but = new JButton("Save");//creating instance of JButton for Create
        create_but.setBounds(130, 190, 80, 25);



        ActionListener addLoan = new ActionListener() {
            Runnable addLoan = new Runnable() {
                @Override
                public void run() {
                    String lent_from_date = F_lentfrom.getText();
                    String lent_to_date = F_lentto.getText();
                    boolean ischeckout = F_ischeckout.isSelected();

                    try{

                        final String url = "http://localhost:8080/loan/create/";
                        BookLoanLog bookLoanLog = BookLoanLogFactory.createBookLoanLog(lent_from_date,lent_to_date,ischeckout);
                        Gson g = new Gson();
                        String jsonString = g.toJson(bookLoanLog);
                        String r = go(url, jsonString);
                        if(r != null){
                            JOptionPane.showMessageDialog(null,"Successfuly saved");
                            //System.out.println(bookLoanLogo);
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Sorry, could not save");
                        }
                    }
                    catch(Exception e){
                        JOptionPane.showMessageDialog(null,e.getMessage());
                    }



                }

            };

            @Override
            public void actionPerformed(ActionEvent e) {
                new Thread(addLoan).start();
            }

        };

        create_but.addActionListener(addLoan);

        g.add(create_but);

        g.add(l1);
        g.add(l2);
        g.add(l3);
        g.add(l4);
        g.add(l5);
        g.add(F_user);
        g.add(F_book);
        g.add(F_lentfrom);
        g.add(F_lentto);
        g.add(F_ischeckout);
        g.setSize(500, 400);//400 width and 500 height
        g.setLayout(null);//using no layout managers
        g.setVisible(true);//making the frame visible
        g.setLocationRelativeTo(null);
    }

    public String go(final String url, String json) throws IOException {
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

    public void updateLoan(){

        JFrame f = new JFrame("Update Record");
        JPanel panelCenter = new JPanel();
        JPanel panelLeftCenter = new JPanel();
        JPanel panelGlobal = new JPanel(new GridLayout(0, 2));
        JTable loan_list = new JTable();
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JLabel l1, l2, l3,l4,l5;

        l1 = new JLabel("User Id");  //label 1 for cust number
        l1.setBounds(30, 15, 100, 30);

        l2 = new JLabel("Book Id");  //label 2 for firstname
        l2.setBounds(30, 50, 100, 30);

        l3 = new JLabel("Lent from");  //label 3 for surname
        l3.setBounds(30, 85, 100, 30);

        l4 = new JLabel("Lent To");  //label 3 for surname
        l4.setBounds(30, 120, 100, 30);

        l5 = new JLabel("Is Checkout ?");  //label 3 for surname
        l5.setBounds(30, 155, 100, 30);

        //set text field for cust number
        JTextField F_user = new JTextField();
        F_user.setBounds(110, 15, 200, 30);

        //set text field for firstname
        JTextField F_book = new JTextField();
        F_book.setBounds(110, 50, 200, 30);

        //set text field for surname
        JTextField F_lentfrom = new JTextField();
        F_lentfrom.setBounds(110, 85, 200, 30);

        JTextField F_lentto = new JTextField();
        F_lentto.setBounds(110, 120, 200, 30);

        //set radio button for can rent
        JRadioButton F_ischeckout = new JRadioButton();
        F_ischeckout.setBounds(110, 155, 200, 30);


        JButton btn_update = new JButton("Update");//creating instance of JButton for Create
        btn_update.setBounds(130, 190, 80, 25);

        try {

            DefaultTableModel loan_model = new DefaultTableModel();
            loan_model.addColumn("User");
            loan_model.addColumn("Book");
            loan_model.addColumn("Lent from");
            loan_model.addColumn("Lent to");
            loan_model.addColumn("Checkout");

            final String URL = "http://localhost:8080/loan/getAll";
            String responseBody = run(URL);
            JSONArray loans = new JSONArray(responseBody);

            for (int i = 0; i < loans.length(); i++) {
                JSONObject bookLoan = loans.getJSONObject(i);

                Gson g = new Gson();
                BookLoanLog bl = g.fromJson(bookLoan.toString(), BookLoanLog.class);

                Object[] rowData = new Object[5];
                rowData[0] = bl.getUserId();
                rowData[1] = bl.getBookId();
                rowData[2] = bl.getLentFromDate();
                rowData[3] = bl.getLentToDate();
                rowData[4] = bl.isCheckOut();
                loan_model.addRow(rowData);
            }



            loan_list.setModel(loan_model);
            JScrollPane scrollPane = new JScrollPane(loan_list);

            ActionListener updateLoan = new ActionListener() {
                Runnable updateLoan = new Runnable() {
                    @Override
                    public void run() {
                        String user = F_user.getText();
                        String book = F_book.getText();
                        String lentfrom = F_lentfrom.getText();
                        String lentto = F_lentto.getText();
                        boolean ischeckout = F_ischeckout.isSelected();


                        try{
                            final String URL = "http://localhost:8080/user/update";
                            BookLoanLog bookLoanLog = BookLoanLogFactory.createBookLoanLog(lentfrom,lentto,ischeckout);
                            Gson g = new Gson();
                            String jsonString = g.toJson(user);
                            String u = go(URL, jsonString);
                            if(u != null)
                                JOptionPane.showMessageDialog(null, "Successfully Updated");
                            else
                                JOptionPane.showMessageDialog(null,"Could not update");

                        }catch (Exception e){
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }

                };

                @Override
                public void actionPerformed(ActionEvent e) {
                    new Thread(updateLoan).start();
                }

            };

            btn_update.addActionListener(updateLoan);

            loan_list.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int selectedRow = loan_list.getSelectedRow();
                    String user = String.valueOf(loan_list.getValueAt(selectedRow, 0));
                    String book = String.valueOf(loan_list.getValueAt(selectedRow, 1));
                    String lentfrom = String.valueOf(loan_list.getValueAt(selectedRow, 2));
                    String lentto = String.valueOf(loan_list.getValueAt(selectedRow, 3));
                    boolean ischeckout = Boolean.parseBoolean(String.valueOf(loan_list.getValueAt(selectedRow, 4)));

                    F_user.setText(String.valueOf(user));
                    F_book.setText(book);
                    F_lentfrom.setText(lentfrom);
                    F_lentto.setText(lentto);
                    F_ischeckout.setSelected(ischeckout);

                }



                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }

            });

            panelCenter.add(scrollPane);
            panelLeftCenter.add(l1);
            panelLeftCenter.add(l2);
            panelLeftCenter.add(l3);
            panelLeftCenter.add(l4);
            panelLeftCenter.add(l5);
            panelLeftCenter.add(F_user);
            panelLeftCenter.add(F_book);
            panelLeftCenter.add(F_lentfrom);
            panelLeftCenter.add(F_lentto);
            panelLeftCenter.add(F_ischeckout);
            panelLeftCenter.add(btn_update);
            panelLeftCenter.setLayout(null);
            panelLeftCenter.setBounds(0, 100, 300, 300);
            panelCenter.setBounds(300, 100, 300, 300);
            //panelLeftCenter.setBackground(Color.red);

            panelGlobal.add(panelLeftCenter);
            panelGlobal.add(panelCenter);

            f.add(panelGlobal, BorderLayout.CENTER);
            f.setSize(1000, 700); //set size for frame
            f.setVisible(true);
            f.setLocationRelativeTo(null);

        } catch (IOException ex) {
            System.err.println(ex);
        }//

        catch (Exception ex) {
            System.err.println(ex);
        }

    }

    public String run(String url) throws IOException{
        Request request = new Request.
                Builder()
                .url(url)
                .build();
        try(Response response = client.newCall(request).execute()){
            return response.body().string();
        }
    }

    public static void deleteLoan(){

    }

    public static void searchLoan(){

    }


    //3.Run with main method
    public static void main(String[] args) {
        new Menu().setGUI();
    }
}
