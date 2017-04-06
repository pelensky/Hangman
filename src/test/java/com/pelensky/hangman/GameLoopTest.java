package com.pelensky.hangman;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Scanner;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;

public class GameLoopTest {
  private GameLoop gameLoop;
  private Game game;
  private Word word;
  private Lives lives;
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

  @Before
  public void setUp() {
    word = new Word("Hello");
    lives = new Lives(5);
    game = new Game(word, lives);
    gameLoop = new GameLoop(game);
    gameLoop.startGame();
  }

  @Before
  public void setUpStream() {
    System.setOut(new PrintStream(outContent));
  }

  @Test
  public void wordChangedForRightGuess() {
    ByteArrayInputStream input = new ByteArrayInputStream("h\n".getBytes());
    Assert.assertEquals("H____", gameLoop.takeGuess(input));
  }

  @Test
  public void wordNotChangedForWrongGuess() {
    ByteArrayInputStream input = new ByteArrayInputStream("a\n".getBytes());
    Assert.assertEquals("_____", gameLoop.takeGuess(input));
  }

  @Test
  public void livesGoDownForWrongGuess() {
    ByteArrayInputStream input = new ByteArrayInputStream("a\n".getBytes());
    gameLoop.takeGuess(input);
    Assert.assertEquals(4, gameLoop.returnLives());
  }

  @Test
  public void livesStayTheSameForRightGuess() {
    ByteArrayInputStream input = new ByteArrayInputStream("h\n".getBytes());
    gameLoop.takeGuess(input);
    Assert.assertEquals(5, gameLoop.returnLives());
  }

  @Test
  public void checkGameWon() {
    ByteArrayInputStream input1 = new ByteArrayInputStream("h\n".getBytes());
    gameLoop.takeGuess(input1);
    ByteArrayInputStream input2 = new ByteArrayInputStream("e\n".getBytes());
    gameLoop.takeGuess(input2);
    ByteArrayInputStream input3 = new ByteArrayInputStream("l\n".getBytes());
    gameLoop.takeGuess(input3);
    ByteArrayInputStream input4 = new ByteArrayInputStream("o\n".getBytes());
    gameLoop.takeGuess(input4);
    Assert.assertTrue(gameLoop.isGameWon());
  }

  @Test
  public void checkGameLost() {
    ByteArrayInputStream input1 = new ByteArrayInputStream("a\n".getBytes());
    gameLoop.takeGuess(input1);
    ByteArrayInputStream input2 = new ByteArrayInputStream("b\n".getBytes());
    gameLoop.takeGuess(input2);
    ByteArrayInputStream input3 = new ByteArrayInputStream("c\n".getBytes());
    gameLoop.takeGuess(input3);
    ByteArrayInputStream input4 = new ByteArrayInputStream("d\n".getBytes());
    gameLoop.takeGuess(input4);
    ByteArrayInputStream input5 = new ByteArrayInputStream("f\n".getBytes());
    gameLoop.takeGuess(input5);
    Assert.assertTrue(gameLoop.isGameLost());
  }

  @Test
  public void displaysWelcomeMessage() {
    Scanner scanner = new Scanner("h e l o");
    gameLoop.playGameLoop(scanner);
    Assert.assertThat(outContent.toString(), containsString("Welcome to Hangman!\n"));
  }

  @Test
  public void showWord() {
    Scanner scanner = new Scanner("h e l o");
    gameLoop.playGameLoop(scanner);
    Assert.assertThat(outContent.toString(), containsString("The word is: _____\n"));
  }

  @Test
  public void showOptionToTakeGuess() {
    Scanner scanner = new Scanner("h e l o");
    gameLoop.playGameLoop(scanner);
    Assert.assertThat(outContent.toString(), containsString("Take a guess!\n"));
  }

  @Test
  public void testGameLoopWinning() {
    Scanner scanner = new Scanner("h e l o");
    gameLoop.playGameLoop(scanner);
    Assert.assertThat(outContent.toString(), containsString("You won!\n"));
  }

  @Test
  public void testGameLoopLosing() {
    Scanner scanner = new Scanner("a b c d f");
    gameLoop.playGameLoop(scanner);
    Assert.assertThat(outContent.toString(), containsString("You lost\n"));
  }
}
