package com.pelensky.hangman;

class Lives {
    int lives;

    Lives(int lives){
        this.lives = lives;
    }

    void reduceLifeCount(){
        this.lives -= 1;
    }
}
