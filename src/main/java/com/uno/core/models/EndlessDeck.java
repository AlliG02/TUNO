package com.uno.core.models;

public class EndlessDeck {

    private Card topCard;

    public EndlessDeck(){
        topCard = new Card();
    }

    // setter for top card
    public void setTopCard(Card newTopCard){
        topCard = newTopCard;
    }

    // getter for top card
    public Card getTopCard(){
        return topCard;
    }

    // create a card
    public Card drawCard(){
        return new Card();
    }
}
