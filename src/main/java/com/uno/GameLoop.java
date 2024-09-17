package com.uno;

import com.uno.action.Action;
import com.uno.action.PrintResults;
import com.uno.action.PrintTitleScreen;
import com.uno.core.models.Game;

public class GameLoop {
    private final Game game;

    public GameLoop(Game game) {
        this.game = game;
    }

    public void run() {
        new PrintTitleScreen().run(game);
        loop();
        new PrintResults().run(game);
    }
    public void loop() {
        Action action = game.waitForAction();
        boolean isValid = game.validateAction(action);
        if (isValid) {
            game.playAction(action);
        } else {
            System.out.println("Invalid action");
            game.resetCurrentAction();
            loop();
        }

        if (!game.playerWon()) {
            game.setNextPlayer();
            loop();
        }
    }
}
