package com_antomau_HotelManagement.Classi;


import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

import com_antomau_HotelManagement.Struct.List;
import com_antomau_HotelManagement.Struct.ListIterator;



/**
 * questa classe definisce la collezione di hotel
 * @author Antonio Maulucci on 2017/02/17 http://www.antomau.com
 */
public class Collection {
	
	
	
	private List l;
	private Scanner scH, scR;
	
	
	public Collection(File hotels, File rooms) //il costruttor della classe deve creare la collezione di dati
	{
		this.l = new List();
		try
		{
			this.scH = new Scanner(hotels); //creo uno scanner per il file degli hotel
			
			
			
			// DEVO CREARE LA COLLEZIONE DI HOTEL CON STANZE ANNESSE
			// QUESTO BLOCCO DI CODICE VA INSERITO NEL METODO COSTRUTTORE DELLA COLLEZIONE IL QUALE SI OCCUPERA' DI CREARE UNA COLLEZIONE DI HOTEL
			// (C) Antonio Maulucci 2017 http://www.antomau.com
			Hotel h = new Hotel(); //creo un nuovo oggetto di tipo hotel
			while (scH.hasNextLine()) //fintanto che nel file degli hotel ci sia un ulteriore hotel
			{
				h = h.read(scH); //leggo i dati per l'hotel corrente

				/*
				 * la classe hotel contiene una collezione di stanze sotto forma di arrayList
				 * pertanto creo un arraylist che ospitera' le stanze
				 */
				ArrayList<Room> rr = new ArrayList<Room>();

				this.scR = new Scanner(rooms); //creo uno scanner per il file delle stanze
				while (scR.hasNextLine()) //fintanto che nel file delle stanze ci sia un'ulteriore riga
				{

					String cur = scR.nextLine().toUpperCase(); //acquisisco la prossima riga del file

					if (cur.equals(h.getSerial())) //se la stringa acquisita corrisponde al codice dell'hotel corrente vuol dire che le seguenti stanze appartengono a tale hotel
					{
						String nextLine = scR.nextLine();

						//devo acquisire tutte le stanze per tale hotel fino a quando non incontro il carattere '#'
						while (scR.hasNextLine() && !(nextLine.equals("#")))
						{
							
							int type = Integer.parseInt(nextLine);
							int num = Integer.parseInt(scR.nextLine());
							int price = Integer.parseInt(scR.nextLine());

							boolean tv = false;
							if (scR.nextLine().toUpperCase().equals("SI")) tv = true;

							boolean air = false;
							if (scR.nextLine().toUpperCase().equals("SI")) air = true;

							boolean fridge = false;
							if (scR.nextLine().toUpperCase().equals("SI")) fridge = true;

							boolean internet = false;
							if (scR.nextLine().toUpperCase().equals("SI")) internet = true;

							//creo la nuova stanza con i dati appena acquisiti
							Room r = new Room(type, num, price, tv, air, fridge, internet);

							//aggiungo la stanza appena creata all'arrayList di stanze
							rr.add(r);
							
							//aggiorno il valore di nextLine
							if (scR.hasNextLine()) nextLine = scR.nextLine();
						}

					}
				}

				// a questo punto del programma tutte le stanze dell'hotel sono state acqusite e quindi agginungo la collezione di stanze all'hotel corrente
				h.setRooms(rr);

				//a questo punto del programma non occorre faltro altro che aggiungere l'hotel alla collezione di hotel (lista)
				l.addLast(h);
			}
	
			
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
			System.exit(1); //se non e' possibile caricare i dati il programma viene interrotto con il codice di errore '1'
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//test
	public void add(Hotel h)
	{
		l.addFirst(h);
	}
	
	
	
	
	public void print(PrintStream p)
	{
		ListIterator li = l.listIterator();
		while (li.hasNext())
		{
			p.println(li.next().toString());
		}
	}
	
	
	
	//filtro di ricerca per le stanze
	
	public List roomFilter(int price, int largerprice, boolean checktv, boolean checkair, boolean checkfridge, boolean checkinternet)
	{
		List results = new List();
		
		ListIterator li = l.listIterator();
		
		while (li.hasNext())
		{
			
			Hotel h = li.next(); //hotel presente nella lista
			
			Hotel hotelResult = h.copyWithoutRooms();
			
			ArrayList<Room> rr = h.getRooms(); //arrayList del corrente hotel presente nella lista
			
			ArrayList<Room> filteredRooms = new ArrayList<Room>(); //arrayList di stanze filtrate
			
			for (Room r : rr)
			{
				//devo aggiungere un controllo sulle varie cose che voglio filtrare! non voglio applicare obligatoriamente tutti i filtri!
				
				Room roomResult = new Room(r.getType(), r.getNum(), r.getPrice(), r.getTv(), r.getAir(), r.getFridge(), r.getInternet());
				
				if (price!=0)
				{
					if (!findMinusPrice(r, price)) roomResult = null;
				}
				
				if (largerprice!=0)
					if (!findLargerPrice(r, largerprice)) roomResult = null;
				
				if (checktv)
					if (!findTv(r)) roomResult = null;
				
				if (checkair)
					if (!findAir(r)) roomResult = null;
				
				if (checkfridge)
					if (!findFridge(r)) roomResult = null;
				
				if (checkinternet)
					if (!findInternet(r)) roomResult = null;
				
				if (roomResult!=null)
					filteredRooms.add(roomResult);
				
			} //end of for
			
			if (!filteredRooms.isEmpty())
			{
				hotelResult.setRooms(filteredRooms);
				results.addFirst(hotelResult);
			}
		}
		
		return results;
	}
	
	
	public boolean findMinusPrice(Room r, int p)
	{
		if (r.getPrice() <= p) return true;	
		
		return false;
	}
	
	public boolean findLargerPrice(Room r, int p)
	{
		if (r.getPrice()>= p) return true;
		return false;
	}
	
	public boolean findTv(Room r)
	{
		return r.getTv();
	}
	
	public boolean findAir(Room r)
	{
		return r.getAir();
	}
	
	public boolean findFridge(Room r)
	{
		return r.getFridge();
	}
	
	public boolean findInternet(Room r)
	{
		return r.getInternet();
	}
	
	
	
	//filtri di ricerca
	
	public List findPrice(int p)
	{
		List f = new List(); //lista per i risultati della ricerca
	 
		ListIterator li = l.listIterator();
		while (li.hasNext())
		{
			Hotel h = li.next();
			ArrayList<Room> rr = h.getRooms();
			boolean found = false;
			ArrayList<Room> alr = new ArrayList<Room>(); //arrayList per le stanze che corrispondono al criterio di ricerca
			for (Room r : rr)
			{
				if (r.getPrice() <= p)
				{
					found = true;
					alr.add(r);
				}
			}
			if (found)
			{
				Hotel hotelResult = new Hotel(h.getSerial(), h.getName(), h.getAddress(), h.getCity(), h.getCountry(), h.getPhone(), h.getFax());
				hotelResult.setRooms(alr);
				f.addFirst(hotelResult);
			}
		}
		
		return f;
	}
	
	
	
	public List findTv()
	{
		List f = new List(); //lista per i risultati della ricerca
		
		ListIterator li = l.listIterator();
		while (li.hasNext())
		{
			Hotel h = li.next();
			ArrayList<Room> rr = h.getRooms();
			boolean found = false;
			ArrayList<Room> res = new ArrayList<Room>(); //arrayList per le stanze che corrispondono al criterio di ricerca
			for (Room r : rr)
			{
				if (r.getTv()==true)
				{
					found = true;
					res.add(r);
				}
			}
			if (found)
			{
				Hotel hotelResult = new Hotel(h.getSerial(), h.getName(), h.getAddress(), h.getCity(), h.getCountry(), h.getPhone(), h.getFax());
				hotelResult.setRooms(res);
				f.addFirst(hotelResult);
			}
		}
		
		return f;
	}
	
	
	
	
	public List findAir()
	{
		List f = new List(); //lista per i risultati di ricerca
		
		
		ListIterator li = l.listIterator();
		
		while (li.hasNext())
		{
			Hotel h = li.next();
			ArrayList<Room> rr = h.getRooms();
			boolean found = false;
			ArrayList<Room> res = new ArrayList<Room>(); //arrayList per le stanze corrispondenti ai criteri di ricerca
			for (Room r : rr)
			{
				if (r.getAir() == true)
				{
					found = true;
					res.add(r);
				}
			}
			if (found)
			{
				Hotel hotelResult = new Hotel(h.getSerial(), h.getName(), h.getAddress(), h.getCity(), h.getCountry(), h.getPhone(), h.getFax());
				hotelResult.setRooms(res);
				f.addFirst(hotelResult);
			}
			
		}
		
		return f;
	}
	
	
	
	public List findFridge()
	{
		List f = new List();
		
		ListIterator li = l.listIterator();
		
		while (li.hasNext())
		{
			Hotel h = li.next();
			ArrayList<Room> rr = h.getRooms();
			boolean found = false;
			ArrayList<Room> res = new ArrayList<Room>(); //arrayList per le stanze che corrispondono ai criteri di ricerca
			for (Room r : rr)
			{
				if (r.getFridge())
				{
					found = true;
					res.add(r);
				}
			}
			if (found)
			{
				Hotel hotelResult = new Hotel(h.getSerial(), h.getName(), h.getAddress(), h.getCity(), h.getCountry(), h.getPhone(), h.getFax());
				hotelResult.setRooms(res);
				f.addFirst(hotelResult);
			}
		}
		
		return f;
	}
	
	
	
	
	public List findInternet()
	{
		List f = new List();
		
		ListIterator li = l.listIterator();
		
		while (li.hasNext())
		{
			Hotel h = li.next();
			ArrayList<Room> rr = h.getRooms();
			boolean found = false;
			ArrayList<Room> res = new ArrayList<Room>();
			for (Room r : rr)
			{
				if (r.getInternet())
				{
					found = true;
					res.add(r);
				}
			}
			if (found)
			{
				Hotel hotelResult = new Hotel(h.getSerial(), h.getName(), h.getAddress(), h.getCity(), h.getCountry(), h.getPhone(), h.getFax());
				hotelResult.setRooms(res);
				f.addFirst(hotelResult);
			}
		}
		
		return f;
	}
	
	
	
}
