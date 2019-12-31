package com.newgame.xo.view;

import com.newgame.xo.model.Field;
import com.newgame.xo.model.Point;

public abstract class ICoordinateGetter {

    public abstract Point getMoveCoordinate(final Field field);

}

