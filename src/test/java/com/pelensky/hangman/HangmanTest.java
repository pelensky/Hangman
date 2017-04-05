package com.pelensky.hangman;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;

public class HangmanTest {
    private Hangman hangman;
    private Game game;
    private Word word;
    private Lives lives;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();


    @Before
    public void setUp(){
        word = new Word("Hello");
        lives = new Lives(5);
        game = new Game(word, lives);
        hangman = new Hangman(game);
        hangman.startGame();
    }

    @Before
    public void setUpStream(){
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void wordChangedForRightGuess(){
        ByteArrayInputStream input = new ByteArrayInputStream("h\n".getBytes());
        Assert.assertEquals("H____", hangman.takeGuess(input));
    }

    @Test
    public void wordNotChangedForWrongGuess(){
        ByteArrayInputStream input = new ByteArrayInputStream("a\n".getBytes());
        Assert.assertEquals("_____", hangman.takeGuess(input));
    }

    @Test
    public void livesGoDownForWrongGuess(){
        ByteArrayInputStream input = new ByteArrayInputStream("a\n".getBytes());
        hangman.takeGuess(input);
        Assert.assertEquals(4, hangman.showLives());
    }

    @Test
    public void livesStayTheSameForRightGuess(){
        ByteArrayInputStream input = new ByteArrayInputStream("h\n".getBytes());
        hangman.takeGuess(input);
        Assert.assertEquals(5, hangman.showLives());
    }

    @Test
    public void displaysWelcomeMessage(){
        hangman.welcomeMessage();
        Assert.assertThat(outContent.toString(), containsString("Welcome to Hangman!\n"));
    }

    @Test
    public void showWord(){
        hangman.playGame();
        Assert.assertThat(outContent.toString(), containsString("The word is: _____\n"));
    }

    @Test
    public void showOptionToTakeGuess(){
        hangman.playGame();
        Assert.assertThat(outContent.toString(), containsString("Take a guess!\n"));
    }






}
