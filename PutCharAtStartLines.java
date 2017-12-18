/*
 * PROGRAMMA CHE AGGIUNGE IL CARATTERE SCELTO DALL'UTENTE ALL'INIZIO DI OGNI RIGA DI UN FILE
 * (C) Antonio Maulucci 2017
 * 
 * Il file di origine chiamato f e' definito nel codice e puo' essere modificato.
 * Questo programma non gestisce eccezioni ma utilizza quelle di default di Java.
 */

package com.antomau.putcharatstartline;

import java.io.*;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class PutCharAtStartLine {

	public static void main(String args[]) throws FileNotFoundException
	{
		//File f = new File(args[1]); //new file
		File f = new File("text.txt");
		
		Scanner sc = new Scanner(f); //new scanner for file
		Scanner in = new Scanner(System.in); //scanner for user inputs
		
		System.out.println("What char do ypu want to put at every start-line: ");
		char c = in.next().charAt(0); //take the char from user
		
		newfile(c, sc);
		
		sc.close(); //close the file's scanner
		in.close(); //close the stdin scanner
		
		System.out.println("Done! '" + c + "' added at every start of line!");
		
	}
	
	/**
	 * Questo metodo inserisce ad ogni inizio riga il carattere definito dall'utente
	 * @param c Il carattere da inserire all'inizio di ogni riga
	 * @param sc Lo scanner del file da leggere
	 */
	public static void newfile(char c, Scanner sc) throws FileNotFoundException
	{
		
		PrintWriter outfile = new PrintWriter("nfile.txt"); //file di destinazione (nfile.txt)
		
		while (sc.hasNextLine())
		{
			String cur = sc.nextLine(); //cur e' la stringa corrente all'interno del file
			String newstr = c + " " + cur; //newstr = carattere + spazio + riga originaria
			
			/*
			 * per evitare che alla fine del file vi sia un'andata a capo indesiderata
			 * effettuo un controllo per verificare se c'e' o meno un'ulteriore riga nel file:
			 * Se vi e' un altra tiga aggiungo un andata a capo
			 * altrimenti no
			 */
			if (sc.hasNextLine()==true)
				newstr += '\n';
			
			
			outfile.print(newstr); //print no println: per non aggiungere andate a capo le quali sono controllate manualmente
		}
		
		outfile.close(); //chiusura del file di destinazione
		
	}
	
}
