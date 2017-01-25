package com_antomau_HashSet.HashSetUserInterface;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Scanner;
import java.io.File;

public class UserHashSet {
	
	private static Scanner in;
	
	private static File file;
	
	public static void main(String[] args)
	{
		JFrame f = new JFrame("Antonio Maulucci's HashSet");
		f.setSize(300, 300);
		f.setLayout(new BorderLayout());
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		JPanel consolePanel = new JPanel();
		consolePanel.setLayout(new GridLayout(5,1));
		
		JButton openButton = new JButton("Open file");
		JButton printButton = new JButton("Print all data");
		JButton searchButton = new JButton("Find element");
		JButton deleteButton = new JButton("Delete elemet");
		JButton exitButton = new JButton("Exit");
		
		consolePanel.add(openButton);
		consolePanel.add(printButton);
		consolePanel.add(searchButton);
		consolePanel.add(deleteButton);
		consolePanel.add(exitButton);
		
		JPanel contentPanel = new JPanel();
		
		f.add(consolePanel, BorderLayout.NORTH);
		f.add(contentPanel, BorderLayout.CENTER);
		
		f.pack();
	} //end of main
	
	
	
} //end of class
