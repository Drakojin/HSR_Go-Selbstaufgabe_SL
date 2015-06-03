package com.letzel;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by S on 03.06.2015.
 */
public class Journal extends AbstractHatPreisParent {

    private final String beschreibung;
    private final List<JournalListener> listeners = new CopyOnWriteArrayList<JournalListener>();

    public Journal(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void addChild (HatPreis hatpreis){
        this.children.add(hatpreis);
        for(JournalListener jli : listeners){
            jli.childAdded(this, hatpreis);
        }
    }

    public void accept(HatPreisVisitor visitor) {
        visitor.visit(this);
    }

    public void addListener(JournalListener listener){
        this.listeners.add(listener);
    }

    public void removeListener(JournalListener listener){
        this.listeners.remove(listener);
    }
}
