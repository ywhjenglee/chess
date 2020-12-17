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

    private BackgroundFill gray = new BackgroundFill(Color.rgb(128, 128, 128, 1.0), new CornerRadii(0), new Insets(0));

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
        aTabsPane.setSpacing(30);
        aTabsPane.setAlignment(Pos.CENTER);
        Label gameLabel = new Label("Game");
        gameLabel.setBackground(new Background(gray));
        Label settingsLabel = new Label("Settings");
        settingsLabel.setBackground(new Background(gray));
        gameLabel.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent pEvent) {
            }
        });
        settingsLabel.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent pEvent) {
            }
        });
        aTabsPane.getChildren().addAll(gameLabel, settingsLabel);
    }

    private void createGameMenu() {

    }

    private void createSettingsMenu() {
        aSettingMenuPane.setAlignment(Pos.CENTER);
        GridPane settingsPane = new GridPane();
        Label darkTileLabel = new Label("Dark Tiles Color");
        Label lightTileLabel = new Label("Light Tiles Color");
        Label menuLabel = new Label("Menu Color");
        Label backgroundLabel = new Label("Background Color");
        settingsPane.add(darkTileLabel, 0, 0);
        settingsPane.add(lightTileLabel, 0, 1);

        Button refreshButton = new Button("Refresh");
        refreshButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent pEvent) {
            }
        });

        aSettingMenuPane.getChildren().addAll(settingsPane, refreshButton);
    }
}
