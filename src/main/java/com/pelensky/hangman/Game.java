package com.pelensky.hangman;

import sun.plugin2.main.client.LiveConnectSupport;

class Game {

    Word word;
    Lives lives;

    Game(Word word, Lives lives){
        this.word = word;
        this.lives = lives;
    }
}
