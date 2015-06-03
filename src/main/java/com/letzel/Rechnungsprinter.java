package com.letzel;

import com.google.common.base.Strings;
/**
 * Created by S on 03.06.2015.
 */
public class Rechnungsprinter implements HatPreisVisitor {

    private int depth;

    public void visit(Journal journal) {
        System.out.println(indent() + "--------------------------");
        System.out.println(indent() + journal.getBeschreibung());
        System.out.println(indent() + "--------------------------");
        visitChildren(journal);
        System.out.println(indent() + "--------------------------");
        System.out.println(indent() + journal.getPreis());
    }

    public void visit(Rechnung rechnung) {
        System.out.println( indent() + rechnung.getKopf().getRechnungsnr() + " - " + rechnung.getKopf().getEmpfaenger().getName() );
        visitChildren( rechnung );
        depth++;
        System.out.println( indent() + "--------------------------" );
        System.out.println( indent() + "Net:   " + rechnung.getNettoRechnungsSumme() );
        System.out.println( indent() + "Tax:   " + rechnung.getSteuersatz() );
        System.out.println( indent() + "Gross: " + rechnung.getSummeMitSteuer() );
        depth--;
    }

    public void visit(Auftragsposition auftragsposition) {
        System.out.println( indent() + auftragsposition.getMenge() + " " + auftragsposition.getArtikel().getBeschreibung() + " à " + auftragsposition.getArtikel().getPreis().format() );
    }

    public void visit(Article article) {

    }

    private void visitChildren(AbstractHatPreisParent parent) {
        depth++;
        for (HatPreis child : parent.getChildren()){
            child.accept(this);
        }
        depth--;
    }

    private String indent() {
        return Strings.repeat("\t", depth);
    }

}
