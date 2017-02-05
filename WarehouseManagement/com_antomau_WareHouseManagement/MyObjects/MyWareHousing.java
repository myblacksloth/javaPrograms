package com_antomau_WareHouseManagement.MyObjects;



import com_antomau_WareHouseManagement.GenericObjects.GenericWarehousing;



/**
 * Questa classe estende la classe GenericWarehousing
 * @author Anto
 */
public class MyWareHousing extends GenericWarehousing {
	
	
	//variabili
	int qt; //quantità di scorte nel magazzino
	
	
	
	/**
	 * Costruttore della classe
	 * @param wserial codice seriale del magazzino
	 * @param pserial codice seriale del prodotto
	 * @param qt quantita' di scorte nel magazzino
	 */
	public MyWareHousing(String wserial, String pserial, int qt)
	{
		super(wserial, pserial); //viene chiamato il costuttore della superclasse
		
		this.qt = qt;
	}
	
	
	
	
	/**
	 * @return il numero di scorte di magazzino
	 */
	public int getQt()
	{
		return this.qt;
	}
	
	
	
	
	
	
}
