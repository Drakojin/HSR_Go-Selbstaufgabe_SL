package com.letzel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by S on 02.06.2015.
 */
public class Rechnungsbuilder {

    private final List<Auftragsposition> items = new ArrayList<Auftragsposition>();

    private RechnungsKopf kopf;
    private TaxStrategy steuer;

    public TaxStrategy getTaxStrategy(){ return steuer;}

    public RechnungsKopf getKopf() {
        return kopf;
    }


    public Rechnungsbuilder setRechnungsKopf(RechnungsKopf kopf) {
        this.kopf = kopf;
        return this;
    }
    public Rechnungsbuilder addAuftragsposition(Auftragsposition item) {
        this.items.add(item);
        return this;
    }
    public Rechnungsbuilder setSteuer(TaxStrategy steuer){this.steuer = steuer;
    return this;}

    public Rechnung build() {
        if(kopf == null){
            throw new IllegalStateException("Kein Rechnungskopf gesetzt");
        }
        if ( steuer == null ) {
            throw new IllegalStateException( "Kein Steuersatz gesetzt" );
        }
        return new Rechnung(items, kopf, steuer);
    }
}
