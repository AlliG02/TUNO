package com.uno;

import org.junit.Test;

import javax.annotation.processing.SupportedAnnotationTypes;

// check that the main method gets executed
public class GameMainMethodTest {

    @Test
    public void verifyNoExceptionThrown() {
        Game.main(new String[]{});
    }
}
