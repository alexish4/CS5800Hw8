package SnackDispenser;

import StateOfVendingMachine.VendingMachine;

public abstract class SnackDispenseHandler {
    private SnackDispenseHandler next;

    public SnackDispenseHandler(SnackDispenseHandler next) {
        this.next = next;
    }

    public void handleRequest(VendingMachine vendingMachine) {
        if (next != null) {
            next.handleRequest(vendingMachine);
        }
    }
}
