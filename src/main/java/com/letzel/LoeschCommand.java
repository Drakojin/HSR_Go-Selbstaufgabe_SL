package com.letzel;

/**
 * Created by S on 03.06.2015.
 */
public class LoeschCommand implements Command {

    private final Addressbuch abuch;
    private Empfaenger geloeschterempfaenger;
    private final int id;

    public LoeschCommand(int id, Addressbuch abuch) {
        this.abuch = abuch;
        this.id = id;
    }

    public void execute() {
      geloeschterempfaenger = abuch.removeEmpfaenger(id);
    }

    public void undo() {
        abuch.addEmpfaenger(id, geloeschterempfaenger);
    }
}
