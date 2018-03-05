package BLuR;
import BLuR.model.entities.Hero;
import BLuR.model.enums.$CLASS;
import BLuR.model.enums.$GAME_STATE;
import BLuR.model.enums.$GENDER;
import BLuR.model.enums.$RACE;
import BLuR.view.CharacterCreationScreenController;
import BLuR.view.StartScreenController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

import static java.lang.Thread.sleep;

public class AbyssFateApp extends Application {

    private Stage primaryStage; //Основная сцена
    private BorderPane rootLayout; //Корневой макет

    public $GAME_STATE Game_State;


    private Hero _HERO; //Главный персонаж, TODO: Не стоит использовать его напрямую из главного класса


    public AbyssFateApp(){
        Hero testHero = new Hero("Max", $RACE.ELF, $CLASS.WARRIOR, $GENDER.MALE);

    }


    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("view/GameScreen.fxml"));

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("AbyssFate");
        this.primaryStage.setMinWidth(1600);
        this.primaryStage.setMinHeight(900);

        initRootLayout(); //Инициализируем корневой макет

        showStartScreen();

        //Играем саундтрек

        /*String musicFile = "music/Soundtrack.mp3";     // For example
        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();*/



        }

        //showGameScreen(); //Закидываем и отображаем игровой экран в корневой макет
        //primaryStage.show();



    public void initRootLayout(){
        try{
            //Загружаем корневой макет из FXML файла
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(AbyssFateApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Отображаем сцену, содержащую корневой макет.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            primaryStage.show();

            primaryStage.setFullScreen(true);

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public void showGameScreen(){
        try {
            // Загружаем сведения об адресатах.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(AbyssFateApp.class.getResource("view/GameScreen.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();


            // Помещаем сведения об адресатах в центр корневого макета.
            rootLayout.setCenter(personOverview);
        } catch (IOException e) {
            e.printStackTrace();
        }



        //TEST ALERT
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.initOwner(getPrimaryStage());
        alert.setTitle("Test Information");
        alert.setHeaderText("Character Values");
        alert.setContentText("Name: " + _HERO.getName() + "\nRace: " + _HERO.getRace().toString() + "\nGender: " + _HERO.getGender().toString() + "\nClass: " + _HERO.getHeroClass().toString() );

        alert.showAndWait();
    }


    public void showStartScreen(){

        try {
            // Загружаем сведения об адресатах.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(AbyssFateApp.class.getResource("view/StartScreen.fxml"));
            AnchorPane startScreen = (AnchorPane) loader.load();

            // Даём контроллеру доступ к главному приложению.
            StartScreenController controller = loader.getController();
            controller.setMainApp(this);

            rootLayout.setCenter(startScreen);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showCharacterCreationScreen(){
        try {
            // Загружаем сведения об адресатах.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(AbyssFateApp.class.getResource("view/CharacterCreationScreen.fxml"));
            AnchorPane characterCreationScreen = (AnchorPane) loader.load();

            // Даём контроллеру доступ к главному приложению.
            CharacterCreationScreenController controller = loader.getController();
            controller.setMainApp(this);

            rootLayout.setCenter(characterCreationScreen);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Метод получения героя из других классов
    public void setHero(Hero h){
        _HERO = h;

    }



    /**
     * Возвращает главную сцену.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
