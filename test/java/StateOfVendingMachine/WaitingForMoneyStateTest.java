package StateOfVendingMachine;

import SnackDispenser.Snack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WaitingForMoneyStateTest {
    private VendingMachine vendingMachine;

    @BeforeEach
    void setUp() {
        Snack coke = new Snack("Coke", 1.00, 10);
        vendingMachine = new VendingMachine(0.0, List.of(coke));
    }

    @Test
    void dispenseSnack() {
        vendingMachine.selectSnack(vendingMachine.getSnacks().get(0));
        vendingMachine.dispenseSnack();
        assertEquals(10, vendingMachine.getSnacks().get(0).getQuantity());
        assertEquals(0, vendingMachine.getCurrentMoney());
    }
}