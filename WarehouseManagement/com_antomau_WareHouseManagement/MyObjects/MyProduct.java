package com_antomau_WareHouseManagement.MyObjects;



import com_antomau_WareHouseManagement.GenericObjects.GenericProduct;

public class MyProduct extends GenericProduct {
	
	
	/**
	 * costruttor della classe
	 * @param serial codice seriale del prodotto
	 * @param description descrizione del prodotto
	 * @param price prezzo del prodotto
	 */
	public MyProduct(String serial, String description, int price)
	{
		
		super(serial, description, price); //invocazione del costruttore dell superclasse
		
	}
	
	
	
	
	
}
