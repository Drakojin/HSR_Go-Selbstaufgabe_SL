package com.letzel;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by S on 03.06.2015.
 */
public class AddressbuchTest {

    @Test
    public void testBasic() throws Exception {
        Addressbuch abuch = new Addressbuch();

        try {
            abuch.getEintrag(1);
            fail( "Where is the Exception" );
        } catch ( IllegalArgumentException e ) {
            assertEquals( "Kein Eintrag fuer Id: <1> gefunden", e.getMessage() );
        }

    }

    public void testCommands() throws Exception {
        Addressbuch abook = new Addressbuch();
        CommandManager manager = new CommandManager();

        assertEquals( 0, abook.getSize() );

        manager.command(new EinfuegCommand(1, abook, new Empfaenger("a", "b")));
        manager.command(new EinfuegCommand(2, abook,new Empfaenger("c", "d") ));
        assertEquals( 2, abook.getSize() );

        manager.command(new ErsetzCommand(2, abook, new Empfaenger("1", "2")));
        assertEquals( 2, abook.getSize() );
        assertEquals( "1", abook.getEintrag(2).getName() );

        manager.command(new LoeschCommand(1, abook));
        manager.command(new LoeschCommand(2, abook));

        assertEquals( 0, abook.getSize() );


        manager.undo();
        assertEquals( 1, abook.getSize() );
        manager.undo();
        assertEquals( 2, abook.getSize() );
        assertEquals( "1", abook.getEintrag(2).getName() );
        manager.undo();
        assertEquals( 2, abook.getSize() );
        assertEquals( "c", abook.getEintrag(2).getName() );
        manager.undo();
        assertEquals( 1, abook.getSize() );
        manager.undo();

        assertEquals( 0, abook.getSize() );
    }


}