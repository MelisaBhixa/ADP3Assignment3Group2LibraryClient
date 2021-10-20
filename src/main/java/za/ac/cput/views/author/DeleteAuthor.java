package za.ac.cput.views.author;

/*
 *
 * The delete author GUI program.
 * @author: Melven Johannes Booysen (219201277)
 * Date: 19 October 2021
 */

import za.ac.cput.entity.Author;
import za.ac.cput.factory.AuthorFactory;

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

public class DeleteAuthor
{ //GetRequest
    private JFrame structure;
    private JPanel panelCenter;
    private JPanel panelSouth;

    private JLabel rentalNumlbl;

    private JTextField rentalNumTxt;

    private JButton btnReset;
    private JButton btnUpdate;
    private JButton btnCancel;

public DeleteAuthor()
    {
        structure = new JFrame("Delete Author");
        panelCenter = new JPanel();
        panelSouth = new JPanel();
        rentalNumlbl = new JLabel("Author ID:");
        rentalNumTxt = new JTextField();
        btnReset = new JButton("Reset");
        btnUpdate = new JButton("Update");
        btnCancel = new JButton("Cancel");

        GUISetup();
    }

    public void GUISetup()
    {
        //**** WINDOW SPECIFICATIONS ****
        structure.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        structure.setSize(1000, 500);


        //**** Panel SPECIFICATIONS ****
        panelCenter.setLayout(new GridBagLayout());
        panelCenter.setVisible(true);
        panelCenter.add(rentalNumlbl);

        panelCenter.add(rentalNumTxt);

        panelSouth.setLayout(new GridBagLayout());
        panelSouth.setVisible(true);
        panelSouth.add(btnReset);
        panelSouth.add(btnUpdate);
        panelSouth.add(btnCancel);


        //the object for GridBagLayout
        GridBagConstraints layoutArrangement = new GridBagConstraints();
        //rentalNumlbl
        layoutArrangement.insets = new Insets(2,2,4,2);
        layoutArrangement.gridx = 0;          //it arranges components on x x's (meaning left to right)
        layoutArrangement.gridy = 1;         //it arranges components on y x's (meaning top to bottom)
        layoutArrangement.ipadx = 405;      //its the weight padding.
        layoutArrangement.ipady= 7;        //its the height padding.
        layoutArrangement.gridwidth = 2;  //it takes over the next column cell / block
        panelCenter.add(rentalNumlbl,layoutArrangement);
        //rental number user input
        layoutArrangement.insets = new Insets(2,80,4,2);
        layoutArrangement.gridx = 1;
        layoutArrangement.gridy = 1;
        layoutArrangement.ipadx = 290;
        layoutArrangement.ipady= 7;
        layoutArrangement.gridwidth = 2;
        panelCenter.add(rentalNumTxt,layoutArrangement);

        //the object for GridBagLayout
        GridBagConstraints bottomLayoutArrangement = new GridBagConstraints();
        //South panel
        bottomLayoutArrangement.gridx = 1;
        bottomLayoutArrangement.gridy = 0;
        bottomLayoutArrangement.ipadx = 240;
        bottomLayoutArrangement.ipady = 10;
        panelSouth.add(btnReset,bottomLayoutArrangement);
        bottomLayoutArrangement.gridx = 2;
        bottomLayoutArrangement.gridy = 0;
        bottomLayoutArrangement.ipadx = 240;
        bottomLayoutArrangement.ipady = 10;
        panelSouth.add(btnUpdate,bottomLayoutArrangement);
        bottomLayoutArrangement.gridx = 3;
        bottomLayoutArrangement.gridy = 0;
        bottomLayoutArrangement.ipadx = 240;
        bottomLayoutArrangement.ipady = 10;
        panelSouth.add(btnCancel,bottomLayoutArrangement);


        //**** Font SPECIFICATIONS ****
        Font text = new Font("Helvetica",Font.PLAIN,25);
        Font btn = new Font("Anton",Font.PLAIN,25);

        rentalNumlbl.setFont(btn);

        rentalNumTxt.setFont(text);

        btnReset.setFont(btn);
        btnUpdate.setFont(btn);
        btnCancel.setFont(btn);

        //**** ADDING ACTION LISTENERS ****
        btnReset.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                if(ae.getActionCommand().equals("Reset"))
                {
                    rentalNumTxt.setText("");
                    rentalNumTxt.requestFocus();
                }//End of if statement
            }//End of actionPerformed
        });//End of ActionListener


    btnUpdate.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
//            if(e.getActionCommand().equals("Update"))
//            {
////                Author author = AuthorFactory.deleteAuthor(
////                        rentalNumTxt.getText());
//                try {
//                    HttpClient client = HttpClient.newHttpClient();
//                    HttpRequest request = HttpRequest.newBuilder()
//                            .uri(new URI("http://localhost:8080/author/delete/" + author.getId()))
//                            .DELETE()
//                            .build();
//                    client.send(request, HttpResponse.BodyHandlers.discarding());
//                } catch (InterruptedException | IOException | URISyntaxException interruptedException) {
//                    interruptedException.printStackTrace();
//                }
//
//            }
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
}//End of class


