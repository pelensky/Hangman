package com.pelensky.hangman;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WordTest {
    private Word word;

    @Before
    public void setUp(){
        word = new Word("Hello");
        word.setUnderscoresForCharacters();
    }

    @Test
    public void showsCharacters(){
        Assert.assertEquals("_____", word.showCharacters());

    }

    @Test
    public void guessCorrectLetter(){
        word.guessLetter('h');
        Assert.assertEquals("H____", word.showCharacters());
    }

    @Test
    public void guessIncorrectLetter(){
        word.guessLetter('d');
        Assert.assertEquals("_____", word.showCharacters());
    }

    @Test
    public void guessMultipleLetters(){
        word.guessLetter('h');
        word.guessLetter('l');
        Assert.assertEquals("H_LL_", word.showCharacters());
    }

    @Test
    public void checksWordMatchesLetter(){
        word.guessLetter('h');
        word.guessLetter('e');
        word.guessLetter('l');
        word.guessLetter('o');
        Assert.assertTrue(word.checkWordMatchesGuesses());
    }

    @Test
    public void randomWord(){
        Word randomWord = new Word();
        randomWord.chooseRandomWord();
        Assert.assertNotEquals("Hello", randomWord.word);
    }


}

