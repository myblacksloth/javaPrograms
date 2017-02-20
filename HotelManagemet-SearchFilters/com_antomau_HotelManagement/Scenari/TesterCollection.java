package com_antomau_HotelManagement.Scenari;

import java.io.*;

import com_antomau_HotelManagement.Classi.Collection;
import com_antomau_HotelManagement.Classi.Hotel;
import com_antomau_HotelManagement.Classi.Room;

public class TesterCollection {
	
	public static File hotels = new File("alberghi.dat");
	public static File rooms = new File("stanze.dat");
	
	public static void main(String[] args) throws FileNotFoundException
	{
		
		
		Collection c = new Collection(hotels, rooms);
		
		
		Room r = new Room(1, 23, 56, true, true, true, true);
		Room r2 = new Room(2, 12, 46, true, true, true, false);
		Hotel h = new Hotel("testh", "hotel", "via del test, 123", "citta", "paese", "320320", "321321");
		h.addRoom(r);
		h.addRoom(r2);
		
		Room r3 = new Room(1, 22, 99, true, true, true, true);
		Room r4 = new Room(2, 33, 55, true, false, false, false);
		Room r5 = new Room(3, 44, 33, false, false, false, false);
		Hotel h2 = new Hotel ("hotelfxxk", "hotelKK", "via del pappagallo, 122", "roma", "italia", "320321", "320322");
		h2.addRoom(r3);
		h2.addRoom(r4);
		h2.addRoom(r5);
		
		c.add(h);
		c.add(h2);
		c.print(System.out);
		
		int pricefilter = 54;
		System.out.println("Find by price " + pricefilter +":");
		c.findPrice(pricefilter).print(System.out);
		
		System.out.println("Find by tv:");
		c.findTv().print(System.out);
		
		System.out.println("Find by air:");
		c.findAir().print(System.out);
		
		System.out.println("Find by fridge:");
		c.findFridge().print(System.out);
		
		System.out.println("Find by internet:");
		c.findInternet().print(System.out);
		
		System.out.printf("\n\n\n\nRicerca:::");
		
		int findprice = 85;
		System.out.println("\n\nFind by price minus then " + findprice +" euros, tv and fridge:");
		System.out.println(c.roomFilter(findprice, 0, true, false, true, false).toString());
		
		System.out.println("\n\nFind by price < 40:");
		System.out.println(c.roomFilter(40, 0, false, false, false, false).toString());
		
		System.out.println("\n\nFind by price between 40 and 90:");
		System.out.println(c.roomFilter(90, 40, false, false, false, false).toString());
		
		System.out.println("\n\nFind by tv and internet:");
		System.out.println(c.roomFilter(0, 0, true, false, false, true).toString());
		
		System.out.println("\n\nFind by price < 50 with airConditioner:");
		System.out.println(c.roomFilter(50, 0, false, true, false, false).toString());
		
		
	}
	
	
}
