package com.letzel;

/**
 * Created by S on 02.06.2015.
 */
public class Empfaenger {

    private final String name;
    private final String addresse;

    public Empfaenger(String name, String addresse) {
        this.name = name;
        this.addresse = addresse;

    }

    public String getName() {
        return name;
    }

    public String getAddresse() {
        return addresse;
    }

}
