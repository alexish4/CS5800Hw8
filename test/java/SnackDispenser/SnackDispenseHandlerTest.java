package SnackDispenser;

import StateOfVendingMachine.VendingMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SnackDispenseHandlerTest {
    private CheetosDispenseHandler handler;
    private SnackDispenseHandler nextHandler;
    private VendingMachine vendingMachine;
    private List<Snack> snacks;

    @BeforeEach
    void setUp() {
        nextHandler = new SnackDispenseHandler(null) {
            @Override
            public void handleRequest(VendingMachine vendingMachine) {
                System.out.println("Next handler called.");
            }
        };

        handler = new CheetosDispenseHandler(nextHandler);

        snacks = new ArrayList<>();
        snacks.add(new Snack("Cheetos", 1.50, 5));
        snacks.add(new Snack("Doritos", 1.50, 5));
        vendingMachine = new VendingMachine(0, snacks);
    }

    @Test
    void handleRequest() {
        vendingMachine.selectSnack(snacks.get(0));
        vendingMachine.insertMoney(2.00);

        handler.handleRequest(vendingMachine);

        Snack cheetos = vendingMachine.getSnackSelected();
        assertEquals(4, cheetos.getQuantity());
    }
}