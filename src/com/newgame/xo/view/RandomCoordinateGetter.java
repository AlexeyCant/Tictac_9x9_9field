package com.newgame.xo.view;

import com.newgame.xo.model.Field;
import com.newgame.xo.model.Point;
import java.util.Random;
import com.newgame.xo.view.ICoordinateGetter;

public class RandomCoordinateGetter implements ICoordinateGetter {

    private static final Random RANDOM = new Random();

    public Point getMoveCoordinate(final Field field) {
        Point randomPoint = new Point(RANDOM.nextInt(field.getSize()), RANDOM.nextInt(field.getSize()));
        while (field.getFigure(randomPoint) != null) {
            randomPoint = new Point(RANDOM.nextInt(field.getSize()), RANDOM.nextInt(field.getSize()));
        }
        return randomPoint;
    }
}