package SnackDispenser;

import StateOfVendingMachine.VendingMachine;

public class CheetosDispenseHandler extends SnackDispenseHandler {
    public CheetosDispenseHandler(SnackDispenseHandler next) {
        super(next);
    }

    @Override
    public void handleRequest(VendingMachine vendingMachine) {
        if(vendingMachine.getSnackSelected().getName().equals("Cheetos")) {
            if(vendingMachine.getSnackSelected().getQuantity() == 0) {
                System.out.println("Out of Cheetos");
            } else  {
                vendingMachine.getSnackSelected().setQuantity(vendingMachine.getSnackSelected().getQuantity() - 1);
                System.out.println("Cheetos Dispensed\n");
            }

        } else {
            super.handleRequest(vendingMachine);
        }
    }
}
