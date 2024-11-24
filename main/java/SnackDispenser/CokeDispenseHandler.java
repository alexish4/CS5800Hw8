package SnackDispenser;

public class CokeDispenseHandler extends SnackDispenseHandler {
    public CokeDispenseHandler(SnackDispenseHandler next) {
        super(next);
    }

    @Override
    public void handleRequest(Snack snack) {
        if(snack.getName().equals("Coke")) {
            if(snack.getQuantity() > 1) {
                snack.setQuantity(snack.getQuantity() - 1);
            } else {
                System.out.println("Out of Coke");
            }

        } else {
            super.handleRequest(snack);
        }
    }
}
