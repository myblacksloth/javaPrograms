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

public class UserListeConcatenate {
	
	private static File file;
	
	private static Scanner in;
	
	private static ListaConcatenata myList = new ListaConcatenata();
	
	
	public static void main(String[] args) {
		
		JFrame f = new JFrame();
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
		
		
		
		ListIterator myIterator = myList.listIterator();
		
		
		
		
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
				//
			}
		}
		
		ActionListener printListButtonListener = new printListButtonListenerClass();
		printListButton.addActionListener(printListButtonListener);
		
		
		
		
	} //end of main

} //end of class
