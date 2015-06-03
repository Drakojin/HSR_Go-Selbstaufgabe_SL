package com.letzel;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by S on 01.06.2015.
 */
public class GeldTest {
    public static Geld geld;

    @BeforeClass
    public static void setup() {
        geld = new Geld(666);
    }

    @Test
    public void testGetBetrag() throws Exception {
        assertEquals(666, geld.getCent());
    }

    @Test
    public void testAsDouble() throws Exception {
        assertEquals(6.66, geld.asDouble(), 0);
    }

    @Test
    public void testAddieren() throws Exception {
        assertEquals(700, geld.addieren(new Geld(34)).getCent());
        assertEquals(667, geld.addieren(new Geld(1)).getCent());
    }

    @Test
    public void testSubtrahieren() throws Exception {
        assertEquals(600, geld.subtrahieren(new Geld(66)).getCent());
        assertEquals(1, geld.subtrahieren(new Geld(665)).getCent());
    }

    @Test
    public void testMultiplizieren() throws Exception {
        assertEquals(1332, geld.multiplizieren(2).getCent());
    }
}