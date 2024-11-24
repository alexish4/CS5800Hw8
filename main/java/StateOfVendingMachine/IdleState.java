package StateOfVendingMachine;

import SnackDispenser.Snack;

public class IdleState implements StateOfVendingMachine{
    @Override
    public void dispenseSnack(Snack scack) {
        System.out.println("Select Snack and Insert Money");
    }
}
