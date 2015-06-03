package com.letzel;

/**
 * Created by S on 02.06.2015.
 */
public class Auftragsposition implements HatPreis {

    private final int menge;
    private final Article artikel;

    public Auftragsposition(int menge, Article artikel) {
        this.menge = menge;
        this.artikel = artikel;
    }

    public int getMenge() {
        return menge;
    }

    public Article getArtikel() {
        return artikel;
    }

    public Geld getPreis() {
        return artikel.getPreis().multiplizieren(menge);
    }

    public Geld getGesamtPreis() {
        return getPreis();
    }

    public void accept(HatPreisVisitor visitor) {
        visitor.visit(this);
    }
}
