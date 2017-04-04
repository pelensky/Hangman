package com.pelensky.hangman;

import org.junit.Assert;
import org.junit.Test;

public class LivesTest {
    private Lives lives = new Lives(5);

    @Test
    public void takesANumber(){
        Assert.assertEquals(5, lives.lives);
    }
}
