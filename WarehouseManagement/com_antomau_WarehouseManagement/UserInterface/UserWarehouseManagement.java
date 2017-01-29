package com_antomau_WarehouseManagement.UserInterface;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionEvent;



/**
 * Created by Antonio Maulucci http://www.antomau.com on 29/01/17.
 */
public class UserWarehouseManagement {


    private static Scanner in;

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


        JButton exitButton = new JButton("exit");

        f.add(exitButton);

        class exitButtonListenerClass implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        }
        ActionListener exitButtonListener = new exitButtonListenerClass();
        exitButton.addActionListener(exitButtonListener);


        f.pack();

    } //end of main




} //end of class
