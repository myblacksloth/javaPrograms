package com_antomau_HashSet.HashSetUserInterface;

import com_antomau_HashSet.Book.Book;
import com_antomau_HashSet.HashSet.HashSet;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Scanner;
import java.io.File;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;

public class UserHashSet {
	
	private static HashSet mySet = new HashSet(13);
	
	private static Scanner in;
	
	private static File file;
	
	public static void main(String[] args)
	{
		
		JFileChooser fc = new JFileChooser();
		
		JFrame f = new JFrame("Antonio Maulucci's HashSet");
		f.setSize(300, 300);
		f.setLayout(new BorderLayout());
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		JPanel consolePanel = new JPanel();
		consolePanel.setLayout(new GridLayout(1,5));
		
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
		
		
		
		
		class exitButtonListenerClass implements ActionListener
		{
			@Override
			public void actionPerformed (ActionEvent e)
			{
				System.exit(0);
			} //end of actionPerformed
		} //end of exitButtonListenerClass
		
		ActionListener exitButtonListener = new exitButtonListenerClass();
		exitButton.addActionListener(exitButtonListener);
		
		
		
		
		
		
		
		
		
		
		
		class openButtonListenerClass implements ActionListener
		{
			@Override
			public void actionPerformed (ActionEvent e)
			{
				
				fc.setDialogTitle("Choose a file to open");
				fc.showOpenDialog(f);
				
				try {
					file = fc.getSelectedFile();
					in = new Scanner(file);
				} catch (FileNotFoundException exc) {
					exc.printStackTrace();
					return;
				}
				
				Book newBook = null;
				
				while (in.hasNext())
				{
					newBook = new Book(in.next(), in.next(), in.nextInt());
				} //end of while
				
				mySet.add(newBook);
				
			} //end of actionPerformed
		} //end of exitButtonListenerClass

		ActionListener openButtonListener = new openButtonListenerClass();
		openButton.addActionListener(openButtonListener);
		
		
		
		
		
		
		
		
		
		
		class printButtonListenerClass implements ActionListener
		{
			@Override
			public void actionPerformed (ActionEvent e)
			{
				
				contentPanel.removeAll();
				
				JLabel content = new JLabel(mySet.toLabelString());
				
				contentPanel.add(content);
				
				f.pack();
				
			} //end of actionPerformed
		} //end of exitButtonListenerClass
		
		ActionListener printButtonListener = new printButtonListenerClass();
		printButton.addActionListener(printButtonListener);
		
		
		
		
	} //end of main
	
	
	
} //end of class
