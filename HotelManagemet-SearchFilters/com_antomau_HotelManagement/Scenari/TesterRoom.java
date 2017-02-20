package com_antomau_HotelManagement.Scenari;

import com_antomau_HotelManagement.Classi.Room;

public class TesterRoom {
	
	public static Room r;
	
	public static void main(String[] args)
	{
		r = new Room(1, 23, 56, true, true, true, true);
		
		System.out.println(r.getType());
		System.out.println(r.getNum());
		System.out.println(r.getPrice());
		System.out.println(r.getTv());
		System.out.println(r.getFridge());
		System.out.println(r.getAir());
		System.out.println(r.getInternet());
		System.out.println(r.toString());
		System.out.println("hasCode: " + r.hashCode());
		r.print(System.out );
		
	}

}
