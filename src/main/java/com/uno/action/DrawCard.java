package com.uno.action;

import com.uno.core.models.Card;
import com.uno.core.models.Game;


public class DrawCard implements Action {
    @Override
    public void run(Game game) {
        Card card = game.deck.draw();
        game.currentPlayer.addCard(card);
    }
}
