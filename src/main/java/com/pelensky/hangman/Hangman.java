package com.pelensky.hangman;

import sun.misc.IOUtils;

import java.io.ByteArrayInputStream;

class Hangman {

    private Game game;
    ByteArrayInputStream input;

    Hangman(Game game){
        this.game = game;
    }

    void startGame(){
        this.game.newGame();
    }

    String takeGuess(ByteArrayInputStream input){
        char letter = (char)input.read();
        this.game.guessLetter(letter);
        return showCharacters();
    }

    private String showCharacters(){
        return this.game.showCharacters();
    }

    int showLives(){
        return this.game.showLives();
    }



}

