package com.brh.mp3_player_2531;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class Controller {

    public final Music music = new Music();

    @FXML
    private Label pathText;

    @FXML
    private Slider volumeSlider;


    @FXML
    protected void search() {
        System.out.println("Suchen");

        Stage stage = (Stage) pathText.getScene().getWindow();

        FileChooser file = new FileChooser();

        File selectedFile = file.showOpenDialog( stage );

        pathText.setText( selectedFile.getAbsolutePath() );

    }

    @FXML
    protected void play() {
        System.out.println("Play");
        music.play( pathText.getText() );
    }

    @FXML
    protected void stop() {
        System.out.println("Stop");
        music.stop();
    }

    @FXML
    protected void pause() {
        System.out.println("Pause");
        music.pause();
    }

    @FXML
    protected void mute() {
        System.out.println("Mute");
        music.pause();
    }


    @FXML
    protected void setVolume( ){
        double volume = volumeSlider.getValue();
        music.setVolume( volume );

    }
}