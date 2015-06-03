package com.letzel;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by S on 03.06.2015.
 */
public class JournalTest {
    @Test
    public void testIt() throws Exception {
        Article articleA = new DefaultArticle(new Geld( 507 ), "Artikel A");
        Article articleB = new DefaultArticle(new Geld( 407 ), "Artikel B");
        Article articleC = new DefaultArticle(new Geld( 307 ), "Artikel C");

        Journal journal = new Journal( "TestJournal" );

        StandardKopfFactary headerFactory = new StandardKopfFactary();

        journal.addChild( new Rechnungsbuilder()
                .setRechnungsKopf( headerFactory.createKopf( new Empfaenger( "Markus Mustermann", "Dofstraﬂe 7" ) ) )
                .setSteuer(new StandardTaxStrategy(0.19))
                .addAuftragsposition(new Auftragsposition(5, articleA))
                .addAuftragsposition(new Auftragsposition(7, articleB)
                ).build() );

        journal.addChild( new Rechnungsbuilder()
                .setRechnungsKopf(headerFactory.createKopf(new Empfaenger("Paula Panther", "Musterstraﬂe 11")))
                .setSteuer(new StandardTaxStrategy(0.19))
                .addAuftragsposition(new Auftragsposition(1, articleC))
                .addAuftragsposition(new Auftragsposition(400, articleB)
                ).build() );


        assertThat( journal.getPreis().asDouble() ).isEqualTo( 1684.91 );

        prettyPrint( journal );


        assertThat( new Rechnungsfinder(articleA).findeRechnung(journal) ).hasSize( 1 ).contains( journal.getChildren().get( 0 ) );
        assertThat( new Rechnungsfinder(articleB).findeRechnung(journal) ).hasSize(2).contains( journal.getChildren().toArray() );

        //Only search a sub tree
        assertThat( new Rechnungsfinder( articleB ).findeRechnung(journal.getChildren().get(0)) ).hasSize( 1 ).contains( journal.getChildren().get( 0 ) );
    }

    private void prettyPrint( Journal journal ) {
        journal.accept( new Rechnungsprinter() );
    }

}