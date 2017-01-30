package com_antomau_WarehouseManagement.GenericObjects;

/**
 * Created by Antonio Maulucci on 30/01/17.
 */
public class GenericProduct {

    //variabili
    public String serial;
    public int price;

    /**
     * Class' builder
     * @param serial Product's serial code
     * @param price Product's price
     */
    public GenericProduct(String serial, int price)
    {
        this.serial = serial;
        this.price = price;
    }

    public String getSerial()
    {
        return serial;
    }


    public int getPrice()
    {
        return price;
    }


} //end of class