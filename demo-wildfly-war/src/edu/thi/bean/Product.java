package edu.thi.bean;


public class Product {

    private String productId;
    private String productName;
    private int quantity;
    private String supplier;

    // Standardkonstruktor
    public Product() {
    }

    // Getter und Setter für productId
    public String getProductId() {
        return productId;
    }

    public void set(String productId) {
        this.productId = productId;
    }

    // Getter und Setter für productName
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    // Getter und Setter für quantity
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    // Getter und Setter für supplier
    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
}