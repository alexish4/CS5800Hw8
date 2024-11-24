package SnackDispenser;

public class KitKatDispenseHandler extends SnackDispenseHandler {
    public KitKatDispenseHandler(SnackDispenseHandler next) {
        super(next);
    }

    @Override
    public void handleRequest(Snack snack) {
        if(snack.getName().equals("KitKat")) {
            if(snack.getQuantity() > 1) {
                snack.setQuantity(snack.getQuantity() - 1);
            } else {
                System.out.println("Out of Kit Kats");
            }

        } else {
            super.handleRequest(snack);
        }
    }
}
