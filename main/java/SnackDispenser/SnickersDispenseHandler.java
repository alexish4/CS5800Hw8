package SnackDispenser;

import StateOfVendingMachine.VendingMachine;

public class SnickersDispenseHandler extends SnackDispenseHandler{
    public SnickersDispenseHandler(SnackDispenseHandler next) {
        super(next);
    }

    @Override
    public void handleRequest(VendingMachine vendingMachine) {
        if(vendingMachine.getSnackSelected().getName().equals("Snickers")) {
            if(vendingMachine.getSnackSelected().getQuantity() == 0) {
                System.out.println("Out of Snickers");
            } else  {
                vendingMachine.getSnackSelected().setQuantity(vendingMachine.getSnackSelected().getQuantity() - 1);
                System.out.println("Snickers Dispensed\n");
            }

        } else {
            super.handleRequest(vendingMachine);
        }
    }
}
