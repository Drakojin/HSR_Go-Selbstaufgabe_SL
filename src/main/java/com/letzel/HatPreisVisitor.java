package com.letzel;

/**
 * Created by S on 03.06.2015.
 */
public interface HatPreisVisitor {
    void visit(Journal journal);
    void visit(Rechnung rechnung);
    void visit(Auftragsposition auftragsposition);
    void visit(Article article);
}
