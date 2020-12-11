package ywhjenglee.chess.GUI;

import ywhjenglee.chess.ChessGame;
import ywhjenglee.chess.Pieces.Piece;
import ywhjenglee.chess.Tile;

import javafx.scene.shape.Rectangle;
import javafx.beans.binding.NumberBinding;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;

public class TileGUI extends GridPane {

    private final int x, y;
    private Rectangle bTile;
    private Tile aTile;

    public TileGUI(Tile pTile, NumberBinding pTileBinding) {
        aTile = pTile;
        x = pTile.getTileX() - 2;
        y = pTile.getTileY() - 2;
        bTile = new Rectangle(50, 50);
        if ((x + y) % 2 == 0) {
            bTile.setFill(Color.BLUEVIOLET);
        } else {
            bTile.setFill(Color.LIGHTGRAY);
        }
        createHandle();
        bTile.widthProperty().bind(pTileBinding.divide(8));
        bTile.heightProperty().bind(pTileBinding.divide(8));
        setAlignment(Pos.CENTER);
        getChildren().add(bTile);
    }

    private void createHandle() {
        bTile.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent pEvent) {
                if (ChessGame.getSelectedPiece() == null) {
                    if (aTile.getPiece() != null) {
                        ChessGame.selectPiece(aTile.getPiece());
                        ChessGame.getSelectedLegalMoves();
                        BoardGUI.displayLegalMoves();
                    }
                } else {

                }
            }
        });
        bTile.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent pEvent) {
                pEvent.setDragDetect(true);
            }
        });
        bTile.setOnMouseReleased(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent pEvent) {
            }
        });
        bTile.setOnMouseDragged(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent pEvent) {
                pEvent.setDragDetect(false);
            }
        });
        bTile.setOnDragDetected(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent pEvent) {
                bTile.startFullDrag();
            }
        });
    }
}
