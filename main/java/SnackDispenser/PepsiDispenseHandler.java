package SnackDispenser;

import StateOfVendingMachine.VendingMachine;

public class PepsiDispenseHandler extends SnackDispenseHandler {
    public PepsiDispenseHandler(SnackDispenseHandler next) {
        super(next);
    }

    @Override
    public void handleRequest(VendingMachine vendingMachine) {
        if(vendingMachine.getSnackSelected().getName().equals("Pepsi")) {
            if(vendingMachine.getSnackSelected().getQuantity() == 0) {
                System.out.println("Out of Pepsi");
            } else  {
                vendingMachine.getSnackSelected().setQuantity(vendingMachine.getSnackSelected().getQuantity() - 1);
                System.out.println("Pepsi Dispensed\n");
            }

        } else {
            super.handleRequest(vendingMachine);
        }
    }
}
