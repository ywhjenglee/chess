package ywhjenglee.chess.GUI;

import ywhjenglee.chess.ChessModel;
import ywhjenglee.chess.Pieces.Piece;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class BoardGUI {

    private ChessModel aChessModel;
    private String[] aTileColors;
    private String[] aWhitePieceImage;
    private String[] aBlackPieceImage;

    private static StackPane aChessBoardView;
    private static GridPane aTilesPane;
    private static GridPane aPiecesPane;
    private static GridPane aMovesPane;
    private static GridPane aControllerPane;
    private ColumnConstraints aColumnConstraints;
    private RowConstraints aRowConstraints;

    private BackgroundFill white = new BackgroundFill(Color.valueOf("#e5e7e8"), new CornerRadii(0), new Insets(0));
    private BackgroundFill black = new BackgroundFill(Color.valueOf("#3352fc"), new CornerRadii(0), new Insets(0));
    
    public BoardGUI(ChessModel pChessModel) {
        // Initialize layout
        aChessModel = pChessModel;
        aChessBoardView = new StackPane();
        aChessBoardView.setPadding(new Insets(25));
        aChessBoardView.setAlignment(Pos.CENTER);
        aChessBoardView.setPrefHeight(600);
        aChessBoardView.setPrefWidth(600);

        // Set column and row constraints for BoardGUI
        aColumnConstraints = new ColumnConstraints();
        aColumnConstraints.setPercentWidth(100.0/8.0);
        aColumnConstraints.setHalignment(HPos.CENTER);
        aRowConstraints = new RowConstraints();
        aRowConstraints.setPercentHeight(100.0/8.0);
        aRowConstraints.setValignment(VPos.CENTER);

        // Setup Board GUI
        createTilesPane();
        createPiecesPane();
        createMovesPane();
        createControllerPane();
        aChessBoardView.getChildren().addAll(aTilesPane, aPiecesPane, aMovesPane, aControllerPane);
    }

    private void createTilesPane() {
        aTilesPane = new GridPane();
        for (int i = 0; i < 8; i++) {
            aTilesPane.getColumnConstraints().add(aColumnConstraints);
            aTilesPane.getRowConstraints().add(aRowConstraints);
        }
        for (int j = 0; j < 8; j++) {
            for (int i = 0; i < 8; i++) {
                HBox aTile = new HBox();
                if ((i + j) % 2 == 0) {
                    aTile.setBackground(new Background(black));
                } else {
                    aTile.setBackground(new Background(white));
                }
                aTilesPane.add(aTile, i, 7-j);
            }
        }
    }

    private void createPiecesPane() {
        aPiecesPane = new GridPane();
        for (int i = 0; i < 8; i++) {
            aPiecesPane.getColumnConstraints().add(aColumnConstraints);
            aPiecesPane.getRowConstraints().add(aRowConstraints);
        }
        refreshPieces();
    }

    private void createMovesPane() {
        aMovesPane = new GridPane();
        for (int i = 0; i < 8; i++) {
            aMovesPane.getColumnConstraints().add(aColumnConstraints);
            aMovesPane.getRowConstraints().add(aRowConstraints);
        }
        refreshMoves();
    }

    private void createControllerPane() {
        aControllerPane = new GridPane();
        aControllerPane.setGridLinesVisible(true);
        for (int i = 0; i < 8; i++) {
            aControllerPane.getColumnConstraints().add(aColumnConstraints);
            aControllerPane.getRowConstraints().add(aRowConstraints);
        }
        for (int j = 0; j < 8; j++) {
            for (int i = 0; i < 8; i++) {
                aControllerPane.add(new ChessController(this, i, j), i, 7-j);
            }
        }
    }

    private void refreshPieces() {
        aPiecesPane.getChildren().clear();
        for (Piece piece : aChessModel.getAllPieces()) {
            int i = piece.getX();
            int j = piece.getY();
            Text aPieceText = new Text(piece.getName());
            aPiecesPane.add(aPieceText, i, 7-j);
        }
    }

    public void refreshMoves() {
        aMovesPane.getChildren().clear();
        if (aChessModel.getSelectedPiece() != null) {
            boolean[][] legalMoves = aChessModel.getSelectedLegalMoves();
            for (int j = 0; j < 8; j++) {
                for (int i = 0; i < 8; i++) {
                    if(legalMoves[i][j]) {
                        Circle aLegalMove = new Circle(5);
                        aMovesPane.add(aLegalMove, i, 7-j);
                    }
                }
            }
        }
    }

    public void refreshView() {
        aMovesPane.getChildren().clear();
        refreshPieces();
    }

    public ChessModel getChessModel() {
        return aChessModel;
    }

    public StackPane getView() {
        return aChessBoardView;
    }
}
