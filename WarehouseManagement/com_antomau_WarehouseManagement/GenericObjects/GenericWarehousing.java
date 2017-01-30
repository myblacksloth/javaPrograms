package com_antomau_WarehouseManagement.GenericObjects;

/**
 * Created by Anto on 30/01/17.
 */
public class GenericWarehousing {

    //variabili
    private String warehouseSerial, productSerial;

    /**
     * Class' builder
     * @param warehouseSerial Serial of warehouse where product is stored
     * @param productSerial Serial of product stored into the warehouse
     */
    public GenericWarehousing(String warehouseSerial, String productSerial)
    {
        this.warehouseSerial = warehouseSerial;
        this.productSerial = productSerial;
    }


    /**
     * @return the warehouse's serial code
     */
    public String getWarehouseSerial()
    {
        return this.warehouseSerial;
    }


    /**
     * @return the product's serial code
     */
    public String getProductSerial()
    {
        return this.productSerial;
    }

} //end of class
