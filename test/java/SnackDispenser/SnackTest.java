package SnackDispenser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SnackTest {
    private Snack snack;

    @BeforeEach
    void setUp() {
        snack = new Snack("Doritos", 2.50, 11);
    }

    @Test
    void setQuantity() {
        snack.setQuantity(5);
        assertEquals(5, snack.getQuantity());

        snack.setQuantity(0);
        assertEquals(0, snack.getQuantity());
    }
}