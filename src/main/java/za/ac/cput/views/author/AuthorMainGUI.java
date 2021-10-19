package za.ac.cput.views.author;

/*
 *
 * The main author GUI program.
 * @author: Melven Johannes Booysen (219201277)
 * Date: 19 October 2021
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AuthorMainGUI
    { //GUI done +
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

            //fifth btn **
            layoutArrangement.insets = new Insets(2,2,4,2);
            layoutArrangement.gridx = 1;
            layoutArrangement.gridy = 5;
            layoutArrangement.ipadx = 230;
            layoutArrangement.ipady = 7;
            layoutArrangement.gridwidth = 1;
            panelCenter.add(btnReturnDvd,layoutArrangement);

            //sixth btn **
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
            //btnSearch
//            btnSearch.addActionListener(new ActionListener()
//            {
//                @Override
//                public void actionPerformed(ActionEvent ae)
//                {
//                    try
//                    {
//                        Socket s = new Socket("localhost",  5432);
//
//                        OutputStream out = s.getOutputStream();//pipe
//                        InputStream in = s.getInputStream();
//
//                        ObjectOutputStream oos = new ObjectOutputStream(out);//person putting things in the pipe
//                        oos.writeUTF("bringMeTheCorrectSearch");// the code being pushed through the pipe
//                        oos.writeUTF(searchTxt.getText());//the "searchTxt.getText()" gets the data inserted by staff and "oos.writeUTF" sends it to the server
//                        oos.flush();
//
//                        ObjectInputStream ois = new ObjectInputStream(in);
//                        java.util.List<DVD> displaySearch = (java.util.List<DVD>)ois.readObject();
//
//                        // Close the stream and connection
//                        ois.close();
//                        s.close();
//
//                        Object[][] objDVD = new Object[displaySearch.size()][];
//                        for(int i = 0; i < displaySearch.size(); i++)
//                        {
//                            DVD sd = displaySearch.get(i);
//                            Object[] thisD = new Object[]
//                                    {
//                                            sd.getTitle(),
//                                            sd.getCategory(),
//                                            sd.getPrice(),
//                                            sd.isNewRelease(),
//                                            sd.isAvailable()
//                                    };
//                            objDVD[i] = thisD;
//                        }
//
//                        JDialog frame = new JDialog(structure);
//                        frame.setSize(1000, 500);
//
//                        //Array that contains arrays and adds the values from the database to the Jtable    //this new object is where you put the column headings
//                        JTable tbl = new JTable(objDVD, new Object[] {"Title", "Category", "Price", "New release", "Available for rent"});
//                        frame.add(new JScrollPane(tbl));
//                        frame.setVisible(true);
//                    } catch (IOException|ClassNotFoundException ex)
//                    {
//                        Logger.getLogger(ClientSystem.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }//End of try catch
//            });//End of btnSearch

            //AddCustomer
            btnAddCustomer.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    if(ae.getSource()==btnAddCustomer)
                    {
                        structure.setVisible(true);
                        AddAuthor nc = new AddAuthor();
                        nc.GUISetup();
                    }
                }//End of actionPerformed
            });//End of ActionListener
//
            //AddDVD
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

            //ReturnDvd
            btnReturnDvd.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    if(ae.getSource()== btnReturnDvd)
                    {
                        structure.setVisible(true);
                        GetAuthors rd = new GetAuthors();
                        rd.GUISetup();
                    }
                }//End of actionPerformed
            });//End of ActionListener

//            //List Of Movie
//            btnListOfMovie.addActionListener(new ActionListener()
//            {
//                @Override
//                public void actionPerformed(ActionEvent ae)
//                {
//                    if(ae.getSource()==btnListOfMovie)
//                    {
//                        try {
//                            Socket s = new Socket("localhost",  5432);
//
//                            OutputStream out = s.getOutputStream();
//                            InputStream in = s.getInputStream();
//
//                            ObjectOutputStream oos = new ObjectOutputStream(out);
//                            oos.writeUTF("bringMeAllTheDVD");
//                            oos.flush();
//
//                            ObjectInputStream ois = new ObjectInputStream(in);
//                            java.util.List<DVD> dvdList = (java.util.List<DVD>)ois.readObject();
//
//                            // Close the stream and connection
//                            ois.close();
//                            s.close();
//
//                            Object[][] objDVD = new Object[dvdList.size()][];
//                            for(int i = 0; i < dvdList.size(); i++)
//                            {
//                                DVD d = dvdList.get(i);
//                                Object[] thisD = new Object[]
//                                        {
//                                                d.getDvdNumber(),
//                                                d.getTitle(),
//                                                d.getCategory(),
//                                                d.getPrice(),
//                                                d.isNewRelease(),
//                                                d.isAvailable()
//                                        };
//                                objDVD[i] = thisD;
//                            }
//
//                            JDialog frame = new JDialog(structure);
//                            frame.setSize(1000, 500);
//
//                            //Array that contains arrays and adds the values from the database to the Jtable    //this new object is where you put the column headings
//                            JTable tbl = new JTable(objDVD, new Object[] {"DVD number", "Title", "Category", "Price", "New release", "Available for rent"});
//                            frame.add(new JScrollPane(tbl));
//                            frame.setVisible(true);
//                        } catch (IOException|ClassNotFoundException ex)
//                        {
//                            Logger.getLogger(AuthorMainGUI.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                    }//End of if statement
//                }//End of actionPerformed
//            });//End of ActionListener
//
//            //List OF Customer
//            btnListOfCustomer.addActionListener(new ActionListener()
//            {
//                @Override
//                public void actionPerformed(ActionEvent ae)
//                {
//                    if(ae.getSource()==btnListOfCustomer)
//                    {
//                        try {
//                            // Open your connection to a server, at port 5432
//                            // localhost used here
//                            Socket s = new Socket("localhost",  5432);
//                            OutputStream out = s.getOutputStream();
//                            InputStream in = s.getInputStream();
//
//                            ObjectOutputStream oos = new ObjectOutputStream(out);
//                            oos.writeUTF("bringMeAllTheCustomers");
//                            oos.flush();
//
//                            ObjectInputStream ois = new ObjectInputStream(in);
//                            java.util.List<Customer> custList = (java.util.List<Customer>)ois.readObject();
//
//                            // Close the stream and connection
//                            ois.close();
//                            s.close();
//                            System.out.println("Connection closed.");
//
//                            Object[][] objCustomers = new Object[custList.size()][];
//                            for(int i = 0; i < custList.size(); i++)
//                            {
//                                Customer c = custList.get(i);
//                                Object[] thisC = new Object[]
//                                        {
//                                                c.getCustNumber(),
//                                                c.getName(),
//                                                c.getSurname(),
//                                                c.getPhoneNum(),
//                                                c.getCredit(),
//                                                c.canRent()
//                                        };
//                                objCustomers[i] = thisC;
//                            }
//
//                            JDialog frame = new JDialog(structure);
//                            frame.setSize(1000, 500);
//
//                            //Array that contains arrays and adds the values from the database to the Jtable    //this new object is where you put the column headings
//                            JTable tbl = new JTable(objCustomers, new Object[] {"Customer number", "Name", "Surname", "Phone number", "Credit", "Can rent"});
//                            frame.add(new JScrollPane(tbl));
//                            frame.setVisible(true);
//                        } catch (IOException|ClassNotFoundException ex)
//                        {
//                            Logger.getLogger(ClientSystem.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                    }//End of if statement
//                }//End of actionPerformed
//            });//End of ActionListener

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

            //List OF Rentals
//            btnListOfRentals.addActionListener(new ActionListener()
//            {
//                @Override
//                public void actionPerformed(ActionEvent ac)
//                {
//                    try {
//                        // Open your connection to a server, at port 5432
//                        // localhost used here
//                        Socket s = new Socket("localhost",  5432);
//
//                        OutputStream out = s.getOutputStream();
//                        InputStream in = s.getInputStream();
//
//                        ObjectOutputStream oos = new ObjectOutputStream(out);
//                        oos.writeUTF("bringMeAllTheRentals");
//                        oos.flush();
//
//                        ObjectInputStream ois = new ObjectInputStream(in);
//                        java.util.List<Rental> rentalList = (java.util.List<Rental>)ois.readObject();
//
//                        // Close the stream and connection
//                        ois.close();
//                        s.close();
//                        System.out.println("Connection closed.");
//
//                        Object[][] objRentals = new Object[rentalList.size()][];
//                        for(int i = 0; i < rentalList.size(); i++)
//                        {
//                            Rental r = rentalList.get(i);
//                            Object[] thisR = new Object[]
//                                    {
//                                            r.getRentalNumber(),
//                                            r.getDateRented(),
//                                            r.getDateReturned(),
//                                            r.getCustNumber(),
//                                            r.getDvdNumber()
//                                    };
//                            objRentals[i] = thisR;
//                        }
//
//                        JDialog frame = new JDialog(structure);
//                        frame.setSize(1000, 500);
//
//                        //Array that contains arrays and adds the values from the database to the Jtable    //this new object is where you put the column headings
//                        JTable tbl = new JTable(objRentals, new Object[] {"Rental number", "Date rented", "Date returned", "Customer number", "DVD number"});
//                        frame.add(new JScrollPane(tbl));
//                        frame.setVisible(true);
//                    } catch (IOException|ClassNotFoundException ex)
//                    {
//                        Logger.getLogger(ClientSystem.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }//End of actionPerformed
//            });//End of ActionListener

            //List OF Outstanding Rentals
//            btnListOfOutStandingRentals.addActionListener(new ActionListener()
//            {
//                @Override
//                public void actionPerformed(ActionEvent ac)
//                {
//                    //if(ac.getActionCommand().equals("btnListOfOutStandingRentals"))
//                    //{
//                    try {
//                        // Open your connection to a server, at port 5432
//                        // localhost used here
//                        Socket s = new Socket("localhost",  5432);
//
//                        OutputStream out = s.getOutputStream();
//                        InputStream in = s.getInputStream();
//
//                        ObjectOutputStream oos = new ObjectOutputStream(out);
//                        oos.writeUTF("bringMeAllOutstandingRentals");
//                        oos.flush();
//
//                        ObjectInputStream ois = new ObjectInputStream(in);
//                        java.util.List<DVD> dvdOutstandingList = (java.util.List<DVD>)ois.readObject();
//
//                        // Close the stream and connection
//                        ois.close();
//                        s.close();
//                        System.out.println("Connection closed.");
//
//                        Object[][] objDVD = new Object[dvdOutstandingList.size()][];
//                        for(int i = 0; i < dvdOutstandingList.size(); i++)
//                        {
//                            DVD d = dvdOutstandingList.get(i);
//                            Object[] thisD = new Object[]
//                                    {
//                                            d.getDvdNumber(),
//                                            d.getTitle(),
//                                            d.getCategory(),
//                                            d.getPrice(),
//                                            d.isNewRelease(),
//                                            d.isAvailable()
//                                    };
//                            objDVD[i] = thisD;
//                        }
//                        JDialog frame = new JDialog(structure);
//                        frame.setSize(1000, 500);
//
//                        //Array that contains arrays and adds the values from the database to the Jtable    //this new object is where you put the column headings
//                        JTable tbl = new JTable(objDVD, new Object[] {"DVD number", "Title", "Category", "Price", "New release", "Available for rent"});
//                        frame.add(new JScrollPane(tbl));
//                        frame.setVisible(true);
//                    } catch (IOException|ClassNotFoundException ex)
//                    {
//                        Logger.getLogger(AuthorMainGUI.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                    //}//End of actionPerformed
//                }//End of actionPerformed
//            });//End of ActionListener

            //List OF Daily Rentals
        /*btnListOfDailyRentals.addActionListener(new ActionListener()
        {
           @Override
           public void actionPerformed(ActionEvent ac)
           {
                if(ac.getActionCommand().equals("btnListOfDailyRentals"))
                {

                }//End of actionPerformed
           }//End of actionPerformed
        });//End of ActionListener*/


            structure.add(panelCenter, BorderLayout.CENTER);
            structure.add(panelSouth, BorderLayout.SOUTH);
            structure.setVisible(true);
        }//End of GUISetup

        public static void main(String[] args)
        {
            new AuthorMainGUI().GUISetup();
        }//End of main
    }//End of class

