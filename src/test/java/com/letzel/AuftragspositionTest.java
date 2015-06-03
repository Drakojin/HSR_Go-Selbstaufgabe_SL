package com.letzel;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by S on 02.06.2015.
 */
public class AuftragspositionTest {

    @Test
    public void testGetGesamtPreis() throws Exception {
        assertEquals(1332, new Auftragsposition(2, new Article(new Geld(666), "Tester", false)).getGesamtPreis().getCent(),0);
    }
}