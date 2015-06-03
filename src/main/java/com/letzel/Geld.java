package com.letzel;

import java.text.NumberFormat;

/**
 * Created by S on 01.06.2015.
 */
public class Geld {

    private final long cent;

    public Geld(long cent) {
        this.cent = cent;
    }

    public long getCent() {
        return cent;
    }

    public double asDouble(){
        return cent / 100.0;
    }

    public Geld addieren (Geld geld){
       return new Geld(getCent() + geld.getCent());
    }

    public Geld subtrahieren (Geld geld){
        return new Geld(getCent() - geld.getCent());
    }

    public Geld multiplizieren (double faktor){
        return new Geld(Math.round(this.getCent()*faktor));
    }

    public String format() {
        return NumberFormat.getCurrencyInstance().format( getCent() / 100.0 );
    }
    @Override
    public String toString() {
        return format();
    }
}
