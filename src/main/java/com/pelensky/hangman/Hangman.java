package com.pelensky.hangman;

import java.io.ByteArrayInputStream;

class Hangman {

    private Game game;
    Boolean running;
    int cycles;
    ByteArrayInputStream input;

    Hangman(Game game){
        this.game = game;
        this.running = false;
        this.cycles = 0;
    }

    void startGame(){
        this.running = true;
        this.cycles ++;
    }

    boolean takeGuess(ByteArrayInputStream input){
        return true;
    }



}

