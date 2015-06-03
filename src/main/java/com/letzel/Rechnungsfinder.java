package com.letzel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by S on 03.06.2015.
 */
public class Rechnungsfinder implements HatPreisVisitor {

    private final List<Rechnung> found = new ArrayList<Rechnung>();
    private final Article gesucht;
    private Rechnung derzeitige;

    public Rechnungsfinder(Article gesucht) {
        this.gesucht = gesucht;
    }

    public void visit(Journal journal) {
        visitChildren(journal);
    }

    public void visit(Rechnung rechnung) {
        derzeitige = rechnung;
        visitChildren(rechnung);
        derzeitige = null;
    }

    public void visit(Auftragsposition auftragsposition) {
        auftragsposition.getArtikel().accept(this);
    }

    public void visit(Article article) {
        if ( article.equals( gesucht ) ) {
            if ( derzeitige != null ) {
                found.add( derzeitige );
            }
        }
    }

    public List<? extends Rechnung> findeRechnung(HatPreis parent){
        found.clear();
        parent.accept(this);
        return Collections.unmodifiableList(found);
    }

    private void visitChildren(AbstractHatPreisParent parent) {
        for (HatPreis child : parent.getChildren()){
            child.accept(this);
        }
    }
}
