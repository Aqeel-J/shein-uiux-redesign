package com.shein.sheinapplication.classes;

public class Product {
    String productName;
    int productImg;
    double productPrice;
    double productDiscount;

    public Product(String productName, int productImg, double productPrice, double productDiscount) {
        this.productName = productName;
        this.productImg = productImg;
        this.productPrice = productPrice;
        this.productDiscount = productDiscount;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductImg() {
        return productImg;
    }

    public void setProductImg(int productImg) {
        this.productImg = productImg;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public double getProductDiscount() {
        return productDiscount;
    }

    public void setProductDiscount(double productDiscount) {
        this.productDiscount = productDiscount;
    }
}
