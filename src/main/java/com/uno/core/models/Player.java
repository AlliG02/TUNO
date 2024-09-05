package com.uno.core.models;

public abstract class Player {
    protected EndlessDeck deck;
    protected String name; // You can use this for identifying the player
    public Hand hand;

    public Player(String name, EndlessDeck sharedDeck) {
        this.name = name;
        this.deck = new EndlessDeck();
        this.hand = new Hand();
    }

    public abstract void takeTurn();

    protected void pickupCard() {
        Card newCard = deck.drawCard();
        System.out.println(name + " picked up: ");
        newCard.showCard();
        hand.addCard(newCard);
    }

    protected void playCard(){

    }

    protected void isValid(){

    }

    // Add methods to manage the player's hand, e.g., show hand, play card, etc.
}
