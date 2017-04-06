package com.pelensky.hangman;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

class GameLoop {

    private Game game;

    GameLoop(Game game){
        this.game = game;
    }

    void startGame(){
        this.game.newGame();
        printWelcomeMessage();
    }

    String takeGuess(ByteArrayInputStream input){
        char letter = (char)input.read();
        this.game.guessLetter(letter);
        return showCharacters();
    }

    private String showCharacters(){
        return this.game.showCharacters();
    }

    private String showWord() {
        return this.game.showWord();
    }
    int showLives(){
        return this.game.showLives();
    }

    private boolean gameInProgress(){
        return showLives() >= 1;
    }

    boolean gameWon(){
        return this.game.gameWon();
    }

    boolean gameLost(){
        return this.game.gameLost();
    }

    void playGameLoop(Scanner scanner){
        startGame();
        while (gameInProgress()){
            playGame(scanner);
            if (gameWon()){
                printWonGame();
                break;
            }
            if (gameLost()) {
                printLostGame();
                break;
            }
        }
    }

    private void printInstructions(){
        printShowWord();
        printTakeAGuess();
    }

    private void getUserInput(Scanner scanner){
        String guess = scanner.next();
        ByteArrayInputStream input = new ByteArrayInputStream(guess.getBytes());
        takeGuess(input);
    }

    private void playGame(Scanner scanner) {
        printInstructions();
        getUserInput(scanner);
        printNumberOfLives();
    }

    private void printWelcomeMessage(){
        System.out.println("Welcome to Hangman!");
    }

    private void printShowWord(){
        System.out.println("The word is: " + showCharacters() );
    }

    private void printShowFullWord(){
        System.out.println("The word was: " + showWord() );
    }

    private void printTakeAGuess(){
        System.out.println("Take a guess!");
    }

    private void printWonGame(){
        printShowFullWord();
        System.out.println("You won!");
    }

    private void printLostGame(){
        printShowFullWord();
        System.out.println("You lost");
    }

    private void printNumberOfLives(){
        System.out.println("You have " + this.game.showLives() + " lives remaining.");
    }

}
