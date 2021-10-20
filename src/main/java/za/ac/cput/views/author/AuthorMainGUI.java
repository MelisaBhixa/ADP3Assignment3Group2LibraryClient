package za.ac.cput.views.author;

/*
 *
 * The main author GUI program.
 * @author: Melven Johannes Booysen (219201277)
 * Date: 19 October 2021
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHeaders;
import za.ac.cput.entity.Author;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;

public class AuthorMainGUI
{
    private JFrame structure;

    private JPanel panelCenter;
    private JPanel panelSouth;

    private JTextField searchTxt;

    private JButton btnSearch;
    private JButton btnAddCustomer;
    private JButton btnAddDvd;
    private JButton btnReturnDvd;
    private JButton btnListOfMovie;

    private JButton btnReset;
    private JButton btnCancel;

    //default constructor
    public AuthorMainGUI()
    {
        structure = new JFrame("Library App version 1.0");
        panelCenter = new JPanel();
        panelSouth = new JPanel();
        searchTxt = new JTextField();
        btnSearch = new JButton("Search");
        btnAddCustomer = new JButton("Add new author");
        btnAddDvd = new JButton("Update author");
        btnReturnDvd = new JButton("Delete author");
        btnListOfMovie = new JButton("List authors");

        btnReset = new JButton("Reset");
        btnCancel = new JButton("Cancel");

        GUISetup();
    }

    public void GUISetup()
    {
        //**** WINDOW SPECIFICATIONS ****
        structure.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        structure.setSize(1000, 680);


        //**** Panel SPECIFICATIONS ****
        panelCenter.setLayout(new GridBagLayout());
        panelCenter.setVisible(true);

        panelCenter.add(searchTxt);

        panelCenter.add(btnSearch);
        panelCenter.add(btnAddCustomer);
        panelCenter.add(btnAddDvd);
        panelCenter.add(btnReturnDvd);
        panelCenter.add(btnListOfMovie);

        panelSouth.setLayout(new GridBagLayout());
        panelSouth.setVisible(true);
        panelSouth.add(btnReset);
        panelSouth.add(btnCancel);


        //the object for GridBagLayout
        GridBagConstraints layoutArrangement = new GridBagConstraints();
        //first btn
        layoutArrangement.insets = new Insets(2,2,15,500); //insets is used for creatig spacing between components
        layoutArrangement.gridx = 1;                   //it arranges components on x x's (meaning left to right)
        layoutArrangement.gridy = 1;                  //it arranges components on y x's (meaning top to bottom)
        layoutArrangement.ipadx = 100;               //its the weight padding.
        layoutArrangement.ipady= 7;                 //its the height padding.
        layoutArrangement.gridwidth = 1;           //it takes over the next column cell / block
        panelCenter.add(btnSearch,layoutArrangement);

        //text field
        layoutArrangement.insets = new Insets(2,150,15,2);
        layoutArrangement.gridx = 1;
        layoutArrangement.gridy = 1;
        layoutArrangement.ipadx = 445;
        layoutArrangement.ipady = 7;
        layoutArrangement.gridwidth = 4;
        panelCenter.add(searchTxt,layoutArrangement);

        //second btn
        layoutArrangement.insets = new Insets(2,2,4,2);
        layoutArrangement.gridx = 1;
        layoutArrangement.gridy = 2;
        layoutArrangement.ipadx = 203;
        layoutArrangement.ipady= 7;
        layoutArrangement.gridwidth = 1;
        panelCenter.add(btnAddCustomer,layoutArrangement);

        //third btn
        layoutArrangement.insets = new Insets(2,2,4,2);
        layoutArrangement.gridx = 1;
        layoutArrangement.gridy = 3;
        layoutArrangement.ipadx = 222;
        layoutArrangement.ipady = 7;
        layoutArrangement.gridwidth = 1;
        panelCenter.add(btnAddDvd,layoutArrangement);

        //fifth btn
        layoutArrangement.insets = new Insets(2,2,4,2);
        layoutArrangement.gridx = 1;
        layoutArrangement.gridy = 5;
        layoutArrangement.ipadx = 230;
        layoutArrangement.ipady = 7;
        layoutArrangement.gridwidth = 1;
        panelCenter.add(btnReturnDvd,layoutArrangement);

        //sixth btn
        layoutArrangement.insets = new Insets(2,2,4,2);
        layoutArrangement.gridx = 1;
        layoutArrangement.gridy = 6;
        layoutArrangement.ipadx = 250;
        layoutArrangement.ipady = 7;
        layoutArrangement.gridwidth = 1;
        panelCenter.add(btnListOfMovie,layoutArrangement);

        //the object for GridBagLayout
        GridBagConstraints bottomLayoutArrangement = new GridBagConstraints();
        //South panel
        bottomLayoutArrangement.gridx = 1;
        bottomLayoutArrangement.gridy = 0;
        bottomLayoutArrangement.ipadx = 400;
        bottomLayoutArrangement.ipady = 10;
        panelSouth.add(btnReset,bottomLayoutArrangement);
        bottomLayoutArrangement.gridx = 3;
        bottomLayoutArrangement.gridy = 0;
        bottomLayoutArrangement.ipadx = 400;
        bottomLayoutArrangement.ipady = 10;
        panelSouth.add(btnCancel,bottomLayoutArrangement);


        //**** Font SPECIFICATIONS ****
        Font text = new Font("Helvetica",Font.PLAIN,18);
        Font btn = new Font("Anton",Font.PLAIN,25);

        searchTxt.setFont(text);

        btnAddCustomer.setFont(btn);
        btnAddDvd.setFont(btn);
        btnReturnDvd.setFont(btn);
        btnReset.setFont(btn);
        btnCancel.setFont(btn);
        btnListOfMovie.setFont(btn);


        //**** ADDING ACTION LISTENERS ****

        //AddAuthor
        btnAddCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(ae.getSource()==btnAddCustomer)
                {
                    structure.setVisible(true);
                    AddAuthor nc = new AddAuthor();
                    nc.GUISetup();
                }
            }
        });//End of ActionListener
//
        //Update author
        btnAddDvd.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent d)
            {
                if(d.getSource()==btnAddDvd)
                {
                    structure.setVisible(true);
                    UpdateAuthor nd = new UpdateAuthor();
                    nd.GUISetup();
                }
            }//End of actionPerformed
        });//End of ActionListener

        //Delete
        btnReturnDvd.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                if(ae.getSource()== btnReturnDvd)
                {
                    structure.setVisible(true);
                    new DeleteAuthor();
                }
            }//End of actionPerformed
        });//End of ActionListener

            //List Of Author
            btnListOfMovie.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    if(ae.getSource()==btnListOfMovie)
                    {
                        try {
                            HttpClient client = HttpClient.newHttpClient();
                            HttpRequest httpRequest = HttpRequest.newBuilder()
                                    .uri(new URI("http://localhost:8080/author/getAll"))
                                    .GET()
                                    .header(HttpHeaders.CONTENT_TYPE, "application/json")
                                    .build();

                            HttpResponse<String> resp = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
                            System.out.println(resp.body());
                            ObjectMapper mapper = new ObjectMapper();
                            Author[] allAuthors = mapper.readValue(resp.body(), Author[].class);
                            System.out.println(Arrays.toString(allAuthors));
                        } catch (IOException | InterruptedException | URISyntaxException e) {
                            e.printStackTrace();
                        }
                    }//End of if statement
                }//End of actionPerformed
            });//End of ActionListener


        btnReset.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                if(ae.getActionCommand().equals("Reset"))
                {
                    searchTxt.setText("");
                    searchTxt.requestFocus();
                }
            }//End of actionPerformed
        });//End of ActionListener

        btnCancel.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent c)
            {
                if(c.getActionCommand().equals("Cancel"))
                {
                    System.exit(0);
                }//End of actionPerformed
            }//End of actionPerformed
        });//End of ActionListener

        structure.add(panelCenter, BorderLayout.CENTER);
        structure.add(panelSouth, BorderLayout.SOUTH);
        structure.setVisible(true);
    }//End of GUISetup

    public static void main(String[] args)
    {
        new AuthorMainGUI();//.GUISetup();
    }//End of main
}//End of class

