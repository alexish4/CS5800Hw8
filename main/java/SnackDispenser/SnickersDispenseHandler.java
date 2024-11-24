package SnackDispenser;

public class SnickersDispenseHandler extends SnackDispenseHandler{
    public SnickersDispenseHandler(SnackDispenseHandler next) {
        super(next);
    }

    @Override
    public void handleRequest(Snack snack) {
        if(snack.getName().equals("Snickers")) {
            if(snack.getQuantity() > 1) {
                snack.setQuantity(snack.getQuantity() - 1);
            } else {
                System.out.println("Out of Snickers");
            }

        } else {
            super.handleRequest(snack);
        }
    }
}
