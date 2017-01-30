package com_antomau_WarehouseManagement.GenericObjects;

/**
 * Created by Antonio Maulucci on 30/01/17.
 */
public class GenericProduct {

    //variabili
    String serial;
    int amount;

    public GenericProduct(String serial, int amount)
    {
        this.serial = serial;
        this.amount = amount;
    }

    public String getSerial()
    {
        return this.serial;
    }


} //end of class