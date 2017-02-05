package com_antomau_WareHouseManagement.GenericObjects;

/**
 * Questa classe si occupa di creare un oggetto di tipo Warehousing generico
 * @author Antonio Maulucci
 */
public class GenericWarehousing {
	
	//variaibli
	String wserial, pserial;
	
	
	
	/**
	 * Costruttore della classe
	 * @param wserial seriale del magazzino
	 * @param pserial sriale del prodotto
	 */
	public GenericWarehousing(String wserial, String pserial)
	{
		this.wserial = wserial;
		this.pserial = pserial;
	}
	
	/**
	 * @return il codice seriale del magazzino
	 */
	public String getWSerial()
	{
		return this.wserial;
	}
	
	
	/**
	 * @return il codice seriale del prodotto
	 */
	public String getPSerial()
	{
		return this.pserial;
	}
	
	
	
	
}
