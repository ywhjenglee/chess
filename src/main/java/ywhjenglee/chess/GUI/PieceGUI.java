package ywhjenglee.chess.GUI;

import javafx.scene.layout.GridPane;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.text.Text;

import ywhjenglee.chess.Pieces.Piece;

public class PieceGUI extends GridPane {

    private int x, y;
    private Piece aPiece;

    public PieceGUI(Piece pPiece, int pX, int pY) {
        x = pX;
        y = pY;
        aPiece = pPiece;
        Text aPieceImage = new Text(pPiece.getName());
        getChildren().add(new Text(pPiece.getName()));
    }
}
