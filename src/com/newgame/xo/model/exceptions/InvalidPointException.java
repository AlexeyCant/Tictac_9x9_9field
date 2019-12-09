package com.newgame.xo.model.exceptions;

import com.newgame.xo.model.Field;
import com.newgame.xo.model.Point;

public class InvalidPointException extends AbstractXOException {

    public InvalidPointException(final Point point, final Field field){

        super("Point can't be \'.x= "
                + point.getX()
                + "\' & \'.y= "
                + point.getY()
                + "\' Point must be between \'0\' and \'"
                + field.getSize()
                + "\' inclusive!");
    }
}