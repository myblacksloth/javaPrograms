package com_antomau_WareHouseManagement.PublicInterface;

import javax.swing.*;
import java.util.Scanner;
import java.io.File;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




//classi del progetto
import com_antomau_WareHouseManagement.MyObjects.MyWareHousing;
import com_antomau_WareHouseManagement.MyObjects.MyWarehouse;
import com_antomau_WareHouseManagement.MyObjects.MyProduct;
import com_antomau_WareHouseManagement.MyObjects.MyMapManager;











public class Manager {
	
	
	//variabili
	private static Scanner inWareHouse, inProducts, inWarehousing;
	
	private static File file, fileProducts, fileWarehousing; //warehouse, products, warehousing files
	
	
	
	//oggetti del progetto
	private static MyWareHousing mwh;
	private static MyWarehouse mw;
	private static MyProduct mp;
	private static MyMapManager myMap = new MyMapManager();
	
	
	
	
	public static void main(String[] args)
	{
		
		JFrame f = new JFrame("Warehouse manager");
		f.setSize(300,300);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(new BorderLayout());
		
		
		
		//file chooser
		JFileChooser fc = new JFileChooser();
		
		
		//console
		JPanel console = new JPanel();
		console.setLayout(new GridLayout(1,2));
		
		
		
		
		//file manager
		JPanel fileManager = new JPanel();
		fileManager.setLayout(new GridLayout(3,2));
		
		JLabel f1l = new JLabel();
		JLabel f2l = new JLabel();
		JLabel f3l = new JLabel();
		
		JButton f1b = new JButton("Choose WareHouses file");
		JButton f2b = new JButton("Choose Products file");
		JButton f3b = new JButton("Choose Warehousing file");
		
		fileManager.add(f1l);
		fileManager.add(f1b);
		fileManager.add(f2l);
		fileManager.add(f2b);
		fileManager.add(f3l);
		fileManager.add(f3b);
		
		
		
		
		
		
		
		
		
		
		
		//menu
		JPanel menu = new JPanel();
		menu.setLayout(new GridLayout(4,1));
		
		JButton loadb = new JButton("Load data");
		JButton printb = new JButton("Print all data");
		JButton findb = new JButton("Find a product");
		JButton exitb = new JButton("Exit");
		
		
		menu.add(loadb);
		menu.add(printb);
		menu.add(findb);
		menu.add(exitb);
		
		
		
		
		
		
		
		
		
		console.add(fileManager);
		console.add(menu);
		
		
		
		
		
		
		
		JPanel contentPanel = new JPanel();
		
		
		
		
		
		
		
		
		f.add(console, BorderLayout.NORTH);
		f.add(contentPanel, BorderLayout.CENTER);
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		 * LISTENERS FOR BUTTONS
		 */
		
		
		class exitbListenerClass implements ActionListener
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		}
		ActionListener exitbListener = new exitbListenerClass();
		exitb.addActionListener(exitbListener);
		
		
		
		
		
		
		class f1bListenerClass implements ActionListener
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				fc.setDialogTitle("Open Warehouses database");
				fc.showOpenDialog(f); //show open dialog windows into frame f
				try {
					file = fc.getSelectedFile();
					inWareHouse = new Scanner(file);
					f1l.setText(file.getAbsolutePath());
				} catch(Exception exc) {
					exc.printStackTrace();
				}
				f.pack();
			}
		}
		ActionListener f1bListener = new f1bListenerClass();
		f1b.addActionListener(f1bListener);
		
		
		
		
		
		
		
		
		class f2bListenerClass implements ActionListener
		{
			@Override
			public void actionPerformed (ActionEvent e)
			{
				fc.setDialogTitle("Open products database");
				fc.showOpenDialog(f);
				try {
					fileProducts = fc.getSelectedFile();
					f2l.setText(fileProducts.getAbsolutePath());
				}catch (Exception exc) {
					exc.printStackTrace();
				}
				f.pack();
			}
		}
		f2b.addActionListener(new f2bListenerClass());
		
		
		
		
		
		
		
		class f3bListenerClass implements ActionListener
		{
			@Override
			public void actionPerformed (ActionEvent e)
			{
				fc.setDialogTitle("Open warehousing database");
				fc.showOpenDialog(f);
				try {
					fileWarehousing = fc.getSelectedFile();
					f3l.setText(fileWarehousing.getAbsolutePath());
				} catch(Exception exc) {
					exc.printStackTrace();
				}
				f.pack();
			}
		}
		ActionListener f3bListener = new f3bListenerClass();
		f3b.addActionListener(f3bListener);
		
		
		
		
		
		
		
		
		class loadbListenerClass implements ActionListener
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				try {
					
					
					
					
					
					while (inWareHouse.hasNextLine())
					{
						
						inProducts = new Scanner(fileProducts);
						
						mw = new MyWarehouse(inWareHouse.nextLine(), inWareHouse.nextLine(), inWareHouse.nextLine(), inWareHouse.nextLine(), inWareHouse.nextLine(), inWareHouse.nextLine());
						
						while (inProducts.hasNextLine())
						{
							
							mp = new MyProduct(inProducts.nextLine(), inProducts.nextLine(), Integer.parseInt(inProducts.nextLine()));
							
							inWarehousing = new Scanner(fileWarehousing);
							
							while (inWarehousing.hasNextLine())
							{
								
								mwh = new MyWareHousing(inWarehousing.nextLine(), inWarehousing.nextLine(), Integer.parseInt(inWarehousing.nextLine())); //nuovo oggetto del tipo MyWareHousing
								
								if (mw.getSerial().equals(mwh.getWSerial()) && mp.getSerial().equals(mwh.getPSerial()))
								{
									myMap.addToMap(mw, mp, mwh.getQt());
								} //end of if
								
								
							}
							
						}
						
						
					} //end of while
				} catch(Exception exc) {
					exc.printStackTrace();
				}
			}
		}
		ActionListener loadbListener = new loadbListenerClass();
		loadb.addActionListener(loadbListener);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		class printbListenerClass implements ActionListener
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				contentPanel.removeAll();
				myMap.getData();
				JLabel allDataLabel = new JLabel(myMap.toLabel());
				contentPanel.add(allDataLabel);
				f.pack();
			}
		}
		ActionListener printbListener = new printbListenerClass();
		printb.addActionListener(printbListener);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		class findbListenerClass implements ActionListener
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				
				contentPanel.removeAll();
				
				JPanel intPanel = new JPanel();
				intPanel.setLayout(new BorderLayout());
				
				JPanel findconsole = new JPanel();
				findconsole.setLayout(new GridLayout(1,2));
				
				JTextField jtf = new JTextField();
				JButton fb = new JButton("Find");
				
				findconsole.add(jtf); //1,1
				findconsole.add(fb);
				
				intPanel.add(findconsole, BorderLayout.NORTH);
				
				
				
				
				
				class fbListenerClass implements ActionListener
				{
					@Override
					public void actionPerformed (ActionEvent e)
					{
						JLabel findLabel = new JLabel( myMap.finder(jtf.getText().toUpperCase()));
						
						intPanel.add(findLabel, BorderLayout.CENTER);
						
						f.pack();
						
					}
				}
				fb.addActionListener(new fbListenerClass());
				
				
				
				
				contentPanel.add(intPanel);
				
				f.pack();
				
				
			}
		}
		ActionListener findbListener = new findbListenerClass();
		findb.addActionListener(findbListener);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		f.pack();
		
		
	}

}
