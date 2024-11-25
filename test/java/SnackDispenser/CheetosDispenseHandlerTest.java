package SnackDispenser;

import StateOfVendingMachine.VendingMachine;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CheetosDispenseHandlerTest {
    private SnackDispenseHandler handler;
    private VendingMachine vendingMachine;
    private List<Snack> snacks;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        handler = new CokeDispenseHandler(new PepsiDispenseHandler
                (new CheetosDispenseHandler(new DoritosDispenseHandler(new KitKatDispenseHandler
                        (new SnickersDispenseHandler(null))))));

        snacks = new ArrayList<>();
        snacks.add(new Snack("Cheetos", 1.50, 5));
        snacks.add(new Snack("Doritos", 1.50, 5));
        vendingMachine = new VendingMachine(0, snacks);
    }

    @org.junit.jupiter.api.Test
    void handleRequest() {
        vendingMachine.selectSnack(snacks.get(0));
        vendingMachine.insertMoney(2.00);

        handler.handleRequest(vendingMachine);

        Snack cheetos = vendingMachine.getSnackSelected();
        assertEquals(4, cheetos.getQuantity());
    }

    @org.junit.jupiter.api.Test
    void handleRequest_outOfCheetos() {
        vendingMachine.selectSnack(snacks.get(0));
        vendingMachine.getSnackSelected().setQuantity(0);
        vendingMachine.insertMoney(2.00);

        handler.handleRequest(vendingMachine);

        Snack cheetos = vendingMachine.getSnackSelected();
        assertEquals(0, cheetos.getQuantity());
    }
}