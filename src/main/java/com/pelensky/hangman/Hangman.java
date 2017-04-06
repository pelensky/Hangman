package com.pelensky.hangman;

import java.util.Scanner;

class Hangman {

    public static void main(String[] args){
        Word word = new Word();
        Lives lives = new Lives(5);
        Game game = new Game(word, lives);
        GameLoop gameLoop = new GameLoop(game);
        Scanner scanner = new Scanner(System.in);
        gameLoop.playGameLoop(scanner);
    }

}

