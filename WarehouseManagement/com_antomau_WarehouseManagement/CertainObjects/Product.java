package com_antomau_WarehouseManagement.CertainObjects;

import com_antomau_WarehouseManagement.GenericObjects.GenericProduct;

/**
 * Created by Antonio Maulucci http://www.antomau.com on 30/01/17.
 */
public class Product extends GenericProduct
{

    //variabili
    private String description;


    /**
     * Class' builder
     * @param serial Product's serial code
     * @param description Produt's description
     * @param price Product's price
     */
    public Product(String serial, String description, int price)
    {
        super(serial, price);
        this.description = description;
    }

    /*
    it's unusual to override the getSerial() or getAmount() methods because they are in the superclass
     */

    public String getDescription()
    {
        return description;
    }

} //end of class
