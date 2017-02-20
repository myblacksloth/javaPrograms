package com_antomau_HotelManagement.Struct;

import com_antomau_HotelManagement.Classi.Hotel;

public interface ListIterator {
	
	
	Hotel next();
	
	boolean hasNext();
	
	void add(Hotel h);
	
	void remove(Hotel h);
	
	void set (Hotel h);
	
	void reset(); //to reset the iterator
	
	
}
