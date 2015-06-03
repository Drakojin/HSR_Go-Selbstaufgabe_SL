package com.letzel;

import java.util.List;

/**
 * Created by S on 03.06.2015.
 */
public interface HatPreisParent extends HatPreis {
    List<HatPreis> getChildren();
}

