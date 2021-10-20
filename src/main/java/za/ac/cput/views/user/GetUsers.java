package za.ac.cput.views.user;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import za.ac.cput.entity.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/*  GetUser.java
    GUI for ViewAll(get) function - User entity
    Author: Adriaan Burger(219014868)
    Date: October 2021
 */
public class GetUsers extends JFrame implements ActionListener {
    // Display table of users

    private static OkHttpClient client = new OkHttpClient();

    private JTable viewTable;
    private JPanel pCenter;
    private JPanel pSouth;
    private JButton btnBack;

    public GetUsers(){
        super("All Users");
        viewTable = new JTable();

        pCenter = new JPanel();
        pSouth = new JPanel();

        btnBack = new JButton("Back");
    }

    public void setGUI(){
        pCenter.setLayout(new GridLayout(1,1));
        pSouth.setLayout(new GridLayout(1,1));
        pCenter.add(viewTable);
        pSouth.add(btnBack);
        this.add(pCenter, BorderLayout.CENTER);
        this.add(pSouth, BorderLayout.SOUTH);

        btnBack.addActionListener(this);

        getAll();
        viewTable.setRowHeight(25);
        this.add(new JScrollPane(viewTable));

        this.setPreferredSize(new Dimension(1000, 300));

        this.pack();
        this.setLocationRelativeTo(null); // Center screen
        this.setVisible(true);
    }

    public void getAll() {
        DefaultTableModel tModel = (DefaultTableModel) viewTable.getModel();
        tModel.addColumn("UserId");
        tModel.addColumn("Name");
        tModel.addColumn("Surname");
        tModel.addColumn("Email");
        tModel.addColumn("Number");
        tModel.addColumn("Address");

        try {
            final String URL = "http://localhost:8080/user/getAll";
            String responseBody = run(URL);
            JSONArray users = new JSONArray(responseBody);

            for (int i = 0; i < users.length(); i++) {
                JSONObject user = users.getJSONObject(i);

                Gson g = new Gson();
                User u = g.fromJson(user.toString(), User.class);

                Object[] rowData = new Object[6];
                rowData[0] = u.getUserID();
                rowData[1] = u.getName();
                rowData[2] = u.getSurname();
                rowData[3] = u.getEmail();
                rowData[4] = u.getCellphone();
                rowData[5] = u.getAddress();
                tModel.addRow(rowData);
            }
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    private static String run(String url) throws IOException{
        Request request = new Request.
                Builder()
                .url(url)
                .build();
        try(Response response = client.newCall(request).execute()){
            return response.body().string();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnBack) {
            UserMainGUI.main(null);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
       new GetUsers().setGUI();

    }

}
