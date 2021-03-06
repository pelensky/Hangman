package com.pelensky.hangman;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GameTest {
  private Game game;
  private Word word;
  private Lives lives;

  @Before
  public void setUp() {
    word = new Word("Hello");
    lives = new Lives(5);
    game = new Game(word, lives);
    game.newGame();
  }

  @Test
  public void takesAWordObject() {
    Assert.assertEquals(word, game.word);
  }

  @Test
  public void takesANumberOfLives() {
    Assert.assertEquals(lives, game.lives);
  }

  @Test
  public void checkGameNotWon() {
    Assert.assertFalse(game.isGameWon());
  }

  @Test
  public void checkGameWon() {
    game.guessLetter('h');
    game.guessLetter('e');
    game.guessLetter('l');
    game.guessLetter('o');
    Assert.assertTrue(game.isGameWon());
  }

  @Test
  public void checkGameLost() {
    game.guessLetter('a');
    game.guessLetter('b');
    game.guessLetter('c');
    game.guessLetter('d');
    game.guessLetter('f');
    Assert.assertTrue(game.isGameLost());
  }

  @Test
  public void showCurrentStatusOfWord() {
    game.guessLetter('h');
    game.guessLetter('l');
    Assert.assertEquals("H_LL_", game.returnCharacters());
  }
}
