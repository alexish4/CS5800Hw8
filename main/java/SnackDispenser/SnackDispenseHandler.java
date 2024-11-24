package SnackDispenser;

public abstract class SnackDispenseHandler {
    private SnackDispenseHandler next;

    public SnackDispenseHandler(SnackDispenseHandler next) {
        this.next = next;
    }

    public void handleRequest(Snack snack) {
        if (next != null) {
            next.handleRequest(snack);
        }
    }
}
