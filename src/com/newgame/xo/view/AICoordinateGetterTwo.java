package com.newgame.xo.view;

import com.newgame.xo.model.Field;
import com.newgame.xo.model.Point;

public class AICoordinateGetterTwo implements ICoordinateGetter {

    public Point getMoveCoordinate (final Field field){

        //сгенирировать важные точки (углы и центр)
        Point p00 = new Point(field.getSize()-field.getSize(),
                field.getSize()-field.getSize()); //левый верхний угол
        Point p02 = new Point(field.getSize()-field.getSize(),
                field.getSize()-1); //левый нижний угол

        Point p20 = new Point(field.getSize()-1,
                field.getSize()-field.getSize()); //

        Point p22 = new Point(field.getSize()-1,
                field.getSize()-1);// правый нижний угол

        Point pCenter = new Point((field.getSize()-1)/2,
                (field.getSize()-1)/2); // центральная точка

        Point p01 = new Point(field.getSize()-field.getSize(), (field.getSize()-1)/2);
        Point p10 = new Point((field.getSize()-1)/2, field.getSize()-field.getSize());
        Point p12 = new Point((field.getSize()-1)/2, field.getSize()-1);
        Point p21 = new Point(field.getSize()-1, (field.getSize()-1)/2);

        int countFigure = 0;
        for (int x = 0; x < field.getSize(); x++){
            countFigure += countFiguresInOneRow(field, x);
        }

        //1 шаг ствим точку в левый верхний угол

            if(field.isEmpty())
            return p00;
            if (countFigure = 2)
                return
            else {if (field.getFigure(pCenter) != null) {
                return p22;
            } else { return pCenter; }

            }

        }

    private int countFiguresInOneRow (final Field field, final Integer row) {
        int countFigure = 0;
        for (int x = 0; x < field.getSize(); x++) {
            final Point p = new Point(x, row);
            if (field.getFigure(p) != null)
                countFigure++;
        }
        return countFigure;
    }*/

}

