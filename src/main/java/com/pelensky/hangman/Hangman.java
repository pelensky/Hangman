package com.pelensky.hangman;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

class Hangman {

    private Game game;
    Scanner scanner;


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
        return this.game.gameWon();
    }

    boolean gameLost(){
        return this.game.gameLost();
    }

    void gameLoop(Scanner scanner){
        startGame();
        welcomeMessage();
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

    void printInstructions(){
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

    private void printNumberOfLives(){
        System.out.println("You have " + this.game.showLives() + " lives remaining.");
    }

    public static void main(String[] args){
        Word word = new Word("Hello");
        Lives lives = new Lives(5);
        Game game = new Game(word, lives);
        Hangman hangman = new Hangman(game);
        Scanner scanner = new Scanner(System.in);
        hangman.gameLoop(scanner);
    }



}

