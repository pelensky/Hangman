package com.pelensky.hangman;

class Lives {
    int lives;

    Lives(int lives){
        this.lives = lives;
    }

    void reduceLifeCount(){
        this.lives -= 1;
    }

    boolean hasNoLivesLeft(){
        return this.lives <= 0;
    }

    int returnLives(){
        return this.lives;
    }
}

