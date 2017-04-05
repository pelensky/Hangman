package com.pelensky.hangman;

class Lives {
    int lives;

    Lives(int lives){
        this.lives = lives;
    }

    void reduceLifeCount(){
        this.lives -= 1;
    }

    boolean checkGameLost(){
        return this.lives <= 0;
    }

    int showLives(){
        return this.lives;
    }
}

