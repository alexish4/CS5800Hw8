import SnackDispenser.Snack;
import StateOfVendingMachine.VendingMachine;

import java.util.ArrayList;
import java.util.List;

public class VendingMachineDriver {
    public static void main(String[] args) {
        vendingMachineDriver();
    }

    public static void vendingMachineDriver() {
        Snack cheetos = new Snack("Cheetos", 2.50, 5);
        Snack coke = new Snack("Coke", 2.00, 4);
        Snack pepsi = new Snack("Pepsi", 2.00, 9);
        Snack doritos = new Snack("Doritos", 2.50, 4);
        Snack kitkat = new Snack("KitKat", 2.75, 6);
        Snack snickers = new Snack("Snickers", 2.00, 5);

        List<Snack> snacks = new ArrayList<Snack>();
        snacks.add(cheetos);
        snacks.add(coke);
        snacks.add(pepsi);
        snacks.add(doritos);
        snacks.add(kitkat);
        snacks.add(snickers);

        VendingMachine vendingMachine = new VendingMachine(0.0, snacks);
        vendingMachine.dispenseSnack();

        vendingMachine.selectSnack(cheetos);
        vendingMachine.dispenseSnack();

        vendingMachine.insertMoney(2.00);
        vendingMachine.dispenseSnack();

        vendingMachine.insertMoney(0.50);
        vendingMachine.dispenseSnack();
    }
}
