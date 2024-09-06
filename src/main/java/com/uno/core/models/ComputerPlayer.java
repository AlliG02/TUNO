package com.uno.core.models;

import java.util.Random;

public class ComputerPlayer extends Player {

    private Random random;

    public ComputerPlayer(EndlessDeck sharedDeck){
        super("Computer", sharedDeck);
        hand.fillHand();
        random = new Random();
    }

    @Override
    public void takeTurn(){
        System.out.println(name + "'s turn:");

        if (random.nextBoolean()) {
            // Example: 50% chance to play a card
            playCard();
        }
        else {
            pickupCard();
        }
    }

    @Override
    protected void playCard() {
        boolean cardPlayed = false;

        // Automatically try to find a playable card
        for (int i = 0; i < hand.getHandSize(); i++) {
            Card selectedCard = hand.getCard(i);

            if (selectedCard.canBePlayedOn(deck.getTopCard())) {
                hand.removeCard(i);
                deck.setTopCard(selectedCard);
                System.out.println(name + " played:");
                selectedCard.showCard();
                cardPlayed = true;
                break;  // Exit the loop after playing a card
            }
        }

        // If no card is playable, the computer picks up a card
        if (!cardPlayed) {
            System.out.println(name + " cannot play any card and will pick up a card.");
            pickupCard();
        }
    }
}
