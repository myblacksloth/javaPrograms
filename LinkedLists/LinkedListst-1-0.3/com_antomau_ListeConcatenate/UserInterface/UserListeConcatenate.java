package com_antomau_ListeConcatenate.UserInterface;

import com_antomau_ListeConcatenate.Studente.Studente;
import com_antomau_ListeConcatenate.LinkedList.ListaConcatenata;
import com_antomau_ListeConcatenate.ListIterator.ListIterator;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Scanner;
import java.io.*;

/**
 * @author Antonio Maulucci http://www.antomau.com
 */
public class UserListeConcatenate {
	
	private static File file;
	
	private static Scanner in;
	
	private static ListaConcatenata myList = new ListaConcatenata();
	
	private static ListIterator myIterator = myList.listIterator();
	
	
	public static void main(String[] args) {
		
		JFrame f = new JFrame("Antonio Maulucci's Linked List");
		f.setSize(300, 300);
		f.setLayout(new BorderLayout());
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel consolePanel = new JPanel();
		consolePanel.setLayout(new GridLayout(4,3));
		
		JButton exitButton = new JButton("Exit");
		JButton openDBButton = new JButton("Open database");
		JButton saveDBButton = new JButton("Save database");
		JButton addToHeadListButton = new JButton("Add data to lsit's head");
		JButton addToEndListButton = new JButton("Add data to list's end");
		JButton printListButton = new JButton("Print all data");
		JButton searchSurnameButton = new JButton("Search by surname");
		JButton searchNumberButton = new JButton("Search by serial number");
		JButton deleteSurnameButton = new JButton("Delete data by surname");
		JButton deleteNumberButton = new JButton("Delete data by serial number");
		JButton deleteHeadList = new JButton("Delete data in list's head");
		JButton deleteEndList = new JButton("Delete data in list's end");
		
		consolePanel.add(openDBButton);
		consolePanel.add(saveDBButton);
		consolePanel.add(exitButton);
		consolePanel.add(addToHeadListButton);
		consolePanel.add(addToEndListButton);
		consolePanel.add(printListButton);
		consolePanel.add(searchSurnameButton);
		consolePanel.add(searchNumberButton);
		consolePanel.add(deleteSurnameButton);
		consolePanel.add(deleteNumberButton);
		consolePanel.add(deleteHeadList);
		consolePanel.add(deleteEndList);
		
		JPanel contentPanel = new JPanel();
		
		f.add(consolePanel, BorderLayout.NORTH);
		f.add(contentPanel, BorderLayout.CENTER);
		
		
		f.pack();
		
		
		JFileChooser fileChooser = new JFileChooser(); //new fileChooser object
		
		
		
		
		class openDBButtonListenerClass implements ActionListener {
			@Override
			public void actionPerformed (ActionEvent e) {
				//open database and load data
				fileChooser.showOpenDialog(f); //show new file chooser windows into frame f
				try {
					file = fileChooser.getSelectedFile(); //"file" become the file given by file chooser
					in = new Scanner(file);
				} catch(Exception exc) { //se si entra nel ramo catch stampa il log dell'errore e interrompi l'esecuzione del metodo corrente
					exc.printStackTrace();
					return;
				} //end of try/catch
				
				//String cognome, nome, esame;
				//int matricola, vesame;
				
				while (in.hasNext())
				{
					/*
					cognome = in.next();
					nome = in.next();
					matricola = in.nextInt();
					esame = in.next();
					vesame = in.nextInt();
					*/
					
					Studente stud = new Studente(in.next(), in.next(), in.nextInt(), in.next(), in.nextInt()); //vengono acquisiti i dati e si fa in modo che lo scanner scorra verso la serie di token successiva (più token vengono scansionati insieme)
					
					myList.addFirst(stud);
					
					//add data to list here
					//list.add(cognome, nome, matricola, esame, vesame);
					//System.out.println("current data = " + stud.getSurname() + " " + stud.getName() + " " + stud.getSerial() + " " + stud.getExamName() + " " + stud.getExamVote()); //debug
				} //end of while
				
			}
		}
		
		ActionListener openDBButtonListener = new openDBButtonListenerClass();
		openDBButton.addActionListener(openDBButtonListener);
		
		
		class exitButtonListenerClass implements ActionListener {
			@Override
			public void actionPerformed (ActionEvent e) {
				System.exit(0);
			}
		}
		
		ActionListener exitButtonListener = new exitButtonListenerClass();
		exitButton.addActionListener(exitButtonListener);
		
		
		
		
		
		class printListButtonListenerClass implements ActionListener {
			@Override
			public void actionPerformed (ActionEvent e) {
				contentPanel.removeAll();
				JLabel resultLabel = new JLabel(myList.toJLabelString());
				contentPanel.add(resultLabel);
				f.pack();
			}
		}
		
		ActionListener printListButtonListener = new printListButtonListenerClass();
		printListButton.addActionListener(printListButtonListener);
		
		
		
		
		
		
		
		class addToHeadListButtonListenerClass implements ActionListener {
			@Override
			public void actionPerformed (ActionEvent e) {
				contentPanel.removeAll();
				JPanel addHeadPanel = new JPanel();
				addHeadPanel.setLayout(new BorderLayout());
				
				JPanel inPanel = new JPanel();
				inPanel.setLayout(new GridLayout(5,2));
				
				JLabel surLab = new JLabel("Surname");
				JTextField surJtf = new JTextField();
				JLabel namLab = new JLabel("Name");
				JTextField namJtf = new JTextField();
				JLabel serLab = new JLabel("Serial Number");
				JTextField serJtf = new JTextField();
				JLabel nexLab = new JLabel("Exam's Name");
				JTextField nexJtf = new JTextField();
				JLabel vexLab = new JLabel("Exam's Votation");
				JTextField vexJtf = new JTextField();
				
				inPanel.add(surLab); //1,1
				inPanel.add(surJtf); //1,2
				inPanel.add(namLab); //2,1
				inPanel.add(namJtf); //2,2
				inPanel.add(serLab); //3,1
				inPanel.add(serJtf); //3,2
				inPanel.add(nexLab); //4,1
				inPanel.add(nexJtf); //4,2
				inPanel.add(vexLab); //5,1
				inPanel.add(vexJtf); //5,2
				
				JButton addHead = new JButton("Add");
				
				JLabel titleLabel = new JLabel("Add To Lis's Head");
				
				addHeadPanel.add(titleLabel, BorderLayout.NORTH);
				addHeadPanel.add(inPanel, BorderLayout.CENTER);
				addHeadPanel.add(addHead, BorderLayout.EAST);
				contentPanel.add(addHeadPanel);
				f.pack();
				
				class addEndButtonListenerClass implements ActionListener {
					@Override
					public void actionPerformed (ActionEvent e) {
						Studente toAddS = new Studente(surJtf.getText(), namJtf.getText(), Integer.parseInt(serJtf.getText()), nexJtf.getText(), Integer.parseInt(vexJtf.getText()));
						myList.addFirst(toAddS);
					} //end of internal actionPerformed
				} //end of addEndButtonListenerClass
				ActionListener addEndButtonListener = new addEndButtonListenerClass();
				addHead.addActionListener(addEndButtonListener);
				//----------------------------------------------------------------------\\
			} //end of external actionPerformed
		} //end of addToEndListButtonListenerClass
		
		ActionListener addToHeadListButtonListener = new addToHeadListButtonListenerClass();
		addToHeadListButton.addActionListener(addToHeadListButtonListener);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		class addToEndListButtonListenerClass implements ActionListener {
			@Override
			public void actionPerformed (ActionEvent e) {
				contentPanel.removeAll();
				JPanel addEndPanel = new JPanel();
				addEndPanel.setLayout(new BorderLayout());
				
				JPanel inPanel = new JPanel();
				inPanel.setLayout(new GridLayout(5,2));
				
				JLabel surLab = new JLabel("Surname");
				JTextField surJtf = new JTextField();
				JLabel namLab = new JLabel("Name");
				JTextField namJtf = new JTextField();
				JLabel serLab = new JLabel("Serial Number");
				JTextField serJtf = new JTextField();
				JLabel nexLab = new JLabel("Exam's Name");
				JTextField nexJtf = new JTextField();
				JLabel vexLab = new JLabel("Exam's Votation");
				JTextField vexJtf = new JTextField();
				
				inPanel.add(surLab); //1,1
				inPanel.add(surJtf); //1,2
				inPanel.add(namLab); //2,1
				inPanel.add(namJtf); //2,2
				inPanel.add(serLab); //3,1
				inPanel.add(serJtf); //3,2
				inPanel.add(nexLab); //4,1
				inPanel.add(nexJtf); //4,2
				inPanel.add(vexLab); //5,1
				inPanel.add(vexJtf); //5,2
				
				JButton addEnd = new JButton("Add");
				
				JLabel titleLabel = new JLabel("Add to List's end");
				
				addEndPanel.add(titleLabel, BorderLayout.NORTH);
				addEndPanel.add(inPanel, BorderLayout.CENTER);
				addEndPanel.add(addEnd, BorderLayout.EAST);
				contentPanel.add(addEndPanel);
				f.pack();
				
				class addEndButtonListenerClass implements ActionListener {
					@Override
					public void actionPerformed (ActionEvent e) {
						Studente toAddS = new Studente(surJtf.getText(), namJtf.getText(), Integer.parseInt(serJtf.getText()), nexJtf.getText(), Integer.parseInt(vexJtf.getText()));
						myList.addLast(toAddS);
					} //end of internal actionPerformed
				} //end of addEndButtonListenerClass
				ActionListener addEndButtonListener = new addEndButtonListenerClass();
				addEnd.addActionListener(addEndButtonListener);
				//----------------------------------------------------------------------\\
			} //end of external actionPerformed
		} //end of addToEndListButtonListenerClass
		
		ActionListener addToEndListButtonListener = new addToEndListButtonListenerClass();
		addToEndListButton.addActionListener(addToEndListButtonListener);
		
		
		
		
		
		
		
		class deleteHeadListButtonListenerClass implements ActionListener {
			@Override
			public void actionPerformed (ActionEvent e) {
				contentPanel.removeAll();
				myList.removeFirst();
				JLabel result = new JLabel("Done!");
				contentPanel.add(result);
				f.pack();
			}
		}
		
		ActionListener deleteHeadListButtonListener = new deleteHeadListButtonListenerClass();
		deleteHeadList.addActionListener(deleteHeadListButtonListener);
		
		
		
		
		
		
		
		class deleteEndListButtonListenerClass implements ActionListener {
			@Override
			public void actionPerformed (ActionEvent e) {
				contentPanel.removeAll();
				myList.removeLast();
				JLabel result = new JLabel("Done!");
				contentPanel.add(result);
				f.pack();
			}
		}
		
		ActionListener deleteEndListButtonListener = new deleteEndListButtonListenerClass();
		deleteEndList.addActionListener(deleteEndListButtonListener);
		
		
		
		
		
		
		
		
		class deleteSurnameButtonListenerClass implements ActionListener
		{
			@Override
			public void actionPerformed (ActionEvent e)
			{
				contentPanel.removeAll();
				JPanel removePanel = new JPanel();
				removePanel.setLayout(new BorderLayout());
				//
				JLabel titlePanel = new JLabel("Remove by Surname");
				JLabel label = new JLabel("Surname to remove");
				JTextField jtf = new JTextField();
				JButton delButton = new JButton("Remove");
				//
				removePanel.add(titlePanel, BorderLayout.NORTH);
				removePanel.add(label, BorderLayout.WEST);
				removePanel.add(jtf, BorderLayout.CENTER);
				removePanel.add(delButton, BorderLayout.EAST);
				//
				contentPanel.add(removePanel);
				f.pack();
				class delButtonListenerClassListener implements ActionListener
				{
					@Override
					public void actionPerformed (ActionEvent e)
					{
						myIterator.reset();
						while (myIterator.hasNext())
						{
							Studente stud = myIterator.next();
							if (stud.getSurname().equals(jtf.getText())) myIterator.remove();
						} //end of while
						//
					} //end of internal actionPerformed
				} //end of delButtonListenerClass
				//
				ActionListener delButtonListenerClass = new delButtonListenerClassListener();
				delButton.addActionListener(delButtonListenerClass);
				//
			} //end of external actionPerformed
		} //end of deleteSurnameButtonListenerClass
		
		ActionListener deleteSurnameButtonListener = new deleteSurnameButtonListenerClass();
		deleteSurnameButton.addActionListener(deleteSurnameButtonListener);
		
		
		
		
		
		
		
		
		
		class deleteNumberButtonListenerClass implements ActionListener
		{
			@Override
			public void actionPerformed (ActionEvent e)
			{
				contentPanel.removeAll();
				JPanel removePanel = new JPanel();
				removePanel.setLayout(new BorderLayout());
				//
				JLabel titlePanel = new JLabel("Remove by Surname");
				JLabel label = new JLabel("Surname to remove");
				JTextField jtf = new JTextField();
				JButton delButton = new JButton("Remove");
				//
				removePanel.add(titlePanel, BorderLayout.NORTH);
				removePanel.add(label, BorderLayout.WEST);
				removePanel.add(jtf, BorderLayout.CENTER);
				removePanel.add(delButton, BorderLayout.EAST);
				//
				contentPanel.add(removePanel);
				f.pack();
				class delButtonListenerClassListener implements ActionListener
				{
					@Override
					public void actionPerformed (ActionEvent e)
					{
						myIterator.reset();
						Studente stud;
						while (myIterator.hasNext())
						{
							stud = myIterator.next();
							if (stud.getSerial() == Integer.parseInt(jtf.getText())) myIterator.remove();
						} //end of while
						//
					} //end of internal actionPerformed
				} //end of delButtonListenerClass
				//
				ActionListener delButtonListenerClass = new delButtonListenerClassListener();
				delButton.addActionListener(delButtonListenerClass);
				//
			} //end of external actionPerformed
		} //end of deleteSurnameButtonListenerClass
		
		ActionListener deleteNumberButtonListener = new deleteNumberButtonListenerClass();
		deleteNumberButton.addActionListener(deleteNumberButtonListener);
		
		
		
	} //end of main

} //end of class
