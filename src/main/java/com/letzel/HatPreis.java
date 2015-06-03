package com.letzel;

/**
 * Created by S on 03.06.2015.
 */
public interface HatPreis {
    Geld getPreis();

    void accept( HatPreisVisitor visitor );
}
