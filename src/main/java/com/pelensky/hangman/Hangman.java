package com.pelensky.hangman;

import java.util.Scanner;

class Hangman {

    public static void main(String[] args){
        Game game = new Game(new Word(), new Lives(5));
        GameLoop gameLoop = new GameLoop(game);
        gameLoop.playGameLoop(new Scanner(System.in));
    }

}

