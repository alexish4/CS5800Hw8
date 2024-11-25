package StateOfVendingMachine;

import SnackDispenser.Snack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VendingMachineTest {
    private VendingMachine vendingMachine;

    @BeforeEach
    void setUp() {
        Snack coke = new Snack("Coke", 1.00, 1);
        Snack pepsi = new Snack("Pepsi", 1.00, 1);
        vendingMachine = new VendingMachine(0.0, List.of(coke, pepsi));
    }

    @Test
    void setCurrentMoney() {
        vendingMachine.setCurrentMoney(5.00);
        assertEquals(5.00, vendingMachine.getCurrentMoney());
    }

    @Test
    void selectSnack() {
        Snack snackToSelect = vendingMachine.getSnacks().get(0);
        vendingMachine.selectSnack(snackToSelect);

        assertEquals(snackToSelect, vendingMachine.getSnackSelected());
        assertInstanceOf(WaitingForMoneyState.class, vendingMachine.getStateOfVendingMachine());
    }

    @Test
    void insertMoney() {
        Snack snackToSelect = vendingMachine.getSnacks().get(1);
        vendingMachine.selectSnack(snackToSelect);

        vendingMachine.insertMoney(1.00);
        assertEquals(1.00, vendingMachine.getCurrentMoney());
        assertInstanceOf(DispensingSnackState.class, vendingMachine.getStateOfVendingMachine());

        vendingMachine.insertMoney(1.00);
        assertEquals(2.00, vendingMachine.getCurrentMoney());
        assertInstanceOf(DispensingSnackState.class, vendingMachine.getStateOfVendingMachine());
    }

    @Test
    void dispenseSnack() {
        Snack snackToSelect = vendingMachine.getSnacks().get(0);
        vendingMachine.selectSnack(snackToSelect);
        vendingMachine.insertMoney(1.50);

        vendingMachine.dispenseSnack();

        assertEquals(0, snackToSelect.getQuantity());
        assertEquals(0, vendingMachine.getCurrentMoney());
        assertInstanceOf(DispensingSnackState.class, vendingMachine.getStateOfVendingMachine());
    }
}