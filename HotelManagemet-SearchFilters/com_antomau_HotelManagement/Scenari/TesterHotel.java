package com_antomau_HotelManagement.Scenari;

import com_antomau_HotelManagement.Classi.Hotel;

public class TesterHotel {
	
	private static Hotel h;
	
	public static void main(String[] args)
	{
		
		h = new Hotel("test", "prova", "via dei ciclamini", "roma", "italia", "320320", "321321");
		
		System.out.println(h.getSerial());
		System.out.println(h.getName());
		System.out.println(h.getAddress());
		System.out.println(h.getCity());
		System.out.println(h.getCountry());
		System.out.println(h.getPhone());
		System.out.println(h.getFax());
		System.out.println(h.toString());
		System.out.println("hashCode: " + h.hashCode());
		h.print(System.out);
		
	}

}
