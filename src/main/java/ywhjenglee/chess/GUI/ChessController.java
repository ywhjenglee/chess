package ywhjenglee.chess.GUI;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.event.EventHandler;

import javafx.scene.shape.Rectangle;

public class ChessController extends Rectangle {

    private final int x, y;
    private BoardGUI aBoardGUI;

    public ChessController(BoardGUI pBoardGUI, int pX, int pY) {
        x = pX;
        y = pY;
        aBoardGUI = pBoardGUI;
        setWidth(75);
        setHeight(75);
        setFill(Color.TRANSPARENT);
        createHandle();
    }

    private void createHandle() {
        setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent pEvent) {
                if (aBoardGUI.getChessModel().getSelectedPiece() == null) {
                    if (aBoardGUI.getChessModel().getPiece(x+2, y+2) != null) {
                        aBoardGUI.getChessModel().selectPiece(aBoardGUI.getChessModel().getPiece(x+2, y+2));
                        aBoardGUI.refreshMoves();
                    }
                } else {
                    if (aBoardGUI.getChessModel().getVisibleSelectedLegalMoves()[x][y] > 0) {
                        aBoardGUI.getChessModel().movePiece(x+2, y+2);
                        aBoardGUI.refreshView();
                    }
                }
            }
        });
        setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent pEvent) {
                pEvent.setDragDetect(true);
            }
        });
        setOnMouseReleased(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent pEvent) {
            }
        });
        setOnMouseDragged(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent pEvent) {
                pEvent.setDragDetect(false);
            }
        });
        setOnDragDetected(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent pEvent) {
                startFullDrag();
            }
        });
    }
    
}
