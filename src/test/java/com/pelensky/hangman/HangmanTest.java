package com.pelensky.hangman;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

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
        hangman.startGame();
    }

    @Test
    public void returnsWordForRightLetter(){
        ByteArrayInputStream input = new ByteArrayInputStream("h\n".getBytes());
        Assert.assertEquals("H____", hangman.takeGuess(input));
    }

    @Test
    public void returnsFalseForWrongLetter(){
        ByteArrayInputStream input = new ByteArrayInputStream("a\n".getBytes());
        Assert.assertEquals("_____", hangman.takeGuess(input));
    }






}
