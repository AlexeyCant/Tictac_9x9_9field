package com.newgame.xo.view;

import com.newgame.xo.model.Field;
import com.newgame.xo.model.Figure;
import com.newgame.xo.model.Point;

public class AICoordinateGetterTwo implements ICoordinateGetter {
// нерандомный ход с угла
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
        //сгенироровать второстипенные точки
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
            //второй шаг (на доске 2 фигуры)
            if(countFigure == 2 && field.getFigure(pCenter) != null)
                return p22;
            if (countFigure == 2 && field.getFigure(p22) != null)
                return p02;
            if (countFigure == 2 && field.getFigure(p20) != null)
                return p02;
            if (countFigure == 2 && field.getFigure(p02) != null)
                return p20;
            if (countFigure == 2 && (field.getFigure(p01) != null || field.getFigure(p10) != null ||
                    field.getFigure(p12) != null || field.getFigure(p21) != null ))
                return p02;

            //шаг третий (на доске четыре фигуры)
            if(countFigure == 4 && field.getFigure(p00).equals(field.getFigure(p02))
                    && field.getFigure(p01) == null)
                return p01;
            if(countFigure == 4 && field.getFigure(p00).equals(field.getFigure(p20))
                    && field.getFigure(p10) == null)
                return p10;
            if(countFigure == 4 && field.getFigure(p01)!= null && field.getFigure(p10) != null) //добавить проверку на Х в углах
                return p22;
            if(countFigure == 4 && field.getFigure(p00).equals(field.getFigure(p02)) && field.getFigure(p01) != null)
                return p20;
            if(countFigure == 4 && field.getFigure(p00).equals(field.getFigure(p20)) && field.getFigure(p10) != null)
                return p02;

            //шаг четвертый (на доске шесть фигур)

            //шаг пятый (на доске пять фигур)

            return p00;


        }

    private int countFiguresInOneRow (final Field field, final Integer row) {
        int countFigure = 0;
        for (int x = 0; x < field.getSize(); x++) {
            final Point p = new Point(x, row);
            if (field.getFigure(p) != null)
                countFigure++;
        }
        return countFigure;
    }

}

