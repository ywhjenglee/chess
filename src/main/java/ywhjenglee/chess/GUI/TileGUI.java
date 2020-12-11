package ywhjenglee.chess.GUI;

import javafx.scene.shape.Rectangle;
import javafx.beans.binding.NumberBinding;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;

public class TileGUI extends GridPane {

    private final int x, y;
    private static Rectangle aRectangle;
    private BoardGUI aBoardGUI;

    public TileGUI(BoardGUI pBoardGUI, int pX, int pY, NumberBinding pTileBinding) {
        x = pX;
        y = pY;
        aRectangle = new Rectangle(50, 50);
        aBoardGUI = pBoardGUI;
        if ((x + y) % 2 == 0) {
            aRectangle.setFill(Color.BLUEVIOLET);
        } else {
            aRectangle.setFill(Color.LIGHTGRAY);
        }
        createHandle();
        aRectangle.widthProperty().bind(pTileBinding.divide(8));
        aRectangle.heightProperty().bind(pTileBinding.divide(8));
        setAlignment(Pos.CENTER);
        getChildren().add(aRectangle);
    }

    private void createHandle() {
        aRectangle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent pEvent) {
                if (aBoardGUI.getChessGame().getSelectedPiece() == null) {
                    if (aBoardGUI.getChessGame().getPiece(x, y) != null) {
                        aBoardGUI.getChessGame().selectPiece(aBoardGUI.getChessGame().getPiece(x, y));
                        aBoardGUI.displayLegalMoves();
                    }
                } else {
                    if (aBoardGUI.getChessGame().getSelectedLegalMoves()[x][y]) {
                        aBoardGUI.getChessGame().movePiece(x, y);
                        aBoardGUI.refreshView();
                    }
                }
            }
        });
        aRectangle.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent pEvent) {
                pEvent.setDragDetect(true);
            }
        });
        aRectangle.setOnMouseReleased(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent pEvent) {
            }
        });
        aRectangle.setOnMouseDragged(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent pEvent) {
                pEvent.setDragDetect(false);
            }
        });
        aRectangle.setOnDragDetected(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent pEvent) {
                aRectangle.startFullDrag();
            }
        });
    }
}
