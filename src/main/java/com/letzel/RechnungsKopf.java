package com.letzel;

/**
 * Created by S on 02.06.2015.
 */
public class RechnungsKopf {

    private final long datum;
    private final int rechnungsnr;
    private final Empfaenger empfaenger;

    public RechnungsKopf(long datum, int rechnungsnr, Empfaenger empfaenger) {
        this.datum = datum;
        this.rechnungsnr = rechnungsnr;
        this.empfaenger = empfaenger;
    }

    public long getDatum() {
        return datum;
    }

    public int getRechnungsnr() {

        return rechnungsnr;
    }

    public Empfaenger getEmpfaenger() {
        return empfaenger;
    }
}
