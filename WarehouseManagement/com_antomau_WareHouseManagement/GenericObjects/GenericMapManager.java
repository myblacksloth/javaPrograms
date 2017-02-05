package com_antomau_WareHouseManagement.GenericObjects;


import java.util.Map;
import java.util.HashMap;


import com_antomau_WareHouseManagement.MyObjects.MyWarehouse;
import com_antomau_WareHouseManagement.MyObjects.MyProduct;



public class GenericMapManager {
	
	
	
	
	//variabili
	public static Map<MyWarehouse, MyProduct> map; //nuova mappa
	public static Map<Map<MyWarehouse, MyProduct>, Integer> finalMap;
	
	
	
	/**
	 * costruttore della classe
	 */
	public GenericMapManager()
	{
		map = null; //inizializzazione della mappa al tipo HashMap
		finalMap = new HashMap<Map<MyWarehouse, MyProduct>, Integer>();
	}
	
	
	
	
	
	public void addToMap(MyWarehouse w, MyProduct p, int i)
	{
		map = new HashMap<MyWarehouse, MyProduct>(); //inizializzazione della mappa al tipo HashMap
		map.put(w, p);
		finalMap.put(map, i);
	}
	
	
	
	
}
