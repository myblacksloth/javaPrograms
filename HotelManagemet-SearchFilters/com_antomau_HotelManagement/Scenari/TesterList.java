package com_antomau_HotelManagement.Scenari;

import com_antomau_HotelManagement.Classi.*;
import com_antomau_HotelManagement.Struct.List;

public class TesterList {
	
	public static List l;
	
	public static Room r, r2, r3, r4, r5;
	public static Hotel h, h2;
	
	public static void main(String[] args)
	{
		
		l = new List();
		
		
		
		r = new Room(1, 23, 56, true, true, true, true);
		r2 = new Room(2, 12, 46, true, true, true, false);
		
		h = new Hotel("testh", "hotel", "via del test, 123", "citta", "paese", "320320", "321321");
		
		h.addRoom(r);
		h.addRoom(r2);
		
		
		
		
		r3 = new Room(1, 22, 99, true, true, true, true);
		r4 = new Room(2, 33, 55, true, true, false, false);
		r5 = new Room(3, 44, 33, true, false, false, false);
		
		h2 = new Hotel ("hotelfxxk", "hotelKK", "via del pappagallo, 122", "roma", "italia", "320321", "320322");
		
		h2.addRoom(r3);
		h2.addRoom(r4);
		h2.addRoom(r5);
		
		
		l.addFirst(h);
		l.addLast(h2);
		
		
		
		l.print(System.out);
		
		
		
		
	}
}
