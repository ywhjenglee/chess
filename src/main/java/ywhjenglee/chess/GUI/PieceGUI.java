package ywhjenglee.chess.GUI;

import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.text.Text;

import ywhjenglee.chess.Pieces.Piece;

public class PieceGUI extends GridPane {

    private int x, y;
    private Piece aPiece;
    private Image aPieceImage;
    private Text aPieceText;

    public PieceGUI(Piece pPiece, int pX, int pY) {
        x = pX;
        y = pY;
        aPiece = pPiece;
        aPieceText = new Text(pPiece.getName());
        setPickOnBounds(false);
        setAlignment(Pos.CENTER);
        getChildren().add(aPieceText);
    }
}
