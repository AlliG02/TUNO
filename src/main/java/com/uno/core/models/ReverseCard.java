package com.uno.core.models;

public class ReverseCard extends Card {

    private Game game;

    public ReverseCard(Colour colour, Game game){
        super(colour);
        this.game = game;
        createGridSpecialCards('⟳');
    }

    @Override
    public void play() {
        game.toggleReverseFlag();
        System.out.println("Turn has been skipped!");
    }

}
