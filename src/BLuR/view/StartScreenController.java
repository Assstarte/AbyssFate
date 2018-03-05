package BLuR.view;

import BLuR.AbyssFateApp;
import BLuR.model.enums.$GAME_STATE;
import javafx.fxml.FXML;
import javafx.scene.control.Button;



public class StartScreenController {

    private AbyssFateApp mainApp;

    @FXML
    private Button Start;


    @FXML
    private void startGame() {

        mainApp.Game_State = $GAME_STATE.CHARACTER_CREATION_SCREEN;
        mainApp.showCharacterCreationScreen();



    }

    public void setMainApp(AbyssFateApp mainApp) {
        this.mainApp = mainApp;
    }
}
