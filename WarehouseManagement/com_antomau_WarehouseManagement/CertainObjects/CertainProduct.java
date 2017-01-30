package com_antomau_WarehouseManagement.CertainObjects;

import com_antomau_WarehouseManagement.GenericObjects.GenericProduct;

/**
 * Created by Antonio Maulucci http://www.antomau.com on 30/01/17.
 */
public class CertainProduct extends GenericProduct
{

    //variabili
    private String description;


    /**
     *
     * @param serial
     * @param description
     * @param amount
     */
    public CertainProduct(String serial, String description, int amount)
    {
        super(serial, amount);
        this.description = description;
    }

    /*
    it's unusual to override the getSerial() or getAmount() methods because they are in the superclass
     */

    public String getDescription()
    {
        return this.description;
    }

} //end of class
