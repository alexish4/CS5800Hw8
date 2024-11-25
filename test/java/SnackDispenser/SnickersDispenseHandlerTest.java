package SnackDispenser;

import StateOfVendingMachine.VendingMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SnickersDispenseHandlerTest {
    private SnackDispenseHandler handler;
    private VendingMachine vendingMachine;
    private List<Snack> snacks;

    @BeforeEach
    void setUp() {
        handler = new CokeDispenseHandler(new PepsiDispenseHandler
                (new CheetosDispenseHandler(new DoritosDispenseHandler(new KitKatDispenseHandler
                        (new SnickersDispenseHandler(null))))));

        snacks = new ArrayList<>();
        snacks.add(new Snack("KitKat", 1.50, 5));
        snacks.add(new Snack("Snickers", 1.50, 5));
        vendingMachine = new VendingMachine(0, snacks);
    }

    @Test
    void handleRequest() {
        vendingMachine.selectSnack(snacks.get(1));
        vendingMachine.insertMoney(2.00);

        handler.handleRequest(vendingMachine);

        Snack snickers = vendingMachine.getSnackSelected();
        assertEquals(4, snickers.getQuantity());
    }

    @Test
    void handleRequest_outOfCheetos() {
        vendingMachine.selectSnack(snacks.get(1));
        vendingMachine.getSnackSelected().setQuantity(0);
        vendingMachine.insertMoney(2.00);

        handler.handleRequest(vendingMachine);

        Snack snickers = vendingMachine.getSnackSelected();
        assertEquals(0, snickers.getQuantity());
    }
}