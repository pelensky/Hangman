package com.pelensky.hangman;

class Game {

    Word word;
    Lives lives;

    Game(Word word, Lives lives){
        this.word = word;
        this.lives = lives;
    }

    void newGame(){
        this.word.setUnderscoresForCharacters();
    }

    boolean gameWon(){
        return this.word.checkWordMatchesGuesses();
    }

    boolean gameLost(){
        return this.lives.checkGameLost();
    }

    void guessLetter(char letter){
        if (!this.word.guessLetter(letter)){
            this.lives.reduceLifeCount();
        }
    }

    String showCharacters(){
        return this.word.showCharacters();
    }

    int showLives(){
        return this.lives.showLives();
    }
}
