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
        // do stuff
        System.out.println(name + "'s turn:");

        if (random.nextBoolean()) {
            // Example: 50% chance to play a card
            System.out.println(name + " decided to play a card.");
            // Logic to play a card
        } else {
            pickupCard();
        }
    }

}
