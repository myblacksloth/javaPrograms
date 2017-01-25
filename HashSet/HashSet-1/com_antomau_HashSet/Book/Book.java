package com_antomau_HashSet.Book;

public class Book {
	
	
	//variables
	String author, title;
	int year;
	
	/**
	 * Costruttore della classe.
	 * @param author Autore del libro.
	 * @param title Titolo del libro.
	 * @param year Anno di pubblicazione del libro.
	 */
	public Book(String author, String title, int year)
	{
		this.author = author;
		this.title = title;
		this.year = year;
	} //end of builder
	
	
	/**
	 * @return Autore del libro.
	 */
	public String getAuthor()
	{
		return author;
	}
	
	
	
	/**
	 * @return Titolo del libro.
	 */
	public String getTitle()
	{
		return title;
	}
	
	
	/**
	 * @return Anno di pubblicazione del libro.
	 */
	public int getYear()
	{
		return year;
	}
	
	
	
	/**
	 * @return HashCode del libro corrente.
	 */
	public int getHashCode()
	{
		
		int multiplier = 26;
		int factor = 12;
		
		int hash = 0;
		
		hash += title.hashCode();
		hash += author.hashCode();
		hash += year;
		
		hash *= multiplier;
		
		hash %= factor;
		
		if (hash < 0) hash *= (-1);
		
		return hash;
	}
	
	
	
} //end of class
