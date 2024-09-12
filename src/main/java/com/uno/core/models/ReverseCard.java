package com.uno.core.models;

public class ReverseCard extends Card {

    public ReverseCard(Colour colour){
        super(colour);
        createGridSpecialCards('⟳');
    }

    @Override
    public void play(Game game) {
        System.out.println(game.currentPlayer.name + " played a reverse card!");
        game.toggleReverseFlag();
        game.repeatCurrentPlayer();
    }

}
