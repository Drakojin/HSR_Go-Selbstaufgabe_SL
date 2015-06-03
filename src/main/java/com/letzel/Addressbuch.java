package com.letzel;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by S on 03.06.2015.
 */
public class Addressbuch {
    private final Map<Integer, Empfaenger> abuch = new HashMap<Integer, Empfaenger>();

    public Empfaenger getEintrag(int id){
        Empfaenger found = abuch.get( id );
        if ( found == null ) {
            throw new IllegalArgumentException( "Kein Eintrag fuer Id: <" + id + "> gefunden" );
        }
        return found;
    }

    public void addEmpfaenger(int id, Empfaenger e){
        abuch.put(id, e);
    }

    public Empfaenger removeEmpfaenger(int id){
        return abuch.remove(id);
    }

    public int getSize(){
        return abuch.size();
    }

    public boolean enthaelt(Empfaenger e){
        return abuch.containsValue(e);
    }
}
