package StateOfVendingMachine;

import SnackDispenser.Snack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachine {
    private double currentMoney;
    private StateOfVendingMachine stateOfVendingMachine = new IdleState();
    List<Snack> snacks;
    Snack snackSelected;

    public VendingMachine(double currentMoney, List<Snack> snacks) {
        this.currentMoney = currentMoney;
        this.snacks = snacks;
    }

    public double getCurrentMoney() {
        return currentMoney;
    }

    public void setCurrentMoney(double currentMoney) {
        this.currentMoney = currentMoney;
    }

    public StateOfVendingMachine getStateOfVendingMachine() {
        return stateOfVendingMachine;
    }

    public void setStateOfVendingMachine(StateOfVendingMachine stateOfVendingMachine) {
        this.stateOfVendingMachine = stateOfVendingMachine;
    }

    public void selectSnack(Snack snack) {
        snackSelected = snack;
        stateOfVendingMachine = new WaitingForMoneyState();
    }

    public void insertMoney(double moneyInserted) {
        currentMoney += moneyInserted;
        if (currentMoney < snackSelected.getPrice()) {
            System.out.println("Not enough money for selected snack please insert "
                    + (snackSelected.getPrice() - currentMoney) + " more money");
        } else {
            stateOfVendingMachine = new DispensingSnackState();
        }
    }

    public void dispenseSnack() {
        stateOfVendingMachine.dispenseSnack(snackSelected);
    }
}
