package com_antomau_BinarySearchTree_OrdineAlfabetico.UserInterface;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;

/**
 * @author Antonio Maulucci http://www.antomau.com
 */
public class UserAlphabeticOrder {
	
	public static void main(String[] args) {
		
		JFrame f = new JFrame("Antonio Maulucci's Alphabetic Order");
		f.setSize(300, 300);
		f.setLayout(new BorderLayout());
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel console = new JPanel();
		console.setLayout(new GridLayout(1,6));
		
		JButton loadButton = new JButton("Open file");
		JButton printButton = new JButton("Print ordered words");
		JButton saveButton = new JButton("Save file");
		JButton exitButton = new JButton("Exit");
		JButton findButton = new JButton("Find word");
		JButton removeButton = new JButton("Remove word");
		
		console.add(loadButton); //1,1
		console.add(printButton); //1,2
		console.add(findButton); //1,3
		console.add(removeButton); //1,4
		console.add(saveButton); //1,5
		console.add(exitButton); //1,6
		
		JPanel contentPanel = new JPanel();
		
		f.add(console, BorderLayout.NORTH);
		f.add(contentPanel, BorderLayout.CENTER);
		
		f.pack();
		
	} //end of main
} //end of class
