package com_antomau_HotelManagement.Scenari;

import com_antomau_HotelManagement.Classi.*;




public class TesterHotelRooms {
	
	public static Room r, r2;
	public static Hotel h;
	
	public static void main(String[] args)
	{
		
		r = new Room(1, 23, 56, true, true, true, true);
		r2 = new Room(2, 12, 46, true, true, true, false);
		
		h = new Hotel("testh", "hotel", "via del test, 123", "citta", "paese", "320320", "321321");
		
		h.addRoom(r);
		h.addRoom(r2);
		
		
		
		System.out.println(h.toString());
		
		
		for (Room rr : h.getRooms())
		{
			System.out.println(rr.toString());
		}
		
		
		
		
		
	}
}
