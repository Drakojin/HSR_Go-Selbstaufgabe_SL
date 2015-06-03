package com.letzel;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by S on 02.06.2015.
 */
public class StandardKopfFactaryTest {

    @Test
    public void testCreateKopf() throws Exception {
        StandardKopfFactary stdtest = new StandardKopfFactary();

        Empfaenger empfaenger = new Empfaenger("Hans", "Hier");
        RechnungsKopf kopf = stdtest.createKopf(empfaenger);

        assertNotNull(kopf);
        assertEquals( empfaenger, kopf.getEmpfaenger() );

        assertTrue( System.currentTimeMillis() - kopf.getDatum() < 1000 );
        assertEquals( 1, kopf.getRechnungsnr() );

        assertEquals( 2, stdtest.createKopf(empfaenger).getRechnungsnr() );
        assertEquals( 3, stdtest.createKopf(empfaenger).getRechnungsnr() );
        assertEquals( 4, stdtest.createKopf( empfaenger ).getRechnungsnr() );
    }
}