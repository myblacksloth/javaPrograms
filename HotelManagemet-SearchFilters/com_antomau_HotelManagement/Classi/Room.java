package com_antomau_HotelManagement.Classi;

import java.io.PrintStream;
import java.util.Scanner;

public class Room {
	
	private int type, num, price;
	
	private boolean tv, air, fridge, internet;
	
	public Room(int type, int num, int price, boolean tv, boolean air, boolean fridge, boolean internet) //builder
	{
		this.type = type;
		this.num = num;
		this.price = price;
		this.tv = tv;
		this.air = air;
		this.fridge = fridge;
		this.internet = internet;
	}
	
	
	public Room() //secondo costruttore per la classe
	{
		
	}
	
	public int getType()
	{
		return this.type;
	}
	
	public int getNum()
	{
		return num;
	}
	
	public int getPrice()
	{
		return price;
	}
	
	public boolean getTv()
	{
		return tv;
	}
	
	public boolean getFridge() {
		return fridge;
	}
	
	public boolean getAir()
	{
		return air;
	}
	
	public boolean  getInternet()
	{
		return internet;
	}
	
	public void setType (int i)
	{
		this.type = i;
	}
	
	public void setNum (int i)
	{
		this.num = i;
	}
	
	public void setPrice (int i)
	{
		this.price = i;
	}
	
	public void setTv (boolean b)
	{
		this.tv = b;
	}
	
	public void setFridge (boolean b)
	{
		this.fridge = b;
	}
	
	public void setAir (boolean b)
	{
		this.air = b;
	}
	
	public void setInternet (boolean b)
	{
		this.internet = b;
	}
	
	
	//override by Object class
	@Override
	public String toString() {
		return "Room [type=" + type + ", num=" + num + ", price=" + price + ", tv=" + tv + ", air=" + air + ", fridge="
				+ fridge + ", internet=" + internet + "]";
	}
	
	public Room read(Scanner sc)
	{
		assert sc.hasNextLine()==true;
		int type = Integer.parseInt(sc.nextLine());
		
		assert sc.hasNextLine()==true;
		int num = Integer.parseInt(sc.nextLine());
		
		assert sc.hasNext()==true;
		int price = Integer.parseInt(sc.nextLine());
		
		assert sc.hasNext()==true;
		boolean tv=false;
		if (sc.nextLine().toUpperCase().equals("SI"))
			tv=true;
		
		assert sc.hasNext()==true;
		boolean fridge=false;
		if (sc.nextLine().toUpperCase().equals("SI"))
			fridge=true;
		
		assert sc.hasNext()==true;
		boolean air=false;
		if (sc.nextLine().toUpperCase().equals("SI"))
			air=true;
		
		assert sc.hasNext()==true;
		boolean internet=false;
		if (sc.nextLine().toUpperCase().equals("SI"))
			internet=true;
		
		return new Room(type, num, price, tv, fridge, air, internet);
	}
	
	//auto generated methods ... eclipse = source -> Generate hasCode()...
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (air ? 1231 : 1237);
		result = prime * result + (fridge ? 1231 : 1237);
		result = prime * result + (internet ? 1231 : 1237);
		result = prime * result + num;
		result = prime * result + price;
		result = prime * result + (tv ? 1231 : 1237);
		result = prime * result + type;
		return result;		
	}
		
		
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		if (air != other.air)
			return false;
		if (fridge != other.fridge)
			return false;
		if (internet != other.internet)
			return false;
		if (num != other.num)
			return false;
		if (price != other.price)
			return false;
		if (tv != other.tv)
			return false;
		if (type != other.type)
			return false;
		return true;
	}
	
	
	
	public void print(PrintStream p)
	{
		p.println(type);
		p.println(num);
		p.println(price);
		p.println(tv);
		p.println(fridge);
		p.println(air);
		p.println(internet);
	}
	
	
	
	
	
}
