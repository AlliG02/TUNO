package com.uno.core.models;

public class ReverseCard extends Card {

    public ReverseCard(Colour colour){
        super(colour);
        createGridSpecialCards('⟳');
    }

    @Override
    public void play() {
        toggleReverseFlag();
    }

}
