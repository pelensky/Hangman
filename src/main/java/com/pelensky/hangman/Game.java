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

    boolean isGameWon(){
        return this.word.doesWordMatchGuesses();
    }

    boolean isGameLost(){
        return this.lives.hasNoLivesLeft();
    }

    void guessLetter(char letter){
        if (!this.word.isGuessCorrect(letter)){
            this.lives.reduceLifeCount();
        }
    }

    String returnCharacters(){
        return this.word.returnCharacters();
    }

    String returnWord() {
        return this.word.returnWord();
    }

    int returnLives(){
        return this.lives.returnLives();
    }
}
