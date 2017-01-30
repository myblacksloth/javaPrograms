package com_antomau_WarehouseManagement.UserInterface;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Scanner;
// import java.io.File; //to manage files
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;


import com_antomau_WarehouseManagement.CertainObjects.*;


/**
 * Created by Antonio Maulucci http://www.antomau.com on 29/01/17.
 */
public class UserWarehouseManagement {


    private static Map <Warehouse, Product> myManager = new TreeMap <Warehouse, Product> ();






    /**
     * This is the main method
     * @param args args to main (this program doesen't use that)
     */
    public static void main(String[] args)
    {

        JFrame f = new JFrame("Antonio Maulucci's Warehouse Manager");
        f.setLayout(new BorderLayout());
        f.setSize(300, 300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);






        JPanel consolePanel = new JPanel();
        consolePanel.setLayout(new GridLayout(1,2));



        JPanel fileManagement = new JPanel();
        fileManagement.setLayout(new GridLayout(3,2));
        //
        //
        JLabel pathf1 = new JLabel();
        JLabel pathf2 = new JLabel();
        JLabel pathf3 = new JLabel();
        //
        //
        JFileChooser filec1 = new JFileChooser(); //file dei magazzini
        JFileChooser filec2 = new JFileChooser(); //file dei prodotti
        JFileChooser filec3 = new JFileChooser(); //file delle giacenze
        //
        //
        JButton fileb1 = new JButton("Open Warehouses database");
        JButton fileb2 = new JButton("Open Products database");
        JButton fileb3 = new JButton("Open Warehousing database");
        //
        //
        //
        fileManagement.add(pathf1); //1,1
        fileManagement.add(fileb1); //1,2
        fileManagement.add(pathf2); //2,1
        fileManagement.add(fileb2); //2,2
        fileManagement.add(pathf3); //3,1
        fileManagement.add(fileb3); //3,2






        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(2,1));



        //buttons
        JButton loadDataButton = new JButton("Load data");
        JButton exitButton = new JButton("exit");
        //
        //
        //
        buttonsPanel.add(loadDataButton);
        buttonsPanel.add(exitButton);






        consolePanel.add(fileManagement); //1,1
        consolePanel.add(buttonsPanel); //1,2









        JPanel contentPanel = new JPanel();







        f.add(consolePanel, BorderLayout.NORTH);
        f.add(contentPanel, BorderLayout.CENTER);
















        class exitButtonListenerClass implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        }
        ActionListener exitButtonListener = new exitButtonListenerClass();
        exitButton.addActionListener(exitButtonListener);



        class fileb1ListenerClass implements ActionListener
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //show dialog windows and open file
                filec1.setDialogTitle("Open Warehouse Database");
                filec1.showOpenDialog(f);

                //set path label
                try {
                    pathf1.setText(filec1.getSelectedFile().getAbsolutePath());
                } catch (Exception exc) {
                    exc.printStackTrace();
                }

                f.pack();
            }
        }
        ActionListener fileb1Listener = new fileb1ListenerClass();
        fileb1.addActionListener(fileb1Listener);





        class fileb2ListenerClass implements ActionListener
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                filec2.setDialogTitle("Open Products Database");
                filec2.showOpenDialog(f);

                try {
                    pathf2.setText(filec2.getSelectedFile().getAbsolutePath());
                } catch (Exception exc) {
                    exc.printStackTrace();
                }
                f.pack();
            }
        }
        ActionListener fileb2Listener = new fileb2ListenerClass();
        fileb2.addActionListener(fileb2Listener);








        class fileb3ListenerClass implements ActionListener
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                filec3.setDialogTitle("Open Warehousing Database");
                filec3.showOpenDialog(f);

                try {
                    pathf3.setText(filec3.getSelectedFile().getAbsolutePath());
                } catch (Exception exc) {
                    exc.printStackTrace();
                }
                f.pack();
            }
        }
        ActionListener fileb3Listener = new fileb3ListenerClass();
        fileb3.addActionListener(fileb3Listener);














        class loadDataButtonListenerClass implements ActionListener
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {




                    Scanner inWarehousing = new Scanner(filec3.getSelectedFile());




                    while (inWarehousing.hasNextLine()) //finanto che nel file delle giacenze esista la prossima linea
                    {

                        Warehousing currentWarehousing = new Warehousing(inWarehousing.nextLine(), inWarehousing.nextLine(), Integer.parseInt(inWarehousing.nextLine())); //nuovo oggetto di tipo giacenze

                        Scanner inWarehouse = new Scanner(filec1.getSelectedFile());

                        while (inWarehouse.hasNextLine())
                        {

                            Warehouse currentWarehouse = new Warehouse(inWarehouse.nextLine(), inWarehouse.nextLine(), inWarehouse.nextLine(), inWarehouse.nextLine(), inWarehouse.nextLine(), inWarehouse.nextLine());

                            if (currentWarehousing.getWarehouseSerial().equals(currentWarehouse.getSerial()))
                            {

                                Scanner inProduct = new Scanner(filec2.getSelectedFile());

                                while (inProduct.hasNextLine())
                                {

                                    Product currentProduct = new Product(inProduct.nextLine(), inProduct.nextLine(), Integer.parseInt(inProduct.nextLine()));

                                    if (currentWarehousing.getProductSerial().equals(currentProduct.getSerial()))
                                    {
                                        myManager.put(currentWarehouse, currentProduct); //put object into the map
                                        System.out.println(currentWarehouse.getSerial() + " <-->" + currentProduct.getSerial()); //debug
                                    } //end of if

                                } //end of while

                            } //end of if

                        } //end of while

                    } //end of while












                } catch (Exception exc) {
                    exc.printStackTrace();
                }



            } //end of actionPerformed
        } //end of loadDataButtonListenerClass
        ActionListener loadDataButtonListener = new loadDataButtonListenerClass();
        loadDataButton.addActionListener(loadDataButtonListener);
















        f.pack();

    } //end of main




} //end of class
