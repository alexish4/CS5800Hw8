package StateOfVendingMachine;

import SnackDispenser.*;

public class DispensingSnackState implements StateOfVendingMachine{
    @Override
    public void dispenseSnack(Snack snack) {
        SnackDispenseHandler chain = new CokeDispenseHandler(new PepsiDispenseHandler
                (new CheetosDispenseHandler(new DoritosDispenseHandler(new KitKatDispenseHandler
                        (new SnickersDispenseHandler(null))))));

        chain.handleRequest(snack);
    }
}
