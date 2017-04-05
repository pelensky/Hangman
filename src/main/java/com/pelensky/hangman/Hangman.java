package com.pelensky.hangman;

import java.io.InputStream;

class Hangman {

    private Game game;
    Boolean running;
    int cycles;
    InputStream input;

    Hangman(Game game){
        this.game = game;
        this.running = false;
        this.cycles = 0;
    }

    void startGame(){
        this.running = true;
        this.cycles ++;
    }

//    boolean takeGuess(InputStream input){
//        return true;
//    }



}

