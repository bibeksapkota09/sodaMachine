package com.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachine {
    private  double balance;
    private List<Product> products = new ArrayList<Product>();

    // to add product to product list
    public void addProduct(Product product){
        this.products.add(product);
    }

    // display all available products
    public void showProduct(){
        for(int i = 0; i < products.size(); i++){
            System.out.println("Item: " + products.get(i).getName() + ", Price: " + products.get(i).getPrice());
        }
    }

    public double getBalance(){
        return this.balance;
    }

    public void setBalance(double amount){
        if (amount <= 0) {
            throw new IllegalArgumentException("Only positive numbers are allowed!");
        }
        this.balance += amount;
    }

    // purchase product logic
    public  void buyProduct(Product product){
        if(this.balance < product.getPrice()){
            System.out.println("Insufficient balance...");
        }
        else if(product.getQuantity()  <  1){
            System.out.println( product.getName() + " is Out of stock");
        }
        else {
            this.balance -= product.getPrice();
            product.reduceQuantity();
            System.out.println("Enjoy your : " + product.getName());
            System.out.println("Your remaining balance : " + this.balance);
        }
    }

    // check for product in product list
    public boolean containsProduct(String name){
        for(int i = 0; i < products.size(); i++){
            if((products.get(i).getName()).equalsIgnoreCase(name)){
                return true;
            }
        }
        return false;
    }

    public Product getProduct(String name){
        for (int i = 0; i < products.size(); i++){
            if((products.get(i).getName()).equalsIgnoreCase(name)){
                return products.get(i);
            }
        }
        return null;
    }

    // to display regular option choices
    public int showOptions(){
        Scanner sc = new Scanner(System.in);
        System.out.println("> Your total balance: " + getBalance());
        System.out.println("\n> What would you like to do? ");
        System.out.println("> Press 1 to insert coin. ");
        System.out.println("> Press 2 to buy products.");
        System.out.println("> Press 3 to return remaining change.");
        System.out.println("> Press 0 to exit.\n");
        System.out.println("> ");
        int amount =  Integer.parseInt(sc.nextLine());
        return amount;
    }

}
