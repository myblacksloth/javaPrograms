package com_antomau_HotelManagement.Scenari;

import java.io.*;
import java.util.Scanner;


public class HotelManagement {
	
	
	public static Scanner inH, inR;
	
	
	public static void main(String[] args)
	{
		
		
		
		System.out.println("Hi!");
		
		
		/*
		 * eclipse args
		 * run / run configurations / set main class  / arguments / set param arguments...
		 */
		
		try
		{
			//inH = new Scanner(new File("alberghi.dat"));
			inH = new Scanner(new File(args[0]));
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		
		
		
		try
		{
			//inR = new Scanner(new File("stanze.dat"));
			inR = new Scanner(new File(args[1]));
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
	}
	
	
	
}
