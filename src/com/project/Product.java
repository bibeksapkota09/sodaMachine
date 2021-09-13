package com.project;

public class Product {
    private String name;
    private double price;
    private int quantity;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }


    Product(String name, double price, int quantity ){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    void updateQuantity(int quantity){
        this.quantity = quantity;
    }

    public boolean reduceQuantity(){
        //need to check if quantity == 0;
        if(this.quantity > 0){
            this.quantity -= 1;
            return true;
        }
        return false;

    }
}
