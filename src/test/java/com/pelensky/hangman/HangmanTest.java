package com.pelensky.hangman;

import org.junit.Before;

public class HangmanTest {
    private Hangman hangman;
    private Game game;
    private Word word;
    private Lives lives;

    @Before
    public void setUp(){
        word = new Word("Hello");
        lives = new Lives(5);
        game = new Game(word, lives);
        hangman = new Hangman(game);
    }




}
