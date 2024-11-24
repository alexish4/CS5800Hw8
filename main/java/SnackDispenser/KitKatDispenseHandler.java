package SnackDispenser;

import StateOfVendingMachine.VendingMachine;

public class KitKatDispenseHandler extends SnackDispenseHandler {
    public KitKatDispenseHandler(SnackDispenseHandler next) {
        super(next);
    }

    @Override
    public void handleRequest(VendingMachine vendingMachine) {
        if(vendingMachine.getSnackSelected().getName().equals("KitKat")) {
            if(vendingMachine.getSnackSelected().getQuantity() == 0) {
                System.out.println("Out of KitKats");
            } else  {
                vendingMachine.getSnackSelected().setQuantity(vendingMachine.getSnackSelected().getQuantity() - 1);
                System.out.println("KitKat Dispensed\n");
            }

        } else {
            super.handleRequest(vendingMachine);
        }
    }
}
