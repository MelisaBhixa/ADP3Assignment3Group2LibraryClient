package za.ac.cput.views.author;

/*
 *
 * The add new author GUI program.
 * @author: Melven Johannes Booysen (219201277)
 * Date: 19 October 2021
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;
import za.ac.cput.entity.Author;
import za.ac.cput.factory.AuthorFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class AddAuthor
{
    private JFrame structure;
    private JPanel panelCenter;
    private JPanel panelSouth;
    private JPanel groupPanel;

    private JLabel fNamelbl;
    private JLabel surnamelbl;
    private JLabel phoneNumlbl;

    private JTextField fNameTxt;
    private JTextField surnameTxt;
    private JTextField phoneNumTxt;

    private JButton btnReset;
    private JButton btnSave;
    private JButton btnCancel;

    public AddAuthor()
    {
        structure = new JFrame("Add New Author");
        panelCenter = new JPanel();
        panelSouth = new JPanel();
        groupPanel = new JPanel();
        fNamelbl = new JLabel("First name:");
        surnamelbl = new JLabel("Surname:");
        phoneNumlbl = new JLabel("Bio:");
        fNameTxt = new JTextField();
        surnameTxt = new JTextField();
        phoneNumTxt = new JTextField();

        btnReset = new JButton("Reset");
        btnSave = new JButton("Save");
        btnCancel = new JButton("Cancel");

//        GUISetup();
    }

    public void GUISetup()
    {
        //**** WINDOW SPECIFICATIONS ****
        structure.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        structure.setSize(1000, 500);


        //**** Panel SPECIFICATIONS ****
        panelCenter.setLayout(new GridBagLayout());
        panelCenter.setVisible(true);
        panelCenter.add(fNamelbl);
        panelCenter.add(surnamelbl);
        panelCenter.add(phoneNumlbl);

        panelCenter.add(fNameTxt);
        panelCenter.add(surnameTxt);
        panelCenter.add(phoneNumTxt);

        groupPanel = new JPanel(new GridBagLayout());
        groupPanel.setVisible(true);

        panelSouth.setLayout(new GridBagLayout());
        panelSouth.setVisible(true);
        panelSouth.add(btnReset);
        panelSouth.add(btnSave);
        panelSouth.add(btnCancel);


        //the object for GridBagLayout
        GridBagConstraints layoutArrangement = new GridBagConstraints();
        layoutArrangement.insets = new Insets(2,2,4,2);
        layoutArrangement.gridx = 0;          //it arranges components on x x's (meaning left to right)
        layoutArrangement.gridy = 1;         //it arranges components on y x's (meaning top to bottom)
        layoutArrangement.ipadx = 400;      //its the weight padding.
        layoutArrangement.ipady= 7;        //its the height padding.
        layoutArrangement.gridwidth = 2;  //it takes over the next column cell / block
        panelCenter.add(fNamelbl,layoutArrangement);

        //fName user input
        layoutArrangement.insets = new Insets(2,2,4,2);
        layoutArrangement.gridx = 1;
        layoutArrangement.gridy = 1;
        layoutArrangement.ipadx = 255;
        layoutArrangement.ipady= 7;
        layoutArrangement.gridwidth = 1;
        panelCenter.add(fNameTxt,layoutArrangement);

        //surnamelbl
        layoutArrangement.insets = new Insets(2,2,4,2);
        layoutArrangement.gridx = 0;
        layoutArrangement.gridy = 2;
        layoutArrangement.ipadx = 382;
        layoutArrangement.ipady= 7;
        layoutArrangement.gridwidth = 2;
        panelCenter.add(surnamelbl,layoutArrangement);

        //surname user input
        layoutArrangement.insets = new Insets(2,2,4,2);
        layoutArrangement.gridx = 1;
        layoutArrangement.gridy = 2;
        layoutArrangement.ipadx = 255;
        layoutArrangement.ipady = 7;
        layoutArrangement.gridwidth = 1;
        panelCenter.add(surnameTxt,layoutArrangement);

        //phoneNumlbl **
        layoutArrangement.insets = new Insets(2,2,4,2);
        layoutArrangement.gridx = 0;
        layoutArrangement.gridy = 3;
        layoutArrangement.ipadx = 316;
        layoutArrangement.ipady= 7;
        layoutArrangement.gridwidth = 2;
        panelCenter.add(phoneNumlbl,layoutArrangement);

        //phoneNum user input
        layoutArrangement.insets = new Insets(2,2,4,2);
        layoutArrangement.gridx = 1;
        layoutArrangement.gridy = 3;
        layoutArrangement.ipadx = 254;
        layoutArrangement.ipady = 200;
        layoutArrangement.gridwidth = 1;
        panelCenter.add(phoneNumTxt,layoutArrangement);

        //canRent user input
        layoutArrangement.insets = new Insets(2,2,2,2);
        layoutArrangement.gridx = 1;
        layoutArrangement.gridy = 5;
        layoutArrangement.ipadx = 100;
        layoutArrangement.ipady = 7;
        layoutArrangement.gridwidth = 1;
        panelCenter.add(groupPanel,layoutArrangement);

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
        panelSouth.add(btnSave,bottomLayoutArrangement);
        bottomLayoutArrangement.gridx = 3;
        bottomLayoutArrangement.gridy = 0;
        bottomLayoutArrangement.ipadx = 240;
        bottomLayoutArrangement.ipady = 10;
        panelSouth.add(btnCancel,bottomLayoutArrangement);


        //**** Font SPECIFICATIONS ****
        Font text = new Font("Helvetica",Font.PLAIN,25);
        Font btn = new Font("Anton",Font.PLAIN,25);

        fNamelbl.setFont(btn);
        surnamelbl.setFont(btn);
        phoneNumlbl.setFont(btn);

        fNameTxt.setFont(text);
        surnameTxt.setFont(text);
        phoneNumTxt.setFont(text);

        btnReset.setFont(btn);
        btnSave.setFont(btn);
        btnCancel.setFont(btn);

        //**** ADDING ACTION LISTENERS ****
        btnReset.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent r)
            {
                if(r.getActionCommand().equals("Reset"))
                {
                    fNameTxt.setText("");
                    surnameTxt.setText("");
                    phoneNumTxt.setText("");
                    fNameTxt.requestFocus();
                }//End of if statement
            }//End of actionPerformed
        });//End of ActionListener


        btnSave.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Author author = AuthorFactory.createAuthor(
                        fNameTxt.getText(),
                        surnameTxt.getText(),
                        phoneNumTxt.getText()
                );
                try {
                    HttpClient client = HttpClient.newHttpClient();
                    HttpRequest request = HttpRequest.newBuilder()
                            .uri(new URI("http://localhost:8080/author/create"))
                            .POST(HttpRequest.BodyPublishers.ofString(author.json()))
                            .header("Content-type", "application/json")
                            .build();
                    client.send(request, HttpResponse.BodyHandlers.discarding());
                    structure.setVisible(false);
                } catch (IOException | URISyntaxException | InterruptedException ex) {
                    ex.printStackTrace();
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
}//End of class

