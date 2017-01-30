package com_antomau_WarehouseManagement.CertainObjects;

import com_antomau_WarehouseManagement.GenericObjects.GenericWarehousing;

/**
 * Created by Antonio Maulucci http://www.antomau.com on 30/01/17.
 */
public class Warehousing extends GenericWarehousing {


    //variabili
    int amount;


    /**
     * Class' builder
     * @param warehouseSerial Serial of warehouse where product is stored
     * @param productSerial Serial of product stored into the warehouse
     * @param amount Amount of product stored into the warehouse
     */
    public Warehousing(String warehouseSerial, String productSerial, int amount)
    {

        super (warehouseSerial, productSerial);

        this.amount = amount;

    }

    /**
     * @return the amount of prodcuts
     */
    public int getAmount()
    {
        return this.amount;
    }


} //end of class
