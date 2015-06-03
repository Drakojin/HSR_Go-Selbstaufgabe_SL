package com.letzel;

/**
 * Created by S on 03.06.2015.
 */
public class DefaultArticle implements Article {
    private final Geld preis;
    private final String beschreibung;
    private final boolean lowtax;

    public DefaultArticle(Geld preis, String beschreibung){
        this(preis,beschreibung,false);
    }

    public DefaultArticle(Geld preis, String beschreibung, boolean lowtax) {
        this.preis = preis;
        this.beschreibung = beschreibung;
        this.lowtax = lowtax;
    }

    public boolean isLowtax() {
        return lowtax;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public Geld getPreis() {
        return preis;
    }

    public void accept(HatPreisVisitor visitor) {
        visitor.visit(this);
    }
}
