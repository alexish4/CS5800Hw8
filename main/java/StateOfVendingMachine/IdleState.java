package StateOfVendingMachine;

import SnackDispenser.Snack;

public class IdleState implements StateOfVendingMachine{
    @Override
    public void dispenseSnack(VendingMachine vendingMachine) {
        System.out.println("Idle State: Select Snack and Insert Money\n");
    }
}
