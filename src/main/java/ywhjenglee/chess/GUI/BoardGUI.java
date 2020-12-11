package ywhjenglee.chess.GUI;

import ywhjenglee.chess.ChessGame;
import ywhjenglee.chess.Pieces.Piece;

import java.util.List;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;

public class BoardGUI {

    private static StackPane aChessBoard;
    private static GridPane aTilesPane;
    private static GridPane aPiecesPane;
    private static GridPane aMovesPane;
    private ColumnConstraints aColumnConstraints;
    private RowConstraints aRowConstraints;
    private ChessGame aChessGame;
    private List<Piece> allPieces;
    
    public BoardGUI(ChessGame pChessGame) {
        // Initialize layout
        aChessGame = pChessGame;
        aChessBoard = new StackPane();
        aChessBoard.setPadding(new Insets(25));
        aChessBoard.setAlignment(Pos.CENTER);
        aChessBoard.setPrefHeight(600);
        aChessBoard.setPrefWidth(600);

        // Get pieces
        allPieces = aChessGame.getAllPieces();

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
        for (int i = 0; i < 8; i++) {
            aTilesPane.getColumnConstraints().add(aColumnConstraints);
            aTilesPane.getRowConstraints().add(aRowConstraints);
        }
        NumberBinding aTileBinding = Bindings.min(aTilesPane.heightProperty(), aTilesPane.widthProperty());
        for (int j = 0; j < 8; j++) {
            for (int i = 0; i < 8; i++) {
                aTilesPane.add(new TileGUI(this, i, j, aTileBinding), i, 7-j);
            }
        }
    }

    private void createPiecesPane() {
        aPiecesPane = new GridPane();
        aPiecesPane.setPickOnBounds(false);
        for (int i = 0; i < 8; i++) {
            aPiecesPane.getColumnConstraints().add(aColumnConstraints);
            aPiecesPane.getRowConstraints().add(aRowConstraints);
        }
        for (Piece piece : allPieces) {
            int i = piece.getX() - 2;
            int j = piece.getY() - 2;
            aPiecesPane.add(new PieceGUI(piece, i, j), i, 7-j);
        }
    }

    private void createMovesPane() {
        aMovesPane = new GridPane();
        aMovesPane.setPickOnBounds(false);
        for (int i = 0; i < 8; i++) {
            aMovesPane.getColumnConstraints().add(aColumnConstraints);
            aMovesPane.getRowConstraints().add(aRowConstraints);
        }
    }

    public void displayLegalMoves() {
        boolean[][] legalMoves = aChessGame.getSelectedLegalMoves();
        for (int j = 0; j < 8; j++) {
            for (int i = 0; i < 8; i++) {
                if(legalMoves[i+2][j+2]) {
                    aMovesPane.add(new MoveGUI(i, j), i, 7-j);
                }
            }
        }
    }

    public void refreshView() {
        aMovesPane.getChildren().clear();
        aPiecesPane.getChildren().clear();
        allPieces = aChessGame.getAllPieces();
        for (Piece piece : allPieces) {
            int i = piece.getX() - 2;
            int j = piece.getY() - 2;
            aPiecesPane.add(new PieceGUI(piece, i, j), i, 7-j);
        }
    }

    public ChessGame getChessGame() {
        return aChessGame;
    }

    public StackPane getView() {
        return aChessBoard;
    }
}
