package com.letzel;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by S on 03.06.2015.
 */
public class StandardTaxStrategyTest {

    @Test
    public void testBerechnen() throws Exception {
        RechnungsKopf header = new RechnungsKopf(123, 33, new Empfaenger("a", "b"));
        Rechnung invoice = new Rechnung(ImmutableList.of(new Auftragsposition(1, new DefaultArticle(new Geld(300), "asdf", false))), header, new StandardTaxStrategy(0.19));

        assertEquals(3.00 * 0.19, invoice.getSteuersatz().asDouble(), 0.0001);
    }
}