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
    public void takesAWord(){
        Assert.assertEquals("Hello", word.word);
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
        Assert.assertEquals("H_ll_", word.showCharacters());
    }

}

