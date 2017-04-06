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
        return returnCharacters();
    }

    private String returnCharacters(){
        return this.game.returnCharacters();
    }

    private String returnWord() {
        return this.game.returnWord();
    }

    int returnLives(){
        return this.game.returnLives();
    }

    private boolean isGameInProgress(){
        return returnLives() >= 1;
    }

    boolean isGameWon(){
        return this.game.isGameWon();
    }

    boolean isGameLost(){
        return this.game.isGameLost();
    }

    void playGameLoop(Scanner scanner){
        startGame();
        while (isGameInProgress()){
            playGame(scanner);
            if (isGameWon()){
                printWonGame();
                break;
            }
            if (isGameLost()) {
                printLostGame();
                break;
            }
        }
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

    private void printInstructions(){
        printShowWord();
        printTakeAGuess();
    }

    private void printShowWord(){
        System.out.println("The word is: " + returnCharacters() );
    }

    private void printShowFullWord(){
        System.out.println("The word was: " + returnWord() );
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
        System.out.println("You have " + this.game.returnLives() + " lives remaining.");
    }

}
