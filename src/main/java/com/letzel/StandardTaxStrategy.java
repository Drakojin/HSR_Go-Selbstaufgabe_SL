package com.letzel;

/**
 * Created by S on 03.06.2015.
 */
public class StandardTaxStrategy implements TaxStrategy{
    private final double prozentsatz;

    public StandardTaxStrategy(double prozentsatz) {
        this.prozentsatz = prozentsatz;
    }

    public Geld berechnen(Rechnung r) {
        return r.getNettoRechnungsSumme().multiplizieren(prozentsatz);
    }
}
