package StateOfVendingMachine;

import SnackDispenser.Snack;

public class WaitingForMoneyState implements StateOfVendingMachine {
    @Override
    public void dispenseSnack(Snack snack) {
        System.out.println(snack.getName() + " is waiting for money");
    }
}
