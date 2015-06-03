package com.letzel;

import org.fest.assertions.Delta;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;
/**
 * Created by S on 03.06.2015.
 */
public class SecondhandArticleTest {

    @Test
    public void testIT() throws Exception{
        Article article = new DefaultArticle(new Geld( 666 ), "Tester");
        assertThat( article.getBeschreibung() ).isEqualTo( "Tester" );
        assertThat( article.getPreis().asDouble() ).isEqualTo( 6.66 );


        Article secondHandArticle = new SecondHandArticle(0.19, article);
        assertThat(secondHandArticle.getBeschreibung() ).isEqualTo( "Tester (gebraucht)" );
        assertThat( secondHandArticle.getPreis().asDouble() ).isEqualTo( 6.66 * 0.81, Delta.delta( 0.005 ) );
    }

}