package com.brh.mp3_player_2531;

import java.io.File;
import java.util.List;

public class Playlist {
    private String name;
    /**
     * aktuell abgespielte Songnummer beginnend bei -1
     */
    private int currentSongNumber;

    /**
     * Liste der Files
     */
    private List<File> list;

    /**
     * Konstruktor - Erstellen einer neuen Playlist
     * @param name Name der Playlist
     * @param list Liste von File-Objekten
     */
    public Playlist(String name, List<File> list) {
        this.name = name;
        this.list = list;
        this.currentSongNumber = -1;

    }

    /**
     * Löscht den Song mit dem gegebenen Pfad
     * @param path - Pfad des Songs
     * @return Erfolgskontrolle
     */
    public boolean deleteSong( String path ){
        return list.remove(path);
    }

    /**
     * Holt die URL des nächsten Songs und erhöht die Songnummer
     * entsprechend, Songnummer wird automatisch auf 0 gesetzt
     * wenn Listenende erreicht und gibt somit den ersten Song zurück
     * @return
     */
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

    /**
     * Gibt den vorherigen Titel zurück, wenn Anfang überschritten,
     * wird der letzte Titel der letzte zurück gegeben
     * @return
     */
    public String getReview(){
        currentSongNumber--;

        if(currentSongNumber < 0 ){
            currentSongNumber = list.size()-1;
        }

        return list.get(currentSongNumber).getAbsolutePath();
    }

    /**
     * Gibt aktuelle Songnummer zurück
     * @return
     */
    public int getCurrentSongNumber() {
        return currentSongNumber;
    }


    /**
     * Gibt den Pfad mit der gegebenen Nummer zurück und aktualisiert
     * die Songnummer
     * @param number
     * @return
     */
    public String getAtIndex( int number ){
        currentSongNumber = number;
        return list.get(currentSongNumber).getAbsolutePath();
    }
}