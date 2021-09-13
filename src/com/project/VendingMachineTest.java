package com.project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VendingMachineTest {
    VendingMachine machine;
    Product product;

    @BeforeEach
    void setUp() {
        machine = new VendingMachine();
        product = new Product("fanta", 2.99, 5);
    }

    @Test
    @DisplayName("balance should be updated if coin is added")
    public void setBalanceGetBalanceTest() {
        machine.setBalance(50);
        assertEquals(50, machine.getBalance(), "adding coin should update the balance");
    }

    @Test
    @DisplayName("Reduce quantity should reduce the quantity of product")
    public void ReduceQuantityTest(){
        assertEquals(5, product.getQuantity(), "adding coin should update the balance");
        product.reduceQuantity();
        assertEquals(4, product.getQuantity(), "adding coin should update the balance");
    }

}
