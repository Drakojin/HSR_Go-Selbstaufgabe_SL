package com.letzel;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by S on 02.06.2015.
 */
public class RechnungsbuilderTest {

    @Test
    public void testCreate() throws Exception {
        RechnungsKopfFactory kopfFactory = new StandardKopfFactary();


        Rechnungsbuilder testbuilder = new Rechnungsbuilder();
        Empfaenger empfaenger = new Empfaenger("Hugo", "Dort");
        testbuilder.setRechnungsKopf(kopfFactory.createKopf(empfaenger));

        testbuilder.addAuftragsposition(new Auftragsposition(2, new Article(new Geld(666), "Tester1", false)));
        testbuilder.addAuftragsposition(new Auftragsposition(1, new Article(new Geld(68), "Tester2", true)));

        {
            testbuilder.setSteuer(new StandardTaxStrategy(0.19));
            Rechnung r1 = testbuilder.build();
            assertEquals(2, r1.getItems().size());
            assertEquals(2 * 666 + 68, r1.getNettoRechnungsSumme().getCent());
            assertEquals((2*6.66+0.68)*1.19, r1.getSummeMitSteuer().asDouble(), 0.1);
        }

        {
            testbuilder.setSteuer(new ComplexTaxStrategy(0.10, 0.05));

            Rechnung r2 = testbuilder.build();
            assertEquals( 2 * 6.66 * 1.10 +  0.68 * 1.05, r2.getSummeMitSteuer().asDouble(), 0.01 );
        }
    }
}