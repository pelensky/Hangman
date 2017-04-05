package com.pelensky.hangman;

import java.io.ByteArrayInputStream;
import java.io.PrintStream;

class Hangman {

    private Game game;
    PrintStream output;

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

    private boolean gameInProgress(){
        return showLives() >= 1;
    }


    void gameLoop(){
        welcomeMessage();
        while (gameInProgress()){
            playGame();
        }
    }

    void  playGame(){
        printShowWord();
        printTakeAGuess();
    }

    void welcomeMessage(){
        System.out.println("Welcome to Hangman!");
    }

    private void printShowWord(){
        System.out.println("The word is: " + showCharacters() );
    }

    private void printTakeAGuess(){
        System.out.println("Take a guess!");
    }


}

