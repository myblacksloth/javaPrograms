package com_antomau_HotelManagement.Classi;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Hotel {	
	
	
	private String serial, name, address,city, country, phone, fax;
	
	private ArrayList<Room> a; //collezione di stanze all'interno dell'oggetto Hotel
	
	
	
	public Hotel(String serial, String name, String address, String city, String country, String phone, String fax) //costruttore
	{
		this.serial = serial;
		this.name = name;
		this.address = address;
		this.city = city;
		this.country = country;
		this.phone = phone;
		this.fax = fax;
		this.a = new ArrayList<Room>(); //inizializzazione dell'arrayList di stanze
	}
	
	public Hotel() //altro costruttore
	{
		this.a = new ArrayList<Room>(); //inizializzazione dell'arrayList di stanze
	}
	
	
	public void addRoom(Room r)
	{
		a.add(r);
	}
	
	public ArrayList<Room> getRooms()
	{
		return a;
	}
	
	public void setRooms(ArrayList<Room> a)
	{
		this.a = a;
	}
	
	
	public String getSerial()
	{
		return this.serial;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getAddress()
	{
		return this.address;
	}
	
	public String getCity()
	{
		return this.city;
	}
	
	public String getCountry()
	{
		return this.country;
	}
	
	public String getPhone()
	{
		return this.phone;
	}
	
	public String getFax()
	{
		return this.fax;
	}
	
	public void setSerial (String s)
	{
		this.serial = s;
	}
	
	public void setName (String s)
	{
		this.name = s;
	}
	
	public void setAddress (String s)
	{
		this.address = s;
	}
	
	public void setCity (String s)
	{
		this.city = s;
	}
	
	public void setCountry (String s)
	{
		this.country = s;
	}
	
	public void setPhone (String s)
	{
		this.phone = s;
	}
	
	public void setFax (String s)
	{
		this.fax = s;
	}
	
	public String toString()
	{
		String result="";
		result += "Hotel: [" + serial + ", " + name + ", " + address + ", " + city + ", " + country + ", " + phone + ", " + fax + "]";
		for (Room rr : a)
		{
			result += "\n\t" + rr.toString();
		}
		return result;
	}
	
	public Hotel read(Scanner sc)
	{
		assert sc.hasNext()==true;
		String serial = sc.nextLine().toUpperCase();
		
		assert sc.hasNext()==true;
		String name = sc.nextLine().toUpperCase();
		
		assert sc.hasNext()==true;
		String address = sc.nextLine().toUpperCase();
		
		assert sc.hasNext()==true;
		String city = sc.nextLine();
		
		assert sc.hasNext()==true;
		String country = sc.nextLine();
		
		assert sc.hasNext()==true;
		String phone = sc.nextLine();
		
		assert sc.hasNext()==true;
		String fax = sc.nextLine();
		
		return new Hotel(serial, name, address, city, country, phone, fax);
		
	}



	public Hotel copyWithoutRooms()
	{
		return new Hotel(serial, name, address, city, country, phone, fax);
	}
	
	
	public Hotel copy()
	{
		return this;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((fax == null) ? 0 : fax.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((serial == null) ? 0 : serial.hashCode());
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
		Hotel other = (Hotel) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (fax == null) {
			if (other.fax != null)
				return false;
		} else if (!fax.equals(other.fax))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (serial == null) {
			if (other.serial != null)
				return false;
		} else if (!serial.equals(other.serial))
			return false;
		return true;
	}
	
	
	public void print(PrintStream p)
	{
		p.println(serial);
		p.println(name);
		p.println(address);
		p.println(city);
		p.println(country);
		p.println(phone);
		p.println(fax);
	}
	
	
	
}
