package com.letzel;

/**
 * Created by S on 03.06.2015.
 */
public class EinfuegCommand implements Command {

    private final Addressbuch abuch;
    private final Empfaenger empfaenger;
    private final int id;

    public EinfuegCommand(int id, Addressbuch abuch, Empfaenger empfaenger) {
        this.abuch = abuch;
        this.empfaenger = empfaenger;
        this.id = id;
    }

    public void execute() {
        abuch.addEmpfaenger(id, empfaenger);
    }

    public void undo() {
        abuch.removeEmpfaenger(id);
    }
}
