package ywhjenglee.chess.GUI;

import ywhjenglee.chess.ChessGame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.Priority;

public class ChessGUI extends Application {

	private ChessGame aChessGame;

	private static GridPane aMainPane;
	private static GridPane aGamePane;
	private static GridPane aMenuPane;

	public static void main(String[] pArgs) {
		launch(pArgs);
	}

	@Override
	public void start(Stage pStage){
		// Create game
		aChessGame = new ChessGame();

		// Initialize layouts
		aMainPane = new GridPane();
		aGamePane = new GridPane();
		aMenuPane = new GridPane();

		// Setup GUI
		setupMainPane();
		setupGamePane();
	
		// Set scene and show
		Scene aScene = new Scene(aMainPane);
		pStage.setScene(aScene);
		pStage.show();
	}

	private void setupMainPane() {
		// Set column constraints for aMainPane
		ColumnConstraints gameConstraints = new ColumnConstraints();
		gameConstraints.setPercentWidth(60);
		ColumnConstraints menuConstraints = new ColumnConstraints();
		menuConstraints.setPercentWidth(40);
		aMainPane.getColumnConstraints().addAll(gameConstraints, menuConstraints);

		// Set row constraints for aMainPane
		RowConstraints aRowConstraints = new RowConstraints();
		aRowConstraints.setVgrow(Priority.ALWAYS);
		aMainPane.getRowConstraints().add(aRowConstraints);

		// Set nodes in aMainPane
		aMainPane.add(aGamePane, 0, 0);
		aMainPane.add(aMenuPane, 1, 0);
	}

	private void setupGamePane() {
		// Set column constraints for aGamePane
		ColumnConstraints aColumnConstraints = new ColumnConstraints();
		aColumnConstraints.setHgrow(Priority.ALWAYS);
		aGamePane.getColumnConstraints().add(aColumnConstraints);

		// Set row constraints for aGamePane
		RowConstraints profileConstraints = new RowConstraints();
		profileConstraints.setPercentHeight(10);
		RowConstraints boardConstraints = new RowConstraints();
		boardConstraints.setPercentHeight(80);
		aGamePane.getRowConstraints().addAll(profileConstraints, boardConstraints, profileConstraints);

		// Set nodes in aGamePane
		aGamePane.add(createProfile(), 0, 0);
		aGamePane.add(createBoard(), 0, 1);
		aGamePane.add(createProfile(), 0, 2);
	}

	private StackPane createBoard() {
		BoardGUI aBoardGUI = new BoardGUI(aChessGame);
		return aBoardGUI.getView();
	}

	private HBox createProfile() {
		ProfileGUI aProfileGUI = new ProfileGUI();
		return aProfileGUI.getView();
	}
}
