package com.letzel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by S on 03.06.2015.
 */
public abstract class AbstractHatPreisParent implements HatPreisParent {
    protected final List<HatPreis> children = new ArrayList<HatPreis>();

    public AbstractHatPreisParent() {
    }

    public AbstractHatPreisParent(List<? extends HatPreis> children) {
        this.children.addAll(children);
    }

    public List<HatPreis> getChildren() {
        return children;
    }

    public Geld getPreis() {
        Geld sum = new Geld(0);
        for (HatPreis child : children) {
            sum = sum.addieren(child.getPreis());
        }
        return sum;
    }
}
