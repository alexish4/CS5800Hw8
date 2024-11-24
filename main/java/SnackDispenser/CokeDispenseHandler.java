package SnackDispenser;

import StateOfVendingMachine.VendingMachine;

public class CokeDispenseHandler extends SnackDispenseHandler {
    public CokeDispenseHandler(SnackDispenseHandler next) {
        super(next);
    }

    @Override
    public void handleRequest(VendingMachine vendingMachine) {
        if(vendingMachine.getSnackSelected().getName().equals("Coke")) {
            if(vendingMachine.getSnackSelected().getQuantity() == 0) {
                System.out.println("Out of Coke");
            } else  {
                vendingMachine.getSnackSelected().setQuantity(vendingMachine.getSnackSelected().getQuantity() - 1);
                System.out.println("Coke Dispensed\n");
            }

        } else {
            super.handleRequest(vendingMachine);
        }
    }
}
