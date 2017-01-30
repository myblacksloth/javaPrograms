package com_antomau_WarehouseManagement.GenericObjects;

/**
 * Created by Antonio Maulucci on 30/01/17.
 */
public class GenericWarehouse {

    //variabili
    String serial, address, city, country;

    /**
     * Class' builder
     * @param serial Serial number of warehouse
     * @param address Address of warehouse
     * @param city City of warehouse
     * @param country Country of warehouse
     */
    public GenericWarehouse(String serial, String address, String city, String country)
    {
        this.serial = serial;
        this.address = address;
        this.city = city;
        this.country = country;
    }




    public String getSerial()
    {
        return serial;
    }



    public String getAddress()
    {
        return address;
    }



    public String getCity()
    {
        return city;
    }


    public String getCountry()
    {
        return country;
    }



} //end of class
