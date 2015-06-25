package com.letzel;

/**
 * Created by S on 03.06.2015.
 */
public class SecondhandArticle implements Article {

    private final double rabattprozent;
    private final Article article;
    private final String suffix = " (gebraucht)";

    public SecondhandArticle(double rabattprozent, Article article) {
        this.rabattprozent = rabattprozent;
        this.article = article;
    }

    public String getBeschreibung() {
        return article.getBeschreibung()+suffix;
    }

    public boolean isLowtax() {
        return article.isLowtax();
    }

    public Geld getPreis() {
        return article.getPreis().multiplizieren(1-rabattprozent);
    }

    public void accept(HatPreisVisitor visitor) {
        visitor.visit(article);
    }
}
