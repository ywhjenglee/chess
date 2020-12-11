package ywhjenglee.chess.GUI;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;

public class MoveGUI extends GridPane {

    private final int x, y;

    public MoveGUI(int pX, int pY) {
        x = pX;
        y = pY;
        Circle aCircle = new Circle(5);
        setPickOnBounds(false);
        setAlignment(Pos.CENTER);
        getChildren().add(aCircle);
    }
}
