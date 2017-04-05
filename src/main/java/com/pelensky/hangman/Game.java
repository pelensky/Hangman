package com.pelensky.hangman;

class Game {

    Word word;
    Lives lives;

    Game(Word word, Lives lives){
        this.word = word;
        this.lives = lives;
    }

    boolean gameWon(){
        return this.word.checkWordMatchesGuesses();
    }

    void guessLetter(char letter){
        this.word.guessLetter(letter);
    }
}
