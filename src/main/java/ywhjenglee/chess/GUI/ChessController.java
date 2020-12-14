package ywhjenglee.chess.GUI;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.event.EventHandler;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.geometry.Insets;

public class ChessController extends HBox {

    private final int x, y;
    private ChessGUI aChessGUI;

    private BackgroundFill transparent = new BackgroundFill(Color.rgb(128, 128, 128, 0.0), new CornerRadii(0), new Insets(0));

    public ChessController(ChessGUI pChessGUI, int pX, int pY) {
        x = pX;
        y = pY;
        aChessGUI = pChessGUI;
        setBackground(new Background(transparent));
        createHandle();
    }

    private void createHandle() {
        setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent pEvent) {
                if (aChessGUI.getChessModel().getSelectedPiece() == null) {
                    if (aChessGUI.getChessModel().getPiece(x+2, y+2) != null) {
                        aChessGUI.getChessModel().selectPiece(aChessGUI.getChessModel().getPiece(x+2, y+2));
                        aChessGUI.getBoardGUI().refreshMoves();
                    }
                } else {
                    if (aChessGUI.getChessModel().getVisibleSelectedLegalMoves()[x][y] > 0) {
                        aChessGUI.getChessModel().movePiece(x+2, y+2);
                        aChessGUI.getBoardGUI().refreshView();
                        aChessGUI.getProfileGUI(true).refreshTakenPieces();
                        aChessGUI.getProfileGUI(false).refreshTakenPieces();
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
