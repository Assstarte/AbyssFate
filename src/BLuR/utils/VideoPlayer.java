package BLuR.utils;

import BLuR.view.GameScreenController;
import javafx.fxml.FXML;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

public class VideoPlayer {
    MediaPlayer playerReverse = new MediaPlayer(new Media(getClass().getResource("../../resources/video/reverse-bg.mp4").toExternalForm()));
    private MediaPlayer player;


        public void play(MediaView mw, String fileName){
            mw.setPreserveRatio(false);
            mw.setFitWidth(1269);
            mw.setFitHeight(734);
            mw.toBack();
            player = new MediaPlayer( new Media(getClass().getResource("../../resources/video/"+fileName).toExternalForm()));
            mw.setMediaPlayer(player);
            player.play();
        }

        public void playSet(MediaView mw,String fileName){
            int counter = 0;

                play(mw,fileName);
                mw.setPreserveRatio(false);
                mw.setFitWidth(1269);
                mw.setFitHeight(734);
                mw.toBack();

                mw.setMediaPlayer(playerReverse);
                playerReverse.play();
                counter++;
        }

        public void pause(){
            player.pause();
            player.seek(Duration.seconds(40));
            player.play();
    }


}
