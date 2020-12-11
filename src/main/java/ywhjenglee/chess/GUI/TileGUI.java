package ywhjenglee.chess.GUI;

import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.beans.binding.NumberBinding;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class TileGUI extends GridPane {

    private final int x, y;

    public TileGUI(int pX, int pY) {
        x = pX;
        y = pY;
        Rectangle aTile = new Rectangle();
        if ((x + y) % 2 == 0) {
            aTile.setFill(Color.BLUEVIOLET);
        } else {
            aTile.setFill(Color.LIGHTGRAY);
        }
    }
}
