package com.letzel;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by S on 02.06.2015.
 */
public class BackdateFactoryTest {

    @Test
    public void testCreateKopf() throws Exception {
        RechnungsKopfFactory backdatetest = new BackdateFactory();

        Rechnungsbuilder builder = new Rechnungsbuilder();
        builder.setRechnungsKopf(backdatetest.createKopf(new Empfaenger("Hans", "Hier")));
        builder.addAuftragsposition(new Auftragsposition(2, new DefaultArticle(new Geld(200), "I1", false)));
        builder.addAuftragsposition(new Auftragsposition(3, new DefaultArticle(new Geld(100), "I2", false)));
        builder.setSteuer(new StandardTaxStrategy(0.19));

        Rechnung rechnung = builder.build();
        assertEquals( 2, rechnung.getItems().size() );
        assertEquals( 2 * 200 + 3 * 100, rechnung.getNettoRechnungsSumme().getCent() );

        assertThat(rechnung.getKopf().getDatum()).isLessThan(System.currentTimeMillis()).isLessThan(System.currentTimeMillis() - 1000 * 60 * 60 * 24 * 10 + 1000);

        assertTrue( "header date: <" + rechnung.getKopf().getDatum() + "> now: <" + System.currentTimeMillis() + ">", System.currentTimeMillis() - rechnung.getKopf().getDatum() < 1000 * 60 * 60 * 24 * 10 + 1000 );
    }
}
