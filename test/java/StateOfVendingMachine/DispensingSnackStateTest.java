package StateOfVendingMachine;

import SnackDispenser.Snack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DispensingSnackStateTest {
    private VendingMachine vendingMachine;

    @BeforeEach
    void setUp() {
        Snack coke = new Snack("Coke", 1.50, 5);
        Snack chips = new Snack("Cheetos", 2.00, 3);
        vendingMachine = new VendingMachine(0, List.of(coke, chips));
    }

    @Test
    void dispenseSnack() {
        vendingMachine.selectSnack(vendingMachine.getSnacks().get(0)); // Select "Coke"
        vendingMachine.insertMoney(2.00); // Insert sufficient money for "Coke"
        vendingMachine.dispenseSnack();

        assertEquals(4, vendingMachine.getSnacks().get(0).getQuantity());
        assertEquals(0.0, vendingMachine.getCurrentMoney());

        double expectedChange = 2.00 - 1.50;
        assertEquals(expectedChange, 0.50);
    }
}