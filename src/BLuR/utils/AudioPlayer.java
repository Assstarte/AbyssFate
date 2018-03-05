package BLuR.utils;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class AudioPlayer {
    private MediaPlayer player;

    public void play(String fileName){
        //String musicFile = "src/resources/audio/" + fileName;
        Media sound = new Media(getClass().getResource("../../resources/audio/"+fileName).toExternalForm());
        player = new MediaPlayer(sound);
        player.play();
    }
}
