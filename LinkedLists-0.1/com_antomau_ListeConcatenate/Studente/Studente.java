package com_antomau_ListeConcatenate.Studente;

public class Studente {
	
	//variabili
	String surname;
	String name;
	int serialNumber;
	String examName;
	int  examVote;
	
	/**
	 * Builder
	 * @param s Surname
	 * @param n Name
	 * @param se Serial Number
	 * @param ne Exam's name
	 * @param ve Exam's vote
	 */
	public Studente(String s, String n, int se, String ne, int ve)
	{
		this.surname = s;
		this.name = n;
		this.serialNumber = se;
		this.examName = ne;
		this.examVote = ve;
	}
	
	/**
	 * @return Student's surname.
	 */
	public String getSurname()
	{
		return surname;
	}
	
	/**
	 * @retur Student's name.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return Student's serial number.
	 */
	public int getSerial() {
		return serialNumber;
	}
	
	/**
	 * @return Exam's name.
	 */
	public String getExamName() {
		return examName;
	}
	
	/**
	 * @return Exam's vote.
	 */
	public int getExamVote() {
		return examVote;
	}

} //end of class
