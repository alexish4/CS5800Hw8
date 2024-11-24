package StateOfVendingMachine;

import SnackDispenser.*;

public class DispensingSnackState implements StateOfVendingMachine{
    @Override
    public void dispenseSnack(VendingMachine vendingMachine) {
        SnackDispenseHandler chain = new CokeDispenseHandler(new PepsiDispenseHandler
                (new CheetosDispenseHandler(new DoritosDispenseHandler(new KitKatDispenseHandler
                        (new SnickersDispenseHandler(null))))));
        double change = vendingMachine.getCurrentMoney() - vendingMachine.getSnackSelected().getPrice();

        System.out.print("Dispensing State: ");

        if (change > 0) {
            System.out.println("Returning change: " + change);
            vendingMachine.setCurrentMoney(0.0);
        }

        chain.handleRequest(vendingMachine);
    }
}
