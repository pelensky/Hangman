package com.pelensky.hangman;

class Hangman {

    private Game game;
    Boolean running;
    int cycles;

    Hangman(Game game){
        this.game = game;
        this.running = false;
        this.cycles = 0;
    }

    void startGame(){
        this.running = true;
        this.cycles ++;
    }


}

