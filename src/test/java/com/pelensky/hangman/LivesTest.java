package com.pelensky.hangman;

import org.junit.Assert;
import org.junit.Test;

public class LivesTest {
    private Lives lives = new Lives(5);

    @Test
    public void takesANumber(){
        Assert.assertEquals(5, lives.lives);
    }

    @Test
    public void reduceLifeCountByOne(){
        lives.reduceLifeCount();
        Assert.assertEquals(4, lives.lives);
    }

    @Test
    public void checkLivesBelowOne(){
        lives.reduceLifeCount();
        lives.reduceLifeCount();
        lives.reduceLifeCount();
        lives.reduceLifeCount();
        lives.reduceLifeCount();
        Assert.assertTrue(lives.checkGameLost());
    }
}
