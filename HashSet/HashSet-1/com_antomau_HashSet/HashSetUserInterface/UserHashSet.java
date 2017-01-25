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
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		class searchButtonListenerClass implements ActionListener
		{
			@Override
			public void actionPerformed (ActionEvent e)
			{
				contentPanel.removeAll();
				
				JPanel mainInternalPanel = new JPanel();
				mainInternalPanel.setLayout(new GridLayout(2,1));
				
				
				
				JPanel searchPanel = new JPanel();
				searchPanel.setLayout(new GridLayout(1,3));
				
				JPanel dataPanel = new JPanel();
				dataPanel.setLayout(new GridLayout(3,2));
				
				JLabel l1 = new JLabel("Author:");
				JLabel l2 = new JLabel ("Title:");
				JLabel l3 = new JLabel("Year:");
				JTextField jtf1 = new JTextField();
				JTextField jtf2 = new JTextField();
				JTextField jtf3 = new JTextField();
				
				dataPanel.add(l1);
				dataPanel.add(l2);
				dataPanel.add(l3);
				dataPanel.add(jtf1);
				dataPanel.add(jtf2);
				dataPanel.add(jtf3);
				
				
				JPanel typePanel = new JPanel(); //this panel will be user to choose what data find
				typePanel.setLayout(new GridLayout(4,1));
				
				JLabel typeLabel = new JLabel("What data do you want to find?");
				ButtonGroup typeGroup = new ButtonGroup();
				JRadioButton authorButton = new JRadioButton("Author");
				JRadioButton titleButton = new JRadioButton("Title");
				JRadioButton yearButton = new JRadioButton("Year");
					
				typePanel.add(typeLabel); //1,1
				typePanel.add(authorButton); //2,1
				typePanel.add(titleButton); //3,1
				typePanel.add(yearButton); //4,1
				
				
				JButton button = new JButton("Find");
				
				
				searchPanel.add(dataPanel); //1,1
				searchPanel.add(typePanel); //1,2
				searchPanel.add(button); //1,3
				
				
				
				mainInternalPanel.add(searchPanel); //1,1
				
				contentPanel.add(mainInternalPanel);
				
				class buttonListenerClass implements ActionListener
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						JPanel resultsPanel = new JPanel();
						
						JLabel resultsLabel = new JLabel();
						/*
						if (authorButton.isSelected()) resultsLabel.setText(mySet.findAuthor(jtf1.getText()));
						else if (titleButton.isSelected()) resultsLabel.setText(mySet.findTitle(jtf1.getText()));
						else if (yearButton.isSelected()) resultsLabel.setText(mySet.findYear(Integer.parseInt(jtf1.getText())));
						*/	
						resultsPanel.add(resultsLabel);
						
						mainInternalPanel.add(resultsPanel); //2,1
						f.pack();
					} //end of internal actionPerformed
				} //end of buttonListenerClass
				
				button.addActionListener(new buttonListenerClass());
				
				f.pack();
			} //end of actionPerformed
		} //end of exitButtonListenerClass
		
		ActionListener searchButtonListener = new searchButtonListenerClass();
		searchButton.addActionListener(searchButtonListener);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	} //end of main
	
	
	
} //end of class
