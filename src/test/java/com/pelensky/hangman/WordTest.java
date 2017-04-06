package com.pelensky.hangman;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WordTest {
  private Word word;

  @Before
  public void setUp() {
    word = new Word("Hello");
    word.setUnderscoresForCharacters();
  }

  @Test
  public void showsCharacters() {
    Assert.assertEquals("_____", word.returnCharacters());
  }

  @Test
  public void guessCorrectLetter() {
    word.isGuessCorrect('h');
    Assert.assertEquals("H____", word.returnCharacters());
  }

  @Test
  public void guessIncorrectLetter() {
    word.isGuessCorrect('d');
    Assert.assertEquals("_____", word.returnCharacters());
  }

  @Test
  public void guessMultipleLetters() {
    word.isGuessCorrect('h');
    word.isGuessCorrect('l');
    Assert.assertEquals("H_LL_", word.returnCharacters());
  }

  @Test
  public void checksWordMatchesLetter() {
    word.isGuessCorrect('h');
    word.isGuessCorrect('e');
    word.isGuessCorrect('l');
    word.isGuessCorrect('o');
    Assert.assertTrue(word.doesWordMatchGuesses());
  }

  @Test
  public void randomWord() {
    Word randomWord = new Word();
    randomWord.chooseRandomWord();
    Assert.assertNotEquals("Hello", randomWord.word);
  }
}
