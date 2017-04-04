package com.pelensky.hangman;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Assert.*;

public class GameTest {

    @Test
    public void winGameWithEmptyString() {
        Game game = new Game("");
        Assert.assertEquals(true, game.isGameOver());
    }
}
