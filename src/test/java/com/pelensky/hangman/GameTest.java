package com.pelensky.hangman;

import org.junit.Assert;
import org.junit.Test;


public class GameTest {
    private Game game;
    String word;
    int lives;

    @Test
    public void takesAWord(){
        game = new Game("Hello", 5);
        Assert.assertEquals("Hello", game.word);
    }

    @Test
    public void takesANumberOfLives(){
        game = new Game("Hello", 5);
        Assert.assertEquals(5, game.lives);
    }
}
