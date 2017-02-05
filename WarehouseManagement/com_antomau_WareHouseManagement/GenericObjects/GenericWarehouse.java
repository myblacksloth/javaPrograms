package com_antomau_WareHouseManagement.GenericObjects;


/**
 * Questa classe definisce un generico magazzino
 * @author Antonio Maulucci
 */
public class GenericWarehouse {
	
	
	
	
	//variabili
	String serial, address, city, country;
	
	
	
	
	/**
	 * Costruttore della classe
	 * @param serial codice seriale del magazzino
	 * @param address indirizzo del magazzino
	 * @param city citta' del magazzino
	 * @param country nazione del magazzino
	 */
	public GenericWarehouse(String serial, String address, String city, String country)
	{
		
		this.serial = serial;
		this.address = address;
		this.city = city;
		this.country = country;
		
	}
	
	
	
	
	
	/**
	 * @return codice seriale del magazzino
	 */
	public String getSerial()
	{
		return this.serial;
	}
	
	
	/**
	 * @return l'indirizzo del magazzino
	 */
	public String getAddress()
	{
		return this.address;
	}
	
	
	/**
	 * @return la città in cui si trova il magazzino
	 */
	public String getCity()
	{
		return this.city;
	}
	
	
	
	
	/**
	 * @return il Paese in cui si trova il magazzino
	 */
	public String getCountry()
	{
		return this.country;
	}
	
	
	
	
	
	
}
