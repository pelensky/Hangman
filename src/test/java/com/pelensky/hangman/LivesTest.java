package com.pelensky.hangman;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LivesTest {
    private Lives lives = new Lives(5);

    @Test
    public void takesANumber(){
        assertEquals(5, lives.lives);
    }

    @Test
    public void reduceLifeCountByOne(){
        lives.reduceLifeCount();
        assertEquals(4, lives.lives);
    }

    @Test
    public void checkLivesBelowOne(){
        lives.reduceLifeCount();
        lives.reduceLifeCount();
        lives.reduceLifeCount();
        lives.reduceLifeCount();
        lives.reduceLifeCount();
        assertTrue(lives.hasNoLivesLeft());
    }
}
