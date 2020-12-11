package ywhjenglee.chess.GUI;

import javafx.scene.input.MouseEvent;
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
        setOpacity(0);
        createHandle();
    }

    private void createHandle() {
        setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent pEvent) {
                if (aBoardGUI.getChessModel().getSelectedPiece() == null) {
                    if (aBoardGUI.getChessModel().getPiece(x, y) != null) {
                        aBoardGUI.getChessModel().selectPiece(aBoardGUI.getChessModel().getPiece(x, y));
                        aBoardGUI.refreshView();
                    }
                } else {
                    if (aBoardGUI.getChessModel().getSelectedLegalMoves()[x][y]) {
                        aBoardGUI.getChessModel().movePiece(x, y);
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
