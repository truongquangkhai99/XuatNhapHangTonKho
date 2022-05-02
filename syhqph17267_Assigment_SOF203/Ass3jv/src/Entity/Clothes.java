/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.math.BigDecimal;

/**
 *
 * @author Admin
 */
public class Clothes {

    private int id;
    private int categoryId;
    private String productName;
    private String categoryName;
    private BigDecimal currentPrice;
    private int quantity;
    private String color;
    private String size;

    public Clothes() {
    }

    public Clothes(int id, int categoryId, String productName, BigDecimal currentPrice, int quantity, String color, String size) {
        this.id = id;
        this.categoryId = categoryId;
        this.productName = productName;
        this.currentPrice = currentPrice;
        this.quantity = quantity;
        this.color = color;
        this.size = size;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

}
