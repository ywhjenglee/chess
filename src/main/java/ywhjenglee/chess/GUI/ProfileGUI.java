package ywhjenglee.chess.GUI;

import ywhjenglee.chess.Pieces.Piece;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.geometry.Insets;
import javafx.scene.text.Font;

public class ProfileGUI {

    private ChessGUI aChessGUI;
    private boolean aColor;

    private HBox aProfile;
    private HBox aTakenPiecesPane;

    public ProfileGUI(ChessGUI pChessGUI, boolean pColor) {
        aChessGUI = pChessGUI;
        aColor = pColor;
        aProfile = new HBox();
        aProfile.setPadding(new Insets(0,0,0,0));
        aProfile.setAlignment(Pos.CENTER);
        Text aProfileText = new Text();
        if (pColor) {
            aProfileText.setText("White");
        } else {
            aProfileText.setText("Black");
        }
        aTakenPiecesPane = new HBox();
        aTakenPiecesPane.setPadding(new Insets(0,0,0,0));
        aTakenPiecesPane.setAlignment(Pos.CENTER);

        createTakenPiecesPane();
        aProfile.getChildren().addAll(aProfileText, aTakenPiecesPane);
    }

    private void createTakenPiecesPane() {
    }

    public void refreshTakenPieces() {
        aTakenPiecesPane.getChildren().clear();
        if (aColor) {
            for (Piece piece : aChessGUI.getChessModel().getWhitesCaptures()) {
                Text aPieceText = new Text(piece.getName());
                aPieceText.setFont(Font.font(20));
                aTakenPiecesPane.getChildren().add(aPieceText);
            }
        } else {
            for (Piece piece : aChessGUI.getChessModel().getBlacksCaptures()) {
                Text aPieceText = new Text(piece.getName());
                aPieceText.setFont(Font.font(20));
                aTakenPiecesPane.getChildren().add(aPieceText);
            }
        }
    }

    public HBox getView() {
        return aProfile;
    }
}
