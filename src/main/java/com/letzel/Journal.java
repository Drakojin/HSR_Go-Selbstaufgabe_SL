package com.letzel;

/**
 * Created by S on 03.06.2015.
 */
public class Journal extends AbstractHatPreisParent {

    private final String beschreibung;

    public Journal(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void addChild (HatPreis hatpreis){
        this.children.add(hatpreis);
    }

    public void accept(HatPreisVisitor visitor) {
        visitor.visit(this);
    }
}
