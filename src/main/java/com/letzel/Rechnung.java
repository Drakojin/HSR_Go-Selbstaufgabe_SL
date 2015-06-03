package com.letzel;

import java.util.List;

/**
 * Created by S on 02.06.2015.
 */
public class Rechnung extends AbstractHatPreisParent{

    private final RechnungsKopf kopf;
    private final TaxStrategy steuer;

    public Rechnung(List<Auftragsposition> items, RechnungsKopf kopf, TaxStrategy steuer) {
        super(items);
        this.kopf = kopf;
        this.steuer = steuer;
    }

    public TaxStrategy getTaxStrategy() {
        return steuer;
    }

    public List<HatPreis> getItems() {
        return getChildren();
    }

    public RechnungsKopf getKopf() {
        return kopf;
    }

    public Geld getNettoRechnungsSumme() {
        return getPreis();
    }

    public Geld getSteuersatz() {
        return steuer.berechnen(this);
    }

    public Geld getSummeMitSteuer() {
        return getNettoRechnungsSumme().addieren(getSteuersatz());
    }

    public void accept(HatPreisVisitor visitor) {
        visitor.visit(this);
    }
}
