package com_antomau_WareHouseManagement.MyObjects;



import com_antomau_WareHouseManagement.GenericObjects.GenericMapManager;





import java.util.Set;
import java.util.Map;



public class MyMapManager extends GenericMapManager {
	
	//l'oggetto di tipo mappa si chiama 'map' all'interno della superclasse
	
	/**
	 * costruttore della classe
	 */
	public MyMapManager()
	{
		super(); //invocazione del metodo costruttore
	}
	
	
	
	
	
	
	
	
	//ottenere i dati della mappa
	
	
	
	
	public void getData()
	{
		/*
		 * devo ottenere la chiave della mappa generale
		 * la chiave della mappa generale e' la mappa specifica
		 * il valore della mappa specifica e' il numero di prodotti nel magazzino
		 * 
		 * devo ottenere la chiave della mappa specifica
		 * la chive della mappa specifica e' il magazzino
		 * il valore della mappa specifica e' il prodotto
		 */
		
		
		//variabili
		int qt=0;
		MyWarehouse w = null;
		MyProduct p = null;
		
		
		//ottengo il keyset della mappa generale
		Set<Map<MyWarehouse, MyProduct>> finalSet = finalMap.keySet();
		
		//itero per ogni chiave della mappa generale
		for (Map<MyWarehouse, MyProduct> m : finalSet)
		{
			
			//ottengo il numero di prodotto per questo magazzino
			//ottengo il valore della corrente chiave della mappa
			qt = finalMap.get(m); //ottengo il valore della chiave m della mappa finalMap
			
			//ottenere il keySet della mappa interna (m)
			Set<MyWarehouse> mapSet = m.keySet();
			
			//itero per ogni chiave della mappa interna
			for (MyWarehouse iw : mapSet)
			{
				
				w = iw; //ottengo la chiave della mappa interna
				
				//ottengo il valore della chiave della mappa interna (m)
				
				p = m.get(w);
				
				
				//stampo i dati raccolti
				System.out.println(w.getSerial() + " <---> " + p.getSerial() + " <---> " + qt);
				
			}
			
		}
		
		
		
		
		
	} //end of getData()
	
	
	
	
	
	
	
	
	
	/**
	 * Questo metodo crea un set della mappa e lo restituisce
	 * @return Un set della mappa
	 */
	public Set<Map<MyWarehouse, MyProduct>> getSet()
	{
		Set<Map<MyWarehouse, MyProduct>> mySet = finalMap.keySet();
		
		return mySet;
	}
	
	
	
	
	
	
	/**
	 * @return Una stringa del contenuto della mappa da usare come testo di una JLabel formattata in HTML
	 */
	public String toLabel()
	{
		String result="";
		
		int qt; //quantità di prodotti nel tale magazzino
		MyWarehouse w; //il magazzino corrente
		MyProduct p; //il prodotto corrente
		
		//ottengo il set della mappa
		Set<Map<MyWarehouse, MyProduct>> finalSet = getSet();
		
		
		
		result += "<html><table border=\"1\">";
		
		
		
		/*
		 * iterazione della mappa e ottenimento delle varie chiavi
		 */
		for (Map<MyWarehouse, MyProduct> m : finalSet)
		{
			
			//ottengo il numero di prodotto per questo magazzino
			//ottengo il valore della corrente chiave della mappa
			qt = finalMap.get(m); //ottengo il valore della chiave m della mappa finalMap
			
			//ottenere il keySet della mappa interna (m)
			Set<MyWarehouse> mapSet = m.keySet();
			
			//itero per ogni chiave della mappa interna
			for (MyWarehouse iw : mapSet)
			{
				
				w = iw; //ottengo la chiave della mappa interna
				
				//ottengo il valore della chiave della mappa interna (m)
				
				p = m.get(w);
				
				
				//stampo i dati raccolti
				System.out.println(w.getSerial() + " <---> " + p.getSerial() + " <---> " + qt);
				
				result += "<tr><td>" + w.getSerial() + "</td><td>" + w.getAddress() + "</td>";
				result += "<td>" + w.getCity() + "</td><td>" + w.getCountry() + "</td><td>" + w.getPhone() + "</td<td>" + w.getFax() + "</td></tr>";
				
				result += "<tr><td>" + p.getSerial() + "</td><td>" + p.getDescription() + "</td><td>" + p.getPrice() +"</td><td>" + qt + "</tr>";
				
			}
			
		}
		
		
		
		
		
		result +="</table></html>";
		
		return result;
	}
	
	
	
	
	
	
	
	/*
	 * filtro di ricerca per la ricerca di un oggetto
	 */
	/**
	 * filtro di ricerca per un prodotto
	 * @param f il codice seriale del prodotto da cercare
	 * @return una stringa con i risultati formattata in html al file di essere impostata come argomento di una JLabel
	 */
	public String finder(String f)
	{
		String result="";
		
		
		
		
		int qt; //quantità di prodotti nel tale magazzino
		MyWarehouse w; //il magazzino corrente
		MyProduct p; //il prodotto corrente
		
		//ottengo il set della mappa
		Set<Map<MyWarehouse, MyProduct>> finalSet = getSet();
		
		
		
		result += "<html><table border=\"1\">";
		
		
		/*
		 * iterazione della mappa e ottenimento delle varie chiavi
		 */
		for (Map<MyWarehouse, MyProduct> m : finalSet)
		{
			
			//ottengo il numero di prodotto per questo magazzino
			//ottengo il valore della corrente chiave della mappa
			qt = finalMap.get(m); //ottengo il valore della chiave m della mappa finalMap
			
			//ottenere il keySet della mappa interna (m)
			Set<MyWarehouse> mapSet = m.keySet();
			
			//itero per ogni chiave della mappa interna
			for (MyWarehouse iw : mapSet)
			{
				
				w = iw; //ottengo la chiave della mappa interna
				
				//ottengo il valore della chiave della mappa interna (m)
				
				p = m.get(w);
				
				
				if (p.getSerial().equals(f))
				{
					result += "<tr></tr>"; //blank row
					result += "<tr><td>" + qt + "</td></tr>";
					result += "<tr><td>" + p.getSerial() + "</td><td>" + p.getDescription() + "</td><td>" + p.getPrice() + "</td></tr>";
					result += "<tr><td>Are stored in:</td></tr>";
					result += "<tr><td>" + w.getSerial() + "</td><td>" + w.getAddress() + "</td>";
					result += "<td>" + w.getCity() + "</td><td>" + w.getCountry() + "</td><td>" + w.getPhone() + "</td<td>" + w.getFax() + "</td></tr>";
				}
				
				
			}
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		result +="</table></html>";
		
		
		
		
		
		return result;
		
		
	} //end of finder
	
	
	
	
	
	
	
	
	
	
	
	
	
}
