package com_antomau_WarehouseManagement.CertainObjects;

/**
 * Created by Antonio Maulucci http://www.antomau.com on 30/01/17.
 */
public class CertainWarehouse {


    //variabili
    private int telephoneNumber, faxNumber;


    public CertainWarehouse(String serial, String address, String city, String country, int telephoneNumber, int faxNumber)
    {
        super(serial, address, city, country);

        this.telephoneNumber = telephoneNumber;
        this.faxNumber = faxNumber;

    }



    public int getTelephone()
    {
        return this.telephoneNumber;
    }



    public int getFax()
    {
        return this.faxNumber;
    }

} //end of class
