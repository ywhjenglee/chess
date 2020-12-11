package ywhjenglee.chess.GUI;

import ywhjenglee.chess.ChessGame;
import ywhjenglee.chess.Pieces.Piece;

import java.util.List;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;

public class BoardGUI {

    private StackPane aChessBoard;
    private GridPane aTilesPane;
    private GridPane aPiecesPane;
    private GridPane aMovesPane;
    private List<Piece> allPieces;
    private ColumnConstraints aColumnConstraints;
    private RowConstraints aRowConstraints;
    
    public BoardGUI(ChessGame pChessGame) {
        // Initialize layout
        aChessBoard = new StackPane();
        aChessBoard.setPadding(new Insets(25));
        aChessBoard.setAlignment(Pos.CENTER);
        aChessBoard.setPrefHeight(400);
        aChessBoard.setPrefWidth(400);

        // Get pieces
        allPieces = pChessGame.getAllPieces();

        // Set column and row constraints for BoardGUI
        aColumnConstraints = new ColumnConstraints();
        aColumnConstraints.setPercentWidth(100.0/8.0);
        aRowConstraints = new RowConstraints();
        aRowConstraints.setPercentHeight(100.0/8.0);

        // Setup Board GUI
        createTilesPane();
        createPiecesPane();
        createMovesPane();
        aChessBoard.getChildren().addAll(aTilesPane, aPiecesPane, aMovesPane);
    }

    private void createTilesPane() {
        aTilesPane = new GridPane();
        aTilesPane.setGridLinesVisible(true);
        for (int i = 0; i < 8; i++) {
            aTilesPane.getColumnConstraints().add(aColumnConstraints);
            aTilesPane.getRowConstraints().add(aRowConstraints);
        }
        for (int j = 0; j < 8; j++) {
            for (int i = 0; i < 8; i++) {
                aTilesPane.add(new TileGUI(i, j), i, 7-j);
            }
        }
    }

    private void createPiecesPane() {
        aPiecesPane = new GridPane();
        aPiecesPane.setGridLinesVisible(true);
        for (int i = 0; i < 8; i++) {
            aPiecesPane.getColumnConstraints().add(aColumnConstraints);
            aPiecesPane.getRowConstraints().add(aRowConstraints);
        }
        for (Piece piece : allPieces) {
            int i = piece.getX() - 2;
            int j = piece.getY() - 2;
            aPiecesPane.add(new PieceGUI(piece, i, j), i, j);
        }
    }

    private void createMovesPane() {
        aMovesPane = new GridPane();
        aMovesPane.setGridLinesVisible(true);
        for (int i = 0; i < 8; i++) {
            aMovesPane.getColumnConstraints().add(aColumnConstraints);
            aMovesPane.getRowConstraints().add(aRowConstraints);
        }
    }

    public StackPane getView() {
        return aChessBoard;
    }
}
