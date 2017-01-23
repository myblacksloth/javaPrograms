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
				fileChooser.setDialogTitle("Specify a file to open");
				fileChooser.showOpenDialog(f); //show new file chooser windows into frame f
				try {
					file = fileChooser.getSelectedFile(); //"file" become the file given by file chooser
					in = new Scanner(file);
				} catch(Exception exc) { //se si entra nel ramo catch stampa il log dell'errore e interrompi l'esecuzione del metodo corrente
					exc.printStackTrace();
					return;
				} //end of try/catch
				
				
				while (in.hasNext())
				{
					Studente stud = new Studente(in.next(), in.next(), in.nextInt(), in.next(), in.nextInt()); //vengono acquisiti i dati e si fa in modo che lo scanner scorra verso la serie di token successiva (più token vengono scansionati insieme)
					
					myList.addFirst(stud);
					
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
				
				JLabel titlePanel = new JLabel("Remove by Surname");
				JLabel label = new JLabel("Surname to remove");
				JTextField jtf = new JTextField();
				JButton delButton = new JButton("Remove");
				
				removePanel.add(titlePanel, BorderLayout.NORTH);
				removePanel.add(label, BorderLayout.WEST);
				removePanel.add(jtf, BorderLayout.CENTER);
				removePanel.add(delButton, BorderLayout.EAST);
				
				contentPanel.add(removePanel);
				f.pack();
				class delButtonListenerClassListener implements ActionListener
				{
					@Override
					public void actionPerformed (ActionEvent e)
					{
						myIterator.reset(); //reset the list's iterator
						while (myIterator.hasNext()) //il ciclo while scorre la lista fintanto che esiste un nodo successivo a quello corrente
						{
							Studente stud = myIterator.next(); //la variabile stud salva il valore puntato dall'iteratore e fa scorrere in avanti l'iteratore
							if (stud.getSurname().equals(jtf.getText())) myIterator.remove(); //se il cognome dell'oggetto corrente corrisponde a quello da eliminare il nodo viene eliminato
						} //end of while
						
					} //end of internal actionPerformed
				} //end of delButtonListenerClass
				
				ActionListener delButtonListenerClass = new delButtonListenerClassListener();
				delButton.addActionListener(delButtonListenerClass);
				
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
				
				JLabel titlePanel = new JLabel("Remove by Surname");
				JLabel label = new JLabel("Surname to remove");
				JTextField jtf = new JTextField();
				JButton delButton = new JButton("Remove");
				
				removePanel.add(titlePanel, BorderLayout.NORTH);
				removePanel.add(label, BorderLayout.WEST);
				removePanel.add(jtf, BorderLayout.CENTER);
				removePanel.add(delButton, BorderLayout.EAST);
				
				contentPanel.add(removePanel);
				f.pack();
				class delButtonListenerClassListener implements ActionListener
				{
					@Override
					public void actionPerformed (ActionEvent e)
					{
						myIterator.reset(); //reset dell'iteratore
						Studente stud; //questa variabile dovra' immagazzinare lo studente contenuto nel nodo correntemente puntato dall'iteratore
						while (myIterator.hasNext()) //mentre esiste un nodo successivo a quello corrente
						{
							stud = myIterator.next(); //lo studente memorizzato nel nodo corrente diviene il valore della variabile stud
							if (stud.getSerial() == Integer.parseInt(jtf.getText())) myIterator.remove(); //se il seriale contenuto nel nodo corrent e' uguale a quello da eliminare viene eliminato il nodo corrente
						} //end of while
						
					} //end of internal actionPerformed
				} //end of delButtonListenerClass
				
				ActionListener delButtonListenerClass = new delButtonListenerClassListener();
				delButton.addActionListener(delButtonListenerClass);
				
			} //end of external actionPerformed
		} //end of deleteSurnameButtonListenerClass
		
		ActionListener deleteNumberButtonListener = new deleteNumberButtonListenerClass();
		deleteNumberButton.addActionListener(deleteNumberButtonListener);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		class searchSurnameButtonListenerClass implements ActionListener
		{
			@Override
			public void actionPerformed (ActionEvent e)
			{
				contentPanel.removeAll();
				//
				JPanel internalPanel = new JPanel();
				internalPanel.setLayout(new BorderLayout());
				//
				JPanel searchPanel = new JPanel();
				searchPanel.setLayout(new GridLayout(1,3));
				//
				JLabel label = new JLabel("Surname:");
				JTextField jtf = new JTextField();
				JButton fb = new JButton("Find");
				
				searchPanel.add(label); //1,1
				searchPanel.add(jtf); //1,2
				searchPanel.add(fb); //1,3
				
				JLabel title = new JLabel("Search by Surname");
				
				internalPanel.add(title, BorderLayout.NORTH);
				internalPanel.add(searchPanel, BorderLayout.CENTER);
				contentPanel.add(internalPanel);
				f.pack();
				
				class fbListenerClass implements ActionListener
				{
					@Override
					public void actionPerformed (ActionEvent e)
					{
						String results = "<html><table border=\"1\"><tr><th>Surname</th><th>Name</th><th>Serial Number</th><th>Exam's Name</th><th>Exam's Vote</th></tr>";
						myIterator.reset(); //reset dell'iteratore
						while (myIterator.hasNext()) //fintanto che nella lista esiste un nodo
						{
							Studente stud = myIterator.next();
							if (stud.getSurname().equals(jtf.getText())) results += "<tr><td>" + stud.getSurname() + "</td><td>" + stud.getName() + "</td><td>" + stud.getSerial() + "</td><td>" + stud.getExamName() + "</td><td>" + stud.getExamVote() + "</td></tr>";
						} //end of while
						results += "</table></html>";
						JLabel labelResults = new JLabel(results);
						internalPanel.add(labelResults, BorderLayout.SOUTH);
						f.pack();
					} //end of internal actionPerformed
				} //end of fbListenerClass
				
				ActionListener fbListener = new fbListenerClass();
				fb.addActionListener(fbListener);
				
			} //end of external actionPerformed
		} //end of searchSurnameButtonListenerClass
		
		ActionListener searchSurnameButtonListener = new searchSurnameButtonListenerClass();
		searchSurnameButton.addActionListener(searchSurnameButtonListener);
		
		
		
		
		
		
		
		
		class searchNumberButtonListenerClass implements ActionListener
		{
			@Override
			public void actionPerformed (ActionEvent e)
			{
				contentPanel.removeAll();
				
				JPanel internalPanel = new JPanel();
				internalPanel.setLayout(new BorderLayout());
				
				JPanel searchPanel = new JPanel();
				searchPanel.setLayout(new GridLayout(1,3));
				
				JLabel label = new JLabel();
				JTextField jtf = new JTextField();
				JButton fb = new JButton("Find");
				
				searchPanel.add(label); //1,1
				searchPanel.add(jtf); //1,2
				searchPanel.add(fb); //1,3
				
				JLabel title = new JLabel("Search by Surname");
				
				internalPanel.add(title, BorderLayout.NORTH);
				internalPanel.add(searchPanel, BorderLayout.CENTER);
				contentPanel.add(internalPanel);
				f.pack();
				
				class fbListenerClass implements ActionListener
				{
					@Override
					public void actionPerformed (ActionEvent e)
					{ // (C) Antonio Maulucci 2017 - http://www.antomau.com
						String results = "<html><table border=\"1\"><tr><th>Surname</th><th>Name</th><th>Serial Number</th><th>Exam's Name</th><th>Exam's Vote</th></tr>";
						myIterator.reset(); //reset dell'iteratore
						while (myIterator.hasNext()) //fintanto che nella lista esiste un nodo
						{
							Studente stud = myIterator.next();
							if (stud.getSerial() == Integer.parseInt(jtf.getText())) results += "<tr><td>" + stud.getSurname() + "</td><td>" + stud.getName() + "</td><td>" + stud.getSerial() + "</td><td>" + stud.getExamName() + "</td><td>" + stud.getExamVote() + "</td></tr>";
						} //end of while
						results += "</table></html>";
						JLabel labelResults = new JLabel(results);
						internalPanel.add(labelResults, BorderLayout.SOUTH);
						f.pack();
					} //end of internal actionPerformed
				} //end of fbListenerClass
				
				ActionListener fbListener = new fbListenerClass();
				fb.addActionListener(fbListener);
				
			} //end of external actionPerformed
		} //end of searchSurnameButtonListenerClass

		ActionListener searchNumberButtonListener = new searchNumberButtonListenerClass();
		searchNumberButton.addActionListener(searchNumberButtonListener);
		
		
		
		
		
		
		
		
		class saveDBButtonListenerClass implements ActionListener
		{
			@Override
			public void actionPerformed (ActionEvent e)
			{
				PrintWriter outFile; //viene creata una variabile di tipo PrintWriter che servirà a stampare i dati all'interno del file
				try {
					fileChooser.setDialogTitle("Specify a file to save"); //viene impostato un titolo per la finestra di dialogo realtiva alla scelta dei file
					fileChooser.showSaveDialog(f); //viene mostrata una finestra di dialogo relativa al salvataggio dei file
					outFile = new PrintWriter(fileChooser.getSelectedFile()); //la variabile outFile assume il valore del file scelto mediante la finestra per il salvataggio di un file
				} catch(Exception exc) { //se non si riesce a scegliere un file in cui salvare
					exc.printStackTrace(); //viene stampata la traccia dell'errore
					return; //viene interrotta l'esecuzione del metodo
				} //end of try/cathc
				
				String toFile=""; //viene istituita una stringa in cui inserire i dati da salvare nel file
				
				Studente s; //viene creata una variabile di tipo studente
				myIterator.reset(); //viene effettuato il reset dell'iteratore
				while (myIterator.hasNext()) //fintanto che nella lista e' presente uno elemento successivo
				{
					s = myIterator.next(); //lo studente s diviene lo studente del nodo attuale e si scorre al nodo successivo della lista, lo scanner avanza al nodo successivo
					toFile += s.getSurname() + " " + s.getName() + " " + s.getSerial() + " " + s.getExamName() + " " + s.getExamVote(); //la stringa toFile viene aggiornata con i relativi dati dello studente contenuto nel nodo attuale
					if (myIterator.hasNext()) toFile += '\n'; //(non effettua lo scorrimento dello scanner) se esite un nodo successivo a quello attuale vuol dire che c'e' uno studente successivo e quindi si inserisce un andata a capo in modo che lo studnete successivo, all'interno del file, sia situato alla riga successiva
				} //end of while
				
				outFile.print(toFile); //viene stampata la stringa toFile all'interno del file outFile
				
				outFile.close(); //il file outFile viene chiuso
			} //end of actionPerformed
		} //end of saveDBButtonListenerClass

		//saveDBButton.addActionListener(new saveDBButtonListenerClass());
		ActionListener saveDBButtonListener = new saveDBButtonListenerClass();
		saveDBButton.addActionListener(saveDBButtonListener);
		
		
		
		
		
		
		
		
		
		
		
		
		
	} //end of main

} //end of class
