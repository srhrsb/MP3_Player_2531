package com.brh.mp3_player_2531;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class Music {

    private static MediaPlayer player;
    private boolean isMuted;

    public void play( String file){
         Media media = new Media( new File(file).toURI().toString() );

         if(player != null){
             player.stop();
         }

         player = new MediaPlayer( media );
         player.stop();
         player.play();
    }

    public void pause(){
        if(player == null) return;
        player.stop();

    }

    public void mute(){
        if(player == null) return;
        isMuted = !isMuted;
        player.setMute(isMuted);
    }

    public void stop(){
        if(player == null) return;
        player.stop();
    }

    public void setVolume( double value ){
        if(player == null) return;
        player.setVolume(value);
    }










}
