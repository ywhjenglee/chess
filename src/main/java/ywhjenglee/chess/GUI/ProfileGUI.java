package ywhjenglee.chess.GUI;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class ProfileGUI {

    private HBox aProfile;

    public ProfileGUI() {
        aProfile = new HBox();
        aProfile.setAlignment(Pos.CENTER);
        aProfile.getChildren().add(new Text("Yo"));
    }

    public HBox getView() {
        return aProfile;
    }
}
