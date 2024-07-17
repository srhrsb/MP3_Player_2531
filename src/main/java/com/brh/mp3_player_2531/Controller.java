package com.brh.mp3_player_2531;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class Controller {

    public final Music music = new Music();

    @FXML
    private Label pathText;

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
    }

    @FXML
    protected void pause() {
        System.out.println("Pause");
    }

    @FXML
    protected void mute() {
        System.out.println("Mute");
    }

}