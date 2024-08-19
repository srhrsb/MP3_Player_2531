package com.brh.mp3_player_2531;

import java.util.ArrayList;

public class Playlist {

    private String name;
    private int currentSongNumber;
    private ArrayList<String> list;


    public Playlist(String name, ArrayList<String> list) {
        this.name = name;
        this.list = list;
        this.currentSongNumber = 0;
    }

    public boolean addSong( String path ){
        if( !path.isEmpty() && path.endsWith(".mp3")) {
           return list.add(path);
        }
        return false;
    }

    public boolean deleteSong( String path ){
        return list.remove(path);
    }

    public String getNext(){

        int index = ++currentSongNumber % list.size()-1;
        return list.get(index);

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

        return list.get(currentSongNumber);
    }
}