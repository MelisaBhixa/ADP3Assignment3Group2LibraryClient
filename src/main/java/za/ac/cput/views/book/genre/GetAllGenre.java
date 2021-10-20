package za.ac.cput.views.book.genre;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import za.ac.cput.entity.BookGenre;
import za.ac.cput.entity.Genre;
import za.ac.cput.views.book.genre.GetAllGenre;
import za.ac.cput.views.book.BookGenreMenu;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GetAllGenre extends JFrame implements ActionListener {

    private static OkHttpClient client = new OkHttpClient();

    private JTable viewTable;
    private JPanel pCenter;
    private JPanel pSouth;
    private JButton btnBack;

    public GetAllGenre(){
        super("List all Genre");
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
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void getAll() {
        DefaultTableModel tModel = (DefaultTableModel) viewTable.getModel();
        tModel.addColumn("BookGenreId");
        tModel.addColumn("Name");


        try {
            final String URL = "http://localhost:8080/bookGenre/getAll";
            String responseBody = run(URL);
            JSONArray genres = new JSONArray(responseBody);

            for (int i = 0; i < genres.length(); i++) {
                JSONObject genre = genres.getJSONObject(i);

                Gson g = new Gson();
                Genre gr = g.fromJson(genre.toString(), Genre.class);

                Object[] rowData = new Object[2];
                rowData[0] = gr.getGenreId();
                rowData[1] = gr.getName();
                tModel.addRow(rowData);
            }
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    private static String run(String url) throws IOException {
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
            BookGenreMenu.main(null);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new GetAllGenre().setGUI();

    }

}
