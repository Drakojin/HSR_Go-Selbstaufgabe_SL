package com.letzel;

/**
 * Created by S on 03.06.2015.
 */
public class Article implements HatPreis {
    private final Geld preis;
    private final String beschreibung;
    private final boolean lowtax;

    public Article(Geld preis, String beschreibung){
        this(preis,beschreibung,false);
    }

    public Article(Geld preis, String beschreibung, boolean lowtax) {
        this.preis = preis;
        this.beschreibung = beschreibung;
        this.lowtax = lowtax;
    }

    public Geld getWert(){
        return preis;
    }
    public String getBeschreibung() {
        return beschreibung;
    }

    public boolean isLowtax() {
        return lowtax;
    }

    public Geld getPreis() {
        return preis;
    }

    public void accept(HatPreisVisitor visitor) {
        visitor.visit(this);
    }
}
