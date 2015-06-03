package com.letzel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by S on 03.06.2015.
 */
public class CommandManager {
    private final List<Command> undospeicher = new ArrayList<Command>();

    public void command( Command command ) {
        command.execute();
        this.undospeicher.add( command );
    }

    public void undo() {
        if ( undospeicher.isEmpty() ) {
            throw new IllegalStateException( "Keine Befehle verfügbar. Nichts zu ersetzen" );
        }

        Command lastCommand = undospeicher.remove( undospeicher.size() - 1 );
        lastCommand.undo();
    }
}
