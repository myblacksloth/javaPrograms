package com_antomau_WarehouseManagement.CertainObjects;

import com_antomau_WarehouseManagement.GenericObjects.GenericWarehouse;

/**
 * Created by Antonio Maulucci http://www.antomau.com on 30/01/17.
 */
public class Warehouse extends GenericWarehouse {


    //variabili
    private String telephoneNumber, faxNumber;


    public Warehouse(String serial, String address, String city, String country, String telephoneNumber, String faxNumber)
    {
        super(serial, address, city, country);

        this.telephoneNumber = telephoneNumber;
        this.faxNumber = faxNumber;

    }



    public String getTelephone()
    {
        return this.telephoneNumber;
    }



    public String getFax()
    {
        return this.faxNumber;
    }

} //end of class
