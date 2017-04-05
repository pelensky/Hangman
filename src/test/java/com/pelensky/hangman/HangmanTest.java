package com.pelensky.hangman;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Scanner;
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
    public void checkGameWon(){
        ByteArrayInputStream input1 = new ByteArrayInputStream("h\n".getBytes());
        hangman.takeGuess(input1);
        ByteArrayInputStream input2 = new ByteArrayInputStream("e\n".getBytes());
        hangman.takeGuess(input2);
        ByteArrayInputStream input3 = new ByteArrayInputStream("l\n".getBytes());
        hangman.takeGuess(input3);
        ByteArrayInputStream input4 = new ByteArrayInputStream("o\n".getBytes());
        hangman.takeGuess(input4);
        Assert.assertTrue(hangman.gameWon());
    }

    @Test
    public void checkGameLost(){
        ByteArrayInputStream input1 = new ByteArrayInputStream("a\n".getBytes());
        hangman.takeGuess(input1);
        ByteArrayInputStream input2 = new ByteArrayInputStream("b\n".getBytes());
        hangman.takeGuess(input2);
        ByteArrayInputStream input3 = new ByteArrayInputStream("c\n".getBytes());
        hangman.takeGuess(input3);
        ByteArrayInputStream input4 = new ByteArrayInputStream("d\n".getBytes());
        hangman.takeGuess(input4);
        ByteArrayInputStream input5 = new ByteArrayInputStream("f\n".getBytes());
        hangman.takeGuess(input5);
        Assert.assertTrue(hangman.gameLost());
    }

    @Test
    public void displaysWelcomeMessage(){
        Scanner scanner = new Scanner("h e l o");
        hangman.gameLoop(scanner);
        Assert.assertThat(outContent.toString(), containsString("Welcome to Hangman!\n"));
    }

    @Test
    public void showWord(){
        Scanner scanner = new Scanner("h e l o");
        hangman.gameLoop(scanner);
        Assert.assertThat(outContent.toString(), containsString("The word is: _____\n"));
    }

    @Test
    public void showOptionToTakeGuess(){
        Scanner scanner = new Scanner("h e l o");
        hangman.gameLoop(scanner);
        Assert.assertThat(outContent.toString(), containsString("Take a guess!\n"));
    }

    @Test
    public void testGameLoopWinning(){
        Scanner scanner = new Scanner("h e l o");
        hangman.gameLoop(scanner);
        Assert.assertThat(outContent.toString(), containsString("You won!\n"));
    }

    @Test
    public void testGameLoopLosing(){
        Scanner scanner = new Scanner("a b c d f");
        hangman.gameLoop(scanner);
        Assert.assertThat(outContent.toString(), containsString("You lost\n"));
    }


}
