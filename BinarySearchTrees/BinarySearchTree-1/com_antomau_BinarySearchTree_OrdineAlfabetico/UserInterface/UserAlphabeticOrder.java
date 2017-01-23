package com_antomau_BinarySearchTree_OrdineAlfabetico.UserInterface;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class UserAlphabeticOrder {
	
	public static void main(String[] args) {
		
		JFrame f = new JFrame("Antonio Maulucci's Alphabetic Order");
		f.setSize(300, 300);
		f.setLayout(new BorderLayout());
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel console = new JPanel();
		console.setLayout(new GridLayout(1,4));
		
		JButton loadButton = new JButton("Open file");
		JButton printButton = new JButton("Print ordered words");
		JButton saveButton = new JButton("Save file");
		JButton exitButton = new JButton("Exit");
		
		console.add(loadButton); //1,1
		console.add(printButton); //1,2
		console.add(saveButton); //1,3
		console.add(exitButton); //1,4
		
		JPanel contentPanel = new JPanel();
		
		f.add(console, BorderLayout.NORTH);
		f.add(contentPanel, BorderLayout.CENTER);
		
		f.pack();
		
	} //end of main
} //end of class
