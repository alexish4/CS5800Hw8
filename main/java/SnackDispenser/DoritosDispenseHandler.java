package SnackDispenser;

public class DoritosDispenseHandler extends SnackDispenseHandler {
    public DoritosDispenseHandler(SnackDispenseHandler next) {
        super(next);
    }

    @Override
    public void handleRequest(Snack snack) {
        if(snack.getName().equals("Doritos")) {
            if(snack.getQuantity() > 1) {
                snack.setQuantity(snack.getQuantity() - 1);
            } else {
                System.out.println("Out of Doritos");
            }

        } else {
            super.handleRequest(snack);
        }
    }
}
