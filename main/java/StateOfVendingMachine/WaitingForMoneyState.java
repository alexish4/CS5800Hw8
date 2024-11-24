package StateOfVendingMachine;

import SnackDispenser.Snack;

public class WaitingForMoneyState implements StateOfVendingMachine {
    @Override
    public void dispenseSnack(VendingMachine vendingMachine) {
        System.out.println("Waiting For Money State: " + vendingMachine.getSnackSelected().getName() + " is waiting for money\n");
    }
}
