package BLuR.view;

import BLuR.AbyssFateApp;
import BLuR.controller.Act1;
import BLuR.controller.ActLogic;
import BLuR.model.entities.Hero;
import BLuR.model.enums.$COLOR;
import BLuR.utils.AudioPlayer;
import BLuR.utils.DelayedPrinter;
import BLuR.utils.VideoPlayer;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.util.Duration;
import org.fxmisc.richtext.StyledTextArea;

public class GameScreenController {

    @FXML
    private Hero MainHero;


    @FXML
    private Label HP_Value;

    @FXML
    private Label MP_Value;

    @FXML
    private Label LV_Value;

    @FXML
    private Button Button_4;

    @FXML
    private TextFlow Act_Screen;

    @FXML
    private AnchorPane Inventory;

    @FXML
    private MediaView BGVideo;

    private AbyssFateApp gameApp;

    private Act1 act1;

    private VideoPlayer VID_PLAYER = new VideoPlayer();

    private AudioPlayer AUD_PLAYER = new AudioPlayer();

    private DelayedPrinter printer = new DelayedPrinter();

    private StyledTextArea<String, TextFlow> styledTextArea;

    @FXML
    private TextFlow flow = new TextFlow();



    /**
     * Конструктор.
     * Конструктор вызывается раньше метода initialize().
     */
    public GameScreenController() {
        act1 = new Act1();

    }

    /**
     * Инициализация класса-контроллера. Этот метод вызывается автоматически
     * после того, как fxml-файл будет загружен.
     */
    @FXML
    private void initialize() {
        HP_Value.setText("100");
        MP_Value.setText("0");
        LV_Value.setText("1");


        //TEST
        String log = ">> Sample Passed\n";
        String log2 = ">> Sample 2 Passed(BLUE)\n";
        Text t1 = new Text();
        Text t2 = new Text();
        t1.setStyle("-fx-fill:RED;");
        t1.setText(log);
        t2.setStyle("-fx-fill:BLUE;");
        t2.setText(log2);
        flow.getChildren().add(t1);
        flow.getChildren().add(t2);



        //LOADING FONTS
        Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Pacifico-Regular.ttf"), 14);
        Font.loadFont(getClass().getResourceAsStream("/resources/fonts/PermanentMarker-Regular.ttf"), 14);
        Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Gabriela-Regular.ttf"), 14);
        Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Marmelad-Regular.ttf"), 14);

        //LOADING VIDEO
        BGVideo.setPreserveRatio(false);
        BGVideo.setFitWidth(1269);
        BGVideo.setFitHeight(734);
        BGVideo.toBack();
//        MediaPlayer player = new MediaPlayer( new Media(getClass().getResource("../../resources/video/into-bg.mp4").toExternalForm()));
//        BGVideo.setMediaPlayer(player);
//        player.play();

        VID_PLAYER.play(BGVideo,"into-bg.mp4");
        playBackground();
        AUD_PLAYER.play("soundtrack.mp3");
        playBackgroundSoundtrack();


        ActLogic.setController(this);
    }

    @FXML
    private void execute_4() {
            //printer.printStage(Act_Screen,"Something is rly about something");

            //printer.addToStage(Act_Screen, "DO NOT STAND AGAINST US - SAID TOM");

            //printer.printStage(Act_Screen, act1.getActScene(4) );
            //printer.addToStage(Act_Screen, act1.getActScene(4));
        deactivateButton4();
        act1.getActScene(4);
        //TEST
//        if(act1.printFinished) activateButton4();
    }










        public void editButton4(String b){
            Button_4.setText(b);
    }

    public void activateButton4(){
            Button_4.setDisable(false);
            Button_4.setVisible(true);
    }

    public void deactivateButton4(){
        Button_4.setDisable(true);
        Button_4.setVisible(false);
    }

    public void printActText(String t, $COLOR clr){
        printer.printText(Act_Screen,t,clr);
    }

    public void addActText(String t, $COLOR clr){
        printer.addText(Act_Screen,t,clr);
    }

    public void handleInventory(){
        //Load images of acquired items
        //......

        //Perform open animation
        FadeTransition ft = new FadeTransition();
        ft.setNode(Inventory);
        ft.setDuration(new Duration(2000));
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);

        ft.play();

    }

    public void closeInventory(){

        FadeTransition ft = new FadeTransition();
        ft.setNode(Inventory);
        ft.setDuration(new Duration(2000));
        ft.setFromValue(1);
        ft.setToValue(0);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);

        ft.play();

    }

    private void playBackground(){
        final IntegerProperty state = new SimpleIntegerProperty(1);
        Timeline timeline = new Timeline(
                new KeyFrame(
                        Duration.seconds(44),
                        event -> {
                            if(state.get() == 0){
                                VID_PLAYER.pause();
                                VID_PLAYER.play(BGVideo,"into-bg.mp4");
                                state.set(1);
                            }
                            if(state.get() == 1){
                                VID_PLAYER.pause();
                                VID_PLAYER.play(BGVideo,"reverse-bg.mp4");
                                state.set(0);
                            }

                        }
                )
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }


    private void playBackgroundSoundtrack(){
        Timeline timeline = new Timeline(
                new KeyFrame(
                        Duration.seconds(115),
                        event -> {

                                AUD_PLAYER.play("soundtrack.mp3");

                        }
                )
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void cls(){
        flow.getChildren().clear();
    }

    public DelayedPrinter getPrinter(){
        return printer;
    }





}









