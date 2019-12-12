package com.newgame.xo.view;

import com.newgame.xo.model.Field;
import com.newgame.xo.model.Figure;
import com.newgame.xo.model.Point;

import java.util.Random;

public class AICoordinateGetter implements ICoordinateGetter {
  // полу рандомный ход с центра

    public Point getMoveCoordinate(final Field field) {


        // Сразу же сгенерируем для себя самые выгодные ходы на поле:
        Point p00 = new Point(field.getSize() - field.getSize()
                , field.getSize() - field.getSize());// левый верхний угол
        Point pMaxMax = new Point(field.getSize() -1
                , field.getSize() - 1);              // правый нижний угол
        Point pMax0 = new Point(field.getSize() -1
                , field.getSize() - field.getSize());// правый верхний угол
        Point p0Max = new Point(field.getSize() - field.getSize()
                , field.getSize() - 1);              // левый нижний угол

        Point pCentre = new Point((field.getSize() - 1) / 2
                , (field.getSize() - 1) / 2 );       // центр

        // сохраним эти выгодные ходы в массивчик для удобства
        final Point[] startPoint = {p00, pMaxMax, pMax0, p0Max};

        // сгенерируем второстепенные точки:
        Point p1 = new Point(field.getSize() - field.getSize(), (field.getSize() - 1) / 2);
        Point p2 = new Point((field.getSize() - 1) / 2, field.getSize() - field.getSize());
        Point p3 = new Point(field.getSize() -1, (field.getSize() - 1) / 2);
        Point p4 = new Point((field.getSize() - 1) / 2, (field.getSize() - 1));
        // сохраняем для удобства в массив
        final Point[] secondPoints = {p1, p2, p3, p4};

        // начинаем выбор точки
        if (field.isEmpty()) {    // пустое поле. первый ход.
            return pCentre; // занимаем центр
        } else {   // следующий выгодный ход, если центральная клеточка уже занята.
            for (int i = 0; i < startPoint.length; i++) { // перебираем свободные выгодные клеточки
                Point tempPoint = startPoint[new Random().nextInt(startPoint.length)];
                if (field.getFigure(tempPoint) == null) return tempPoint; // и занимаем одну из них
            }
        }

        // перебираем точки второстипенной важности
        // но рандомайзер оно побеждает и первым перебором точек
        for (int i = 0; i < secondPoints.length; i++) {
            // следующий выгодный ход.
            Point secondTempPoint = secondPoints[new Random().nextInt(secondPoints.length)];
            if (field.getFigure(secondTempPoint) == null) {
                return secondTempPoint; // и делаем один из них
            }
        }

		/*
		Если уж совсем рандомайзер такой крутой
		- пускай сам с собой играет )))
		*/
        return new RandomCoordinateGetter().getMoveCoordinate(field);
        // END
        // END
        // BEGIN
		/*//##простое решение##
		if (field.getFigure(new Point(1, 1)) == null)
			return new Point(1, 1);
		if (field.getFigure(new Point(0, 0)) == null)
			return new Point(0, 0);
		if (field.getFigure(new Point(0, 0)) == Figure.O)
			return new Point(2, 0);
		if (field.getFigure(new Point(0, 0)) == Figure.X && field.getFigure(new Point(2, 2)) == null)
			return new Point(2, 2);
		if (field.getFigure(new Point(2, 0)) == Figure.X && field.getFigure(new Point(0, 2)) == null)
			return new Point(0, 2);
		return new RandomCoordinateGetter().getMoveCoordinate(field);
		 */
        // END
        // BEGIN (write your solution here)

        // END
    }
}
