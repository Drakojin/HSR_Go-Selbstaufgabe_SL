package com.letzel;

/**
 * Created by S on 02.06.2015.
 */
public class BackdateFactory implements RechnungsKopfFactory {
    private int letzteRechnungsId;

    public RechnungsKopf createKopf(Empfaenger empfaenger) {
        int rechnungsnr = nextNr();
        return new RechnungsKopf(createDatum(), rechnungsnr, empfaenger);
    }

    private long createDatum() {
        return System.currentTimeMillis() - 10 * 24 * 60 * 60 * 1000;
    }

    private int nextNr() {
        letzteRechnungsId++;
        return letzteRechnungsId;
    }
}
