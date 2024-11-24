package SnackDispenser;

public class PepsiDispenseHandler extends SnackDispenseHandler {
    public PepsiDispenseHandler(SnackDispenseHandler next) {
        super(next);
    }

    @Override
    public void handleRequest(Snack snack) {
        if(snack.getName().equals("Pepsi")) {
            if(snack.getQuantity() > 1) {
                snack.setQuantity(snack.getQuantity() - 1);
            } else {
                System.out.println("Out of Pepsi");
            }

        } else {
            super.handleRequest(snack);
        }
    }
}
