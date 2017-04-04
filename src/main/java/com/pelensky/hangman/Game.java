package com.pelensky.hangman;

class Game {

    Word word;
    Lives lives;

    Game(Word word, Lives lives){
        this.word = word;
        this.lives = lives;
    }
}
