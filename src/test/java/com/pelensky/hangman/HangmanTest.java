package com.pelensky.hangman;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sun.misc.IOUtils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

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

    @Test
    public void doesNothingBeforeItHasBeenStarted(){
        Assert.assertFalse(hangman.running);
    }

    @Test
    public void gameHasHadZeroLoopsBeforeBeingStarted(){
        Assert.assertEquals(0, hangman.cycles);
    }

    @Test
    public void gameIsRunningWhenItStarts(){
        hangman.startGame();
        Assert.assertTrue(hangman.running);
    }

    @Test
    public void gameHasOneLoopWhenStarted(){
        hangman.startGame();
        Assert.assertEquals(1, hangman.cycles);
    }

    @Test
    public void takesALetter(){
        hangman.startGame();
        ByteArrayInputStream input = new ByteArrayInputStream("h\n".getBytes());
        Assert.assertTrue(hangman.takeGuess(input));
    }






}
