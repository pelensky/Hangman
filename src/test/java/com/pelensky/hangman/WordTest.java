package com.pelensky.hangman;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WordTest {
    private Word word;

    @Before
    public void setUp(){
        word = new Word("Hello");
    }

    @Test
    public void takesAWord(){
        Assert.assertEquals("Hello", word.word);
    }
}

