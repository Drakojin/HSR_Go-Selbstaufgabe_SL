package com.letzel;

/**
 * Created by S on 03.06.2015.
 */
public interface Command {
    void execute();

    void undo();
}
