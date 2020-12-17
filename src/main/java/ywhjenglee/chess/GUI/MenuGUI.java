package ywhjenglee.chess.GUI;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class MenuGUI extends VBox {

    private ChessGUI aChessGUI;

    private HBox aTabsPane;
    private VBox aGameMenuPane;
    private VBox aSettingMenuPane;

    private BackgroundFill gray = new BackgroundFill(Color.rgb(128, 128, 128, 1.0), new CornerRadii(5), new Insets(0));
    private BackgroundFill tabs = new BackgroundFill(Color.rgb(128, 128, 128, 1.0), new CornerRadii(5, 5, 0, 0, false), new Insets(0));

    public MenuGUI(ChessGUI pChessGUI) {
        aChessGUI = pChessGUI;

        aGameMenuPane = new VBox();
        aSettingMenuPane = new VBox();

        createTabs();
        createGameMenu();
        createSettingsMenu();

        setPadding(new Insets(25));
        setAlignment(Pos.CENTER);
        getChildren().addAll(aTabsPane, aGameMenuPane);
    }

    private void createTabs() {
        aTabsPane = new HBox();
        aTabsPane.setSpacing(50);
        aTabsPane.setAlignment(Pos.CENTER);
        Label gameLabel = new Label("Game");
        gameLabel.setBackground(new Background(tabs));
        gameLabel.setPadding(new Insets(10, 25, 10, 25));
        Label settingsLabel = new Label("Settings");
        settingsLabel.setBackground(new Background(tabs));
        settingsLabel.setPadding(new Insets(10, 25, 10, 25));
        gameLabel.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent pEvent) {
                getChildren().clear();
                getChildren().addAll(aTabsPane, aGameMenuPane);
            }
        });
        settingsLabel.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent pEvent) {
                getChildren().clear();
                getChildren().addAll(aTabsPane, aSettingMenuPane);
            }
        });
        aTabsPane.getChildren().addAll(gameLabel, settingsLabel);
    }

    private void createGameMenu() {
        aGameMenuPane.setAlignment(Pos.CENTER);
        aGameMenuPane.setPadding(new Insets(25));
        aGameMenuPane.setBackground(new Background(gray));
        Button newGameButton = new Button("New Game");
        newGameButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent pEvent) {
                aChessGUI.showNewGame();
            }
        });

        aGameMenuPane.getChildren().add(newGameButton);
    }

    private void createSettingsMenu() {
        aSettingMenuPane.setAlignment(Pos.CENTER);
        aSettingMenuPane.setPadding(new Insets(25));
        aSettingMenuPane.setBackground(new Background(gray));
        GridPane settingsPane = new GridPane();
        Label darkTileLabel = new Label("Dark Tiles Color");
        Label lightTileLabel = new Label("Light Tiles Color");
        Label menuLabel = new Label("Menu Color");
        Label backgroundLabel = new Label("Background Color");
        settingsPane.add(darkTileLabel, 0, 0);
        settingsPane.add(lightTileLabel, 0, 1);
        settingsPane.add(menuLabel, 0, 2);
        settingsPane.add(backgroundLabel, 0, 3);

        Button refreshButton = new Button("Refresh");
        refreshButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent pEvent) {
            }
        });

        aSettingMenuPane.getChildren().addAll(settingsPane, refreshButton);
    }
}
