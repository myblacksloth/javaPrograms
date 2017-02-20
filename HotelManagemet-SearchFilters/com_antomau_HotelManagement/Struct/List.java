package com_antomau_HotelManagement.Struct;




import java.util.NoSuchElementException;
import java.io.*;

import com_antomau_HotelManagement.Classi.Hotel;



public class List {
	
	
	
	
	class Node
	{
		public Hotel h;
		public Node link;
	}
	
	//variabile headlist
	public Node headList;
	
	
	//builder
	public List()
	{
		headList = null;
	}
	
	
	
	
	public Hotel getFirst()
	{
		if (!(headList==null)) //trick ;)
			return headList.h;
		
		return null;
	}
	
	
	
	
	public Hotel removeFirst()
	{
		if (!(headList==null))
		{
			Hotel hr = headList.h;
			headList = headList.link;
			return hr;
		}
		return null;
	}
	
	
	
	
	
	public void addFirst(Hotel h)
	{
		
		Node newNode = new Node();
		newNode.h = h;
		
		newNode.link = headList;
		
		headList = newNode;
	}
	
	
	
	
	
	
	public void addLast(Hotel h)
	{
		if (headList==null) addFirst(h);
		else
		{
			Node newNode = new Node();
			newNode.h = h;
			newNode.link = null;
			Node cur = headList;
			while (cur.link!=null)
			{
				cur = cur.link;
			}
			cur.link = newNode;
		}
	}
	
	
	
	
	
	
	public Hotel removeLast()
	{
		Hotel rh=null; //oggetto da restituire
		if (headList==null) throw new NoSuchElementException();
		else if (headList.link == null) rh = removeFirst(); //il metodo chiama il metodo per la rimozione del nodo in testa e il valore da questo restituito viene impostato come argomento della variabile di ritorno
		else {
			Node cur = headList;
			Node previous = null;
			while (cur.link != null)
			{
				previous = cur;
				cur = cur.link;
			}
			rh = cur.h;
			previous.link = null; //rimozione di ogni riferimento al nodo
		}
		return rh;
	}
	
	
	
	
	
	public String toString()
	{
		
		if (headList==null) return null;
		
		String result="";
		Node cur = headList;
		while (cur!=null)
		{
			result += cur.h.toString() + "\n";
			cur = cur.link;
		}
		return result;
	}
	
	
	
	
	public void print(PrintStream p)
	{
		p.println(toString());
	}
	
	
	public boolean isEmpty()
	{
		return headList==null;
	}
	
	
	
	
	
	
	private class Iterator implements ListIterator
	{
		
		Node current;
		Node previous;
		
		public Iterator()
		{
			current = null;
			previous = null;
		}
		
		
		
		@Override
		public Hotel next() {
			
			previous = current;
			
			if (!hasNext()) throw new NoSuchElementException();
			if (current == null) current = headList;
			else current = current.link;
			
			return current.h;
		}
		
		@Override
		public boolean hasNext() {
			if (current==null) return headList != null;
			else return current.link != null;
		}
		
		@Override
		public void add(Hotel h) {
			
			if (current==null)
			{
				addFirst(h);
				current = headList;
			}
			else
			{
				Node newNode = new Node();
				newNode.h = h;
				newNode.link = current.link;
			}
			previous = current;
		}
		
		@Override
		public void remove(Hotel h) {
			
			if (previous==current) throw new IllegalStateException();
			else if (current == headList) removeFirst();
			else previous.link = current.link;
			current = previous; //to unable deletion after a deletion 
			
		}
		
		@Override
		public void set(Hotel h) {
			
			if (current == null) throw new NoSuchElementException();
			current.h = h;
		}
		
		@Override
		public void reset() {
			current = null;
			previous = null;
		}
		
	}
	
	
	
	public Iterator listIterator()
	{
		return new Iterator();
	}
	
	
	
	
}
