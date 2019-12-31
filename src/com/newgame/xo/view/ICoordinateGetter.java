package com.newgame.xo.view;

import com.newgame.xo.model.Field;
import com.newgame.xo.model.Point;

public interface ICoordinateGetter {

    public Point getMoveCoordinate(final Field field);

}

