package SnackDispenser;

public class CheetosDispenseHandler extends SnackDispenseHandler {
    public CheetosDispenseHandler(SnackDispenseHandler next) {
        super(next);
    }

    @Override
    public void handleRequest(Snack snack) {
        if(snack.getName().equals("Cheetos")) {
            if(snack.getQuantity() > 1) {
                snack.setQuantity(snack.getQuantity() - 1);
            } else {
                System.out.println("Out of cheetos");
            }

        } else {
            super.handleRequest(snack);
        }
    }
}
