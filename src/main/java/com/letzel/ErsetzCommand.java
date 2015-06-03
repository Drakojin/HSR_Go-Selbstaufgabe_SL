package com.letzel;

/**
 * Created by S on 03.06.2015.
 */
public class ErsetzCommand implements Command{

    private final Addressbuch abuch;
    private Empfaenger empfaengerold;
    private final Empfaenger empfaengernew;
    private final int id;

    public ErsetzCommand(int id, Addressbuch abuch, Empfaenger empfaenger) {
        this.abuch = abuch;
        empfaengernew = empfaenger;
        this.id = id;
    }

    public void execute() {
        empfaengerold = abuch.removeEmpfaenger(id);
        abuch.addEmpfaenger(id, empfaengernew);
    }

    public void undo() {
        abuch.removeEmpfaenger(id);
        abuch.addEmpfaenger(id, empfaengerold);
    }
}
