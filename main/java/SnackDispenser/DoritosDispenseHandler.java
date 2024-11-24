package SnackDispenser;

import StateOfVendingMachine.VendingMachine;

public class DoritosDispenseHandler extends SnackDispenseHandler {
    public DoritosDispenseHandler(SnackDispenseHandler next) {
        super(next);
    }

    @Override
    public void handleRequest(VendingMachine vendingMachine) {
        if(vendingMachine.getSnackSelected().getName().equals("Doritos")) {
            if(vendingMachine.getSnackSelected().getQuantity() == 0) {
                System.out.println("Out of Doritos");
            } else  {
                vendingMachine.getSnackSelected().setQuantity(vendingMachine.getSnackSelected().getQuantity() - 1);
                System.out.println("Doritos Dispensed\n");
            }

        } else {
            super.handleRequest(vendingMachine);
        }
    }
}
