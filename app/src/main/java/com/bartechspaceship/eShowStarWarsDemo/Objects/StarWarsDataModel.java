package com.bartechspaceship.eShowStarWarsDemo.Objects;

import com.bartechspaceship.eShowStarWarsDemo.Objects.Character;
import com.bartechspaceship.eShowStarWarsDemo.Objects.CharacterURL;

import java.util.ArrayList;


public class StarWarsDataModel {
    private String mTitle;
    private String mOpening_crawl;
    private String mDirector;
    private String mProducer;
    private String mRelease_date;
    private int mEpisode_id;
    private ArrayList<Character> mCharacters;
    private ArrayList<CharacterURL> mCharacterURLS;


    public StarWarsDataModel(String title, String opening_crawl, String director, String producer, String release_date, int episode_id, ArrayList<Character> characters) {
        mTitle = title;
        mOpening_crawl = opening_crawl;
        mDirector = director;
        mProducer = producer;
        mRelease_date = release_date;
        mEpisode_id = episode_id;
        mCharacters = characters;
    }

    public StarWarsDataModel(String title, String opening_crawl, String director, String producer, String release_date, int episode_id) {
        mTitle = title;
        mOpening_crawl = opening_crawl;
        mDirector = director;
        mProducer = producer;
        mRelease_date = release_date;
        mEpisode_id = episode_id;
    }

    public ArrayList<CharacterURL> getCharacterURLS() {
        return mCharacterURLS;
    }

    public ArrayList<String> getCharacterURLStoString() {
        ArrayList<String> URLs = new ArrayList<>();
        for(CharacterURL characterURL: mCharacterURLS){
            URLs.add(characterURL.getURL());
        }

        return URLs;
    }

    public void setCharacterURLS(ArrayList<CharacterURL> characterURLS) {
        mCharacterURLS = characterURLS;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getOpening_crawl() {
        return mOpening_crawl;
    }

    public String getDirector() {
        return mDirector;
    }

    public String getProducer() {
        return mProducer;
    }

    public String getRelease_date() {
        return mRelease_date;
    }

    public int getEpisode_id() {
        return mEpisode_id;
    }

    public void addCharacter(Character character){
        mCharacters.add(character);
    }

    public ArrayList<Character> getCharacters() {
        return mCharacters;
    }

    public void setCharacters(ArrayList<Character> characters) {
        mCharacters = characters;
    }
}

