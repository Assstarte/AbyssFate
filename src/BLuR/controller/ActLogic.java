package BLuR.controller;

import BLuR.view.GameScreenController;

public class ActLogic {
    private static GameScreenController controller;



    public static void setController(GameScreenController c){
        controller = c;
    }

    public static GameScreenController getController(){
        return controller;
    }

}
