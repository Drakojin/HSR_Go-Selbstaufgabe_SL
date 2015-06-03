package com.letzel;

/**
 * Created by S on 03.06.2015.
 */
public class ComplexTaxStrategy implements TaxStrategy {

    private final double prozentsatznormal;
    private final double protzentsatzreduziert;

    public ComplexTaxStrategy(double prozentsatznormal, double protzentsatzreduziert) {
        this.prozentsatznormal = prozentsatznormal;
        this.protzentsatzreduziert = protzentsatzreduziert;
    }

    public Geld berechnen(Rechnung r) {
        Geld nettonormal = new Geld( 0 );
        Geld nettoreduziert = new Geld( 0 );

        for(HatPreis item : r.getItems()){
            if(isReduced((Auftragsposition)item)){
                nettoreduziert = nettoreduziert.addieren(item.getPreis());
            }
            else{ nettonormal = nettonormal.addieren(item.getPreis());}
        }
        return nettonormal.multiplizieren(prozentsatznormal).addieren(nettoreduziert.multiplizieren(protzentsatzreduziert));
    }

    protected boolean isReduced( Auftragsposition item ) {
        return item.getArtikel().isLowtax();
    }
}
