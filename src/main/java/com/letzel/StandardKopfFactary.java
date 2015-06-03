package com.letzel;

/**
 * Created by S on 02.06.2015.
 */
public class StandardKopfFactary implements RechnungsKopfFactory {

    private int letzteRechnungsId;

    public RechnungsKopf createKopf(Empfaenger empfaenger) {
        int rechnungsnr = nextNr();
        return new RechnungsKopf(System.currentTimeMillis(), rechnungsnr, empfaenger);
    }

    private int nextNr() {
        letzteRechnungsId++;
        return letzteRechnungsId;
    }
}
