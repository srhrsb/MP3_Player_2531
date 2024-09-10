package com.brh.mp3_player_2531;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    public final Music music = new Music();
    @FXML
    private ListView playlistView;
    @FXML
    private Slider volumeSlider;

    private Playlist playList;

    /**
     * Durchsucht einen Ordner bzw. Dialog und zeigt die entsprechenden Titel im
     * listView an
     */
    @FXML
    protected void search() {
        System.out.println("Suchen");
        Stage stage = (Stage) playlistView.getScene().getWindow();
        FileChooser file = new FileChooser();
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Music", "*.mp3","*.wav");
        file.getExtensionFilters().add(filter);
        List<File> selectedFiles = file.showOpenMultipleDialog( stage );

        //files in Konsole ausgeben 3 Möglichkeiten:
        for( var f : selectedFiles){
            System.out.println(f.getPath());
        }

        for( int i = 0; i < selectedFiles.size(); i++){
            System.out.println( selectedFiles.get(i).getAbsolutePath());
        }

        selectedFiles.forEach(System.out::println);

        //listview mit pfaden füllen
        for( var f : selectedFiles){
           playlistView.getItems().add( f.getName());
        }

        playList = new Playlist("Playlist 1", selectedFiles);

    }

    @FXML
    protected void selectionClicked() {

       int index = playlistView.getFocusModel().getFocusedIndex();
       String path =  playList.getAtIndex( index );

       if(!path.isEmpty()){
            setFocus( playList.getCurrentSongNumber() );
            System.out.println("Play: " + path);
            music.play(path, this::onMusicEnd);
       }
    }

    @FXML
    protected void play() {

        String path = playList.getNext();

        if(!path.isEmpty()){
            setFocus( playList.getCurrentSongNumber() );
            System.out.println("Play: " + path);
            music.play(path, this::onMusicEnd);
        }
    }

    public void onMusicEnd( int lastSongNumber ){
        System.out.println("last song:" + lastSongNumber);
        play();
    }

    private void setFocus( int number ){
        System.out.println("selected: "+number);
        playlistView.getSelectionModel().select(number);
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