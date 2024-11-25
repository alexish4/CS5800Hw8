package SnackDispenser;

import StateOfVendingMachine.VendingMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CokeDispenseHandlerTest {
    private SnackDispenseHandler handler;
    private VendingMachine vendingMachine;
    private List<Snack> snacks;

    @BeforeEach
    void setUp() {
        handler = new CokeDispenseHandler(new PepsiDispenseHandler
                (new CheetosDispenseHandler(new DoritosDispenseHandler(new KitKatDispenseHandler
                        (new SnickersDispenseHandler(null))))));

        snacks = new ArrayList<>();
        snacks.add(new Snack("Cheetos", 1.50, 5));
        snacks.add(new Snack("Coke", 1.00, 3));
        vendingMachine = new VendingMachine(0, snacks);
    }

    @Test
    void handleRequest() {
        vendingMachine.selectSnack(snacks.get(1));
        vendingMachine.insertMoney(2.00);

        handler.handleRequest(vendingMachine);

        Snack coke = vendingMachine.getSnackSelected();
        assertEquals(2, coke.getQuantity());
    }

    @Test
    void handleRequest_outOfCoke() {
        vendingMachine.selectSnack(snacks.get(1));
        vendingMachine.getSnackSelected().setQuantity(0);
        vendingMachine.insertMoney(2.00);

        handler.handleRequest(vendingMachine);

        Snack coke = vendingMachine.getSnackSelected();
        assertEquals(0, coke.getQuantity());
    }
}