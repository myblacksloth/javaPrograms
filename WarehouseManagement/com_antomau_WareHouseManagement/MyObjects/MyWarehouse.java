package com_antomau_WareHouseManagement.MyObjects;


import com_antomau_WareHouseManagement.GenericObjects.GenericWarehouse;


public class MyWarehouse extends GenericWarehouse {
	
	
	//variabili
	String phone, fax;
	
	
	/**
	 * costruttore della classe
	 * @param serial codice seriale del magazzino
	 * @param address indirizzo del magazzino
	 * @param city citta' del magazzino
	 * @param country Paese del magazzino
	 * @param phone numero di telefono del magazzino
	 * @param fax numero di fax del magazzino
	 */
	public MyWarehouse(String serial, String address, String city, String country, String phone, String fax)
	{
		super(serial, address, city, country); //invocazione del costruttore della superclasse
		
		this.phone = phone;
		this.fax = fax;
		
	}
	
	
	
	
	/**
	 * @return il numero di telefono del magazzino
	 */
	public String getPhone()
	{
		return this.phone;
	}
	
	
	
	
	/**
	 * @return il numero di fax del magazzino
	 */
	public String getFax()
	{
		return this.fax;
	}
	
	
}
