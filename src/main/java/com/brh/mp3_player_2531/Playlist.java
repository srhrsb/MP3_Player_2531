package com.brh.mp3_player_2531;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private String name;
    private int currentSongNumber;
    private List<File> list;
    
    public Playlist(String name, List<File> list) {
        this.name = name;
        this.list = list;
        this.currentSongNumber = -1;
    }


    public boolean deleteSong( String path ){
        return list.remove(path);
    }

    public String getNext(){

        currentSongNumber = ++currentSongNumber % list.size();

        return list.get(currentSongNumber).getAbsolutePath();

        //        Alternativ:
        //        currentSongNumber++;
        //        if(currentSongNumber > list.size()-1 ){
        //            currentSongNumber =0;
        //        }
        //         return list.get(index);
    }

    //getPreview
    public String getPreview(){
        currentSongNumber--;

        if(currentSongNumber < 0 ){
            currentSongNumber = list.size()-1;
        }

        return list.get(currentSongNumber).getAbsolutePath();
    }

    public int getCurrentSongNumber() {
        return currentSongNumber;
    }

    public String getAtIndex( int number ){
        currentSongNumber = number;
        return list.get(currentSongNumber).getAbsolutePath();
    }
}