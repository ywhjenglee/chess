package ywhjenglee.chess.GUI;

import ywhjenglee.chess.Pieces.Queen;
import ywhjenglee.chess.Pieces.Rook;
import ywhjenglee.chess.Pieces.Bishop;
import ywhjenglee.chess.Pieces.Knight;

import javafx.scene.layout.VBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

public class PromotionController extends VBox {

    private final int y;
    private ChessGUI aChessGUI;
    private Text aPieceText;

    private BackgroundFill gray = new BackgroundFill(Color.rgb(128, 128, 128, 1.0), new CornerRadii(0), new Insets(0));

    public PromotionController(ChessGUI pChessGUI, int pY) {
        y = pY;
        aChessGUI = pChessGUI;
        aPieceText = new Text();
        aPieceText.setFont(Font.font(40));
        switch (y) {
            case 7:
                aPieceText.setText("♕");
                break;
            case 6:
                aPieceText.setText("♖");
                break;
            case 5:
                aPieceText.setText("♗");
                break;
            case 4:
                aPieceText.setText("♘");
                break;
            case 3:
                aPieceText.setText("♞");
                break;
            case 2:
                aPieceText.setText("♝");
                break;
            case 1:
                aPieceText.setText("♜");
                break;
            case 0:
                aPieceText.setText("♕");
                break;
        }
        setBackground(new Background(gray));
        setAlignment(Pos.CENTER);
        createHandle();
        getChildren().add(aPieceText);
    }

    private void createHandle() {
        setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent pEvent) {
                switch (y) {
                    case 7:
                        aChessGUI.getChessModel().setPiecePromoteTo(new Queen(true, 0, 0));
                        break;
                    case 6:
                        aChessGUI.getChessModel().setPiecePromoteTo(new Rook(true, 0, 0, false));
                        break;
                    case 5:
                        aChessGUI.getChessModel().setPiecePromoteTo(new Bishop(true, 0, 0));
                        break;
                    case 4:
                        aChessGUI.getChessModel().setPiecePromoteTo(new Knight(true, 0, 0));
                        break;
                    case 3:
                        aChessGUI.getChessModel().setPiecePromoteTo(new Knight(false, 0, 0));
                        break;
                    case 2:
                        aChessGUI.getChessModel().setPiecePromoteTo(new Bishop(false, 0, 0));
                        break;
                    case 1:
                        aChessGUI.getChessModel().setPiecePromoteTo(new Rook(false, 0, 0, false));
                        break;
                    case 0:
                        aChessGUI.getChessModel().setPiecePromoteTo(new Queen(false, 0, 0));
                        break;
                }
                aChessGUI.getBoardGUI().closePromotionPane();
                aChessGUI.getBoardGUI().refreshView();
                if (aChessGUI.getChessModel().getResult() != "Game Ongoing") {
                    aChessGUI.showGameOver();
                }
            }
        });
    }
}
