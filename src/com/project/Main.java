package com.project;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine();

        // initializing products
        Product p1 = new Product("coke", 1.99, 5);
        Product p2 = new Product("pepsi", 1.99, 6);
        Product p3 = new Product("fanta", 10.99, 1);
        Product p4 = new Product("water", 1.99, 5);

        // adding products to vending machine
        machine.addProduct(p1);
        machine.addProduct(p2);
        machine.addProduct(p3);
        machine.addProduct(p4);

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Soda Machine!\n");

        while (true) {
            int option = machine.showOptions();
            if (option == 1) {
                // add coin option
                System.out.println("******* Add coin *******");
                System.out.println("> $");
                double amount = Double.parseDouble(sc.nextLine());
                machine.setBalance(amount);

                System.out.println("> $ " + amount + " was inserted.");
                continue;
            } else if (option == 2) {
                // buy product option
                boolean buy = true;
                while (buy) {
                    machine.showProduct();
                    System.out.println("Select a product");

                    String selectedProd = sc.nextLine();
                    if (machine.containsProduct(selectedProd)) {
                        Product prod = machine.getProduct(selectedProd);
                        machine.buyProduct(prod);
                        System.out.println("buy something else? (y/n): ");
                        String ans = sc.nextLine();
                        if (ans.equalsIgnoreCase("n")) {
                            buy = false;
                        } else {
                            continue;
                        }
                    } else {
                        System.out.println("Item not available. Select another item.");
                        continue;
                    }
                }
            }
            else if (option == 3){
                System.out.println("> $" + machine.getBalance() + " dispensed.");
                System.out.println("> Thank you for stopping by!");
                break;
            }
            else if (option == 0) {
                System.out.println("> Thank you for stopping by!");
                break;
            }
            else{
                System.out.println("> Invalid option.\n\n");
            }
        }
    }
}
