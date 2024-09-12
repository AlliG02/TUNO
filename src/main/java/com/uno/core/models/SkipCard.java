package com.uno.core.models;

public class SkipCard extends Card {

    public SkipCard(Colour colour){
        super(colour);
        createGridSpecialCards('X');
    }

    @Override
    public void play(Game game){}

}
