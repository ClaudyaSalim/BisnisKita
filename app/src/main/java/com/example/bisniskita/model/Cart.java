package com.example.bisniskita.model;

public class Cart {

    private Item product;
    private String namaToko;
    private int quantity;
    private int finalPrice;

    public Cart(Item product, String namaToko, int quantity, int finalPrice) {
        this.product = product;
        this.namaToko = namaToko;
        this.quantity = quantity;
        this.finalPrice = finalPrice;
    }

    public Item getProduct() {
        return product;
    }

    public void setProduct(Item product) {
        this.product = product;
    }

    public String getNamaToko() {
        return namaToko;
    }

    public void setNamaToko(String namaToko) {
        this.namaToko = namaToko;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(int finalPrice) {
        this.finalPrice = finalPrice;
    }
}
