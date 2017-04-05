package com.pelensky.hangman;

import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.util.Scanner;

class Hangman {

    private Game game;

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

    boolean gameWon(){
        printWonGame();
        return this.game.gameWon();
    }

    boolean gameLost(){
        printLostGame();
        return this.game.gameLost();
    }

    void gameLoop(){
        welcomeMessage();
        while (gameInProgress()){
            playGame();
            if (gameWon()){
                printWonGame();
                break;
            } else if (gameLost()) {
                printLostGame();
                break;
            }
        }
    }

    void printInstructions(){
        printShowWord();
        printTakeAGuess();
    }

    private void getUserInput(){
        Scanner scanner = new Scanner(System.in);
        String guess = scanner.next();
        ByteArrayInputStream input = new ByteArrayInputStream(guess.getBytes());
        takeGuess(input);
    }

    private void playGame() {
        printInstructions();
        getUserInput();
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

    private void printWonGame(){
        printShowWord();
        System.out.println("You won!");
    }

    private void printLostGame(){
        printShowWord();
        System.out.println("You lost");
    }



}

