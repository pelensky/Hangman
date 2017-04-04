package com.pelensky.hangman;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class GameTest {
    private Game game;
    private Word word;
    private Lives lives;

    @Before
    public void setUp(){
    word = new Word("Hello");
    lives = new Lives(5);
    game = new Game(word, lives);
    }

    @Test
    public void takesAWordObject(){
        Assert.assertEquals(word, game.word);
    }

    @Test
    public void takesANumberOfLives(){
        Assert.assertEquals(lives, game.lives);
    }




}
