package za.ac.cput.views.author;

/*
 *
 * The update author GUI program.
 * @author: Melven Johannes Booysen (219201277)
 * Date: 19 October 2021
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateAuthor
{
    private JFrame structure;
    private JPanel panelCenter;
    private JPanel panelSouth;

    private JLabel dvdNumlbl;
    private JLabel titlelbl;
    private JLabel pricelbl;;

    private JTextField dvdNumTxt;
    private JTextField titleTxt;
    private JTextField priceTxt;

    private JButton btnReset;
    private JButton btnSave;
    private JButton btnCancel;


    public UpdateAuthor()
    {
        structure = new JFrame("Update Author");
        panelCenter = new JPanel();
        panelSouth = new JPanel();
        dvdNumlbl = new JLabel("First name:");
        titlelbl = new JLabel("Surname:");
        pricelbl = new JLabel("Bio:");
        dvdNumTxt = new JTextField();
        titleTxt = new JTextField();
        priceTxt = new JTextField();

        btnReset = new JButton("Reset");
        btnSave = new JButton("Save");
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
        panelCenter.add(dvdNumlbl);
        panelCenter.add(titlelbl);
        panelCenter.add(pricelbl);

        panelCenter.add(dvdNumTxt);
        panelCenter.add(titleTxt);
        panelCenter.add(priceTxt);

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
        layoutArrangement.ipadx = 425;      //its the weight padding.
        layoutArrangement.ipady= 7;        //its the height padding.
        layoutArrangement.gridwidth = 2;  //it takes over the next column cell / block
        panelCenter.add(dvdNumlbl,layoutArrangement);
        //dvdNum user input
        layoutArrangement.insets = new Insets(2,2,4,2);
        layoutArrangement.gridx = 1;
        layoutArrangement.gridy = 1;
        layoutArrangement.ipadx = 255;
        layoutArrangement.ipady= 7;
        layoutArrangement.gridwidth = 1;
        panelCenter.add(dvdNumTxt,layoutArrangement);
        //titlelbl
        layoutArrangement.insets = new Insets(2,2,4,2);
        layoutArrangement.gridx = 0;
        layoutArrangement.gridy = 2;
        layoutArrangement.ipadx = 410;
        layoutArrangement.ipady= 3;
        layoutArrangement.gridwidth = 2;
        panelCenter.add(titlelbl,layoutArrangement);
        //title user input
        layoutArrangement.insets = new Insets(2,2,4,2);
        layoutArrangement.gridx = 1;
        layoutArrangement.gridy = 2;
        layoutArrangement.ipadx = 255;
        layoutArrangement.ipady = 7;
        layoutArrangement.gridwidth = 1;
        panelCenter.add(titleTxt,layoutArrangement);
        //pricelbl
        layoutArrangement.insets = new Insets(2,2,4,2);
        layoutArrangement.gridx = 0;
        layoutArrangement.gridy = 4;
        layoutArrangement.ipadx = 345;
        layoutArrangement.ipady= 7;
        layoutArrangement.gridwidth = 2;
        panelCenter.add(pricelbl,layoutArrangement);
        //price user input
        layoutArrangement.insets = new Insets(2,2,4,2);
        layoutArrangement.gridx = 1;
        layoutArrangement.gridy = 4;
        layoutArrangement.ipadx = 253;
        layoutArrangement.ipady = 200;
        layoutArrangement.gridwidth = 1;
        panelCenter.add(priceTxt,layoutArrangement);


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

        dvdNumlbl.setFont(btn);
        titlelbl.setFont(btn);
        pricelbl.setFont(btn);

        dvdNumTxt.setFont(text);
        titleTxt.setFont(text);
        priceTxt.setFont(text);

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
                    dvdNumTxt.setText("");
                    titleTxt.setText("");
                    priceTxt.setText("");
                    dvdNumTxt.requestFocus();

                }//End of if statement
            }//End of actionPerformed
        });//End of ActionListener


//            btnSave.addActionListener(new ActionListener()
//            {
//
//                public void actionPerformed(ActionEvent e)
//                {
//                    try
//                    {
//                        Socket s = new Socket("localhost",  5432);
//                        OutputStream out = s.getOutputStream();//the pipe
//                        // InputStream in = s.getInputStream();
//
//                        // ObjectInputStream ois = new ObjectInputStream(in);
//                        ObjectOutputStream oos = new ObjectOutputStream(out);
//                        DVD d = new DVD(Integer.parseInt(dvdNumTxt.getText()), titleTxt.getText(), (String)comboBox.getSelectedItem(), btnTrue.isSelected(), btnYes.isSelected());
//                        oos.writeUTF("addDVD");
//                        oos.writeObject(d);
//
//                        // Close the stream and connection
//                        oos.flush();
//                        oos.close();
//                        s.close();
//                    } catch (IOException ex)
//                    {
//                        ex.printStackTrace(System.out);
//                    }
//                }//End of actionPerformed
//            });//End of ActionListener


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

