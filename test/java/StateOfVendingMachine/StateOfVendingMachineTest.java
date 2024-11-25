package StateOfVendingMachine;

import SnackDispenser.Snack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StateOfVendingMachineTest {
    private VendingMachine vendingMachine;

    @BeforeEach
    void setUp() {
        Snack coke = new Snack("Coke", 1.50, 5);
        Snack pepsi = new Snack("Pepsi", 1.50, 5);
        vendingMachine = new VendingMachine(0, List.of(coke, pepsi));
    }

    @Test
    void dispenseSnack() {
        vendingMachine.dispenseSnack();
        assertEquals(0, vendingMachine.getCurrentMoney());

        vendingMachine.selectSnack(vendingMachine.getSnacks().get(0));

        vendingMachine.insertMoney(1.50);
        assertEquals(1.50, vendingMachine.getCurrentMoney());

        vendingMachine.dispenseSnack();
        assertEquals(4, vendingMachine.getSnacks().get(0).getQuantity());
    }
}