package com.newgame.xo;

import com.newgame.xo.model.Field;
import com.newgame.xo.model.Point;
import com.newgame.xo.model.Figure;

import com.newgame.xo.controllers.*;
import com.newgame.xo.view.AICoordinateGetter;
import com.newgame.xo.view.ConsoleView;
import com.newgame.xo.view.ICoordinateGetter;
import com.newgame.xo.view.RandomCoordinateGetter;
import com.newgame.xo.view.AICoordinateGetterTwo;

public class Main {

    public static void main(String... args) throws Exception {
        final Field field = new Field();
        final ICoordinateGetter random = new RandomCoordinateGetter();
     //  final ICoordinateGetter ai = new AICoordinateGetter();
        final ICoordinateGetter ai = new AICoordinateGetterTwo();
        final MoveController mc = new MoveController();
        final WinnerController wc = new WinnerController();
        final ConsoleView cv = new ConsoleView();
        cv.show(field);

        for (int i = 0; i < 9; i++) {
            Thread.sleep(1000);
            final Point p;
            if (i % 2 == 0)
                p = ai.getMoveCoordinate(field);
            else
                p = random.getMoveCoordinate(field);
            final Figure f = i % 2 == 0 ? Figure.X : Figure.O;
            if (!mc.applyFigure(field, p, f)) {
                throw new RuntimeException("looks like AI make illegal moves;)");
            }
            final Figure winner = wc.getWinner(field);
            cv.show(field);
            if (winner == Figure.O)
                throw new RuntimeException("O win's! 0_o");
            if (winner == Figure.X) {
                System.out.println("X - win's!");
                return;
            }
        }
        throw new RuntimeException("no one won =(");
    }
}