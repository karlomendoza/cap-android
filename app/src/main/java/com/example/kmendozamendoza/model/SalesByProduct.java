package com.example.kmendozamendoza.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

/**
 * Created by k.mendoza.mendoza on 13/03/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SalesByProduct {
    private String productDescription;

    private Integer quantity;

    private Double sales;

    public SalesByProduct(){

    }

    public SalesByProduct(String productDescription, Integer quantity, Double sales) {
        this.productDescription = productDescription;
        this.quantity = quantity;
        this.sales = sales;
    }

    @Override
    public String toString() {
        return "SalesByProduct{" +
                "productDescription='" + productDescription + '\'' +
                ", quantity=" + quantity +
                ", sales=" + sales +
                '}';
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getSales() {
        return sales;
    }

    public void setSales(Double sales) {
        this.sales = sales;
    }
}
