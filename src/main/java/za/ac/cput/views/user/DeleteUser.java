package za.ac.cput.views.user;

import com.google.gson.Gson;
import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;
import za.ac.cput.entity.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Objects;

/*  DeleteUser.java
    GUI for Delete function - User entity
    Author: Adriaan Burger(219014868)
    Date: October 2021
 */
public class DeleteUser extends JFrame implements ActionListener {
    //Show table and ask for id of user to delete (text field)
    private static OkHttpClient client = new OkHttpClient();

    private JLabel lblHeader;

    private JTable viewTable;
    private JPanel pCenter;
    private JPanel pSouth;

    private JLabel lblBlank1;
    private JLabel lblBlank2;
    private JLabel lblBlank3;
    private JLabel lblBlank4;

    private JLabel lblDelete;
    private JButton btnDelete;
    private JTextField txtDeleteId;
    private JButton btnBack;

    public DeleteUser(){
        super("Delete User");
        lblHeader = new JLabel("Delete a User", (int) CENTER_ALIGNMENT);
        viewTable = new JTable();

        pCenter = new JPanel();
        pSouth = new JPanel();

        btnDelete = new JButton("Delete");
        btnBack = new JButton("Back");

        lblDelete = new JLabel("Enter User ID to Delete: ");
        txtDeleteId = new JTextField();

        lblBlank1 = new JLabel("");
        lblBlank2 = new JLabel("");
        lblBlank3 = new JLabel("");
        lblBlank4 = new JLabel("");
    }

    public void setGUI(){
        pCenter.setLayout(new GridLayout(2,1));
        pSouth.setLayout(new GridLayout(4,2));

        pCenter.add(lblHeader);
        pCenter.add(viewTable);

        pSouth.add(lblBlank1);
        pSouth.add(lblBlank2);

        pSouth.add(lblDelete);
        pSouth.add(txtDeleteId);

        pSouth.add(lblBlank3);
        pSouth.add(lblBlank4);

        pSouth.add(btnBack);
        btnBack.addActionListener(this);
        pSouth.add(btnDelete);
        btnDelete.addActionListener(this);

        displayTable();

        this.add(pCenter, BorderLayout.CENTER);
        this.add(pSouth, BorderLayout.SOUTH);

        viewTable.setRowHeight(25);
        this.add(new JScrollPane(viewTable));
        this.setPreferredSize(new Dimension(1000, 300));
        this.pack();
        this.setLocationRelativeTo(null); // Center screen
        this.setVisible(true);
    }

    public void displayTable(){
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
    public boolean deleteFromDb(String id) throws IOException {
        final String URL = "http://localhost:8080/user/delete/" + id;
        RequestBody body = RequestBody
                .create( "charset=utf-8", MediaType.parse("application/json"));
        Request request = new Request.Builder()
                .post(body)
                .addHeader("Accept", "application/json")
                .url(URL)
                .build();

        Response response = client.newCall(request).execute();
        return response.isSuccessful();
    }
    private static String run(String url) throws IOException {
        Request request = new Request
                .Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnDelete) {
            // If there is a value in txtDeleteId:
            if(!Objects.equals(txtDeleteId.getText(), "")){
                 //Ask if they are sure and then deletes entity
                int userConfirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?",
                        "Delete User", JOptionPane.YES_NO_OPTION);
                if (userConfirm == JOptionPane.YES_OPTION) {
                    try {
                        if(deleteFromDb(txtDeleteId.getText())) {
                            JOptionPane.showMessageDialog(null,"User Deleted");
                            UserMainGUI.main(null);
                            this.setVisible(false);
                        }
                        else {
                            JOptionPane.showMessageDialog(null,"Error: User Not Deleted");
                        }
                    }
                    catch (IOException IOe) {
                        IOe.printStackTrace();
                    }
                }
            }
            else { // When there is no value in txtDeleteId:
                JOptionPane.showMessageDialog(null, "Please enter a value");
            }
        }
        else if (e.getSource() == btnBack) {
            UserMainGUI.main(null);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new DeleteUser().setGUI();
    }
}
