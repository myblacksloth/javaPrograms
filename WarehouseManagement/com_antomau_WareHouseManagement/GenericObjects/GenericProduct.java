package com_antomau_WareHouseManagement.GenericObjects;

public class GenericProduct {
	
	
	
	
	//variabili
	String serial, description;
	int price;
	
	
	
	
	/**
	 * costruttore della classe
	 * @param serial seriale dell'oggetto
	 * @param description descrizione
	 * @param price prezzo
	 */
	public GenericProduct(String serial, String description, int price)
	{
		
		this.serial = serial;
		
		this.description = description;
		
		this.price = price;
		
	}
	
	
	
	
	
	/**
	 * @return codice seriale
	 */
	public String getSerial()
	{
		return this.serial;
	}
	
	
	
	
	/**
	 * @return descrizione
	 */
	public String getDescription()
	{
		return this.description;
	}
	
	
	
	/**
	 * @return prezzo
	 */
	public int getPrice()
	{
		return this.price;
	}
	
	
	
	
	
	
	
	
}
