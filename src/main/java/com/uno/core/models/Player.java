package com.uno.core.models;
import java.util.Scanner;

public abstract class Player {
    protected EndlessDeck deck;
    protected String name; // You can use this for identifying the player
    private Scanner scanner;
    public Hand hand;


    public Player(String name, EndlessDeck sharedDeck) {
        this.name = name;
        this.deck = sharedDeck;
        this.scanner = new Scanner(System.in);
        this.hand = new Hand();
    }

    public abstract void takeTurn();

    protected void pickupCard() {
        Card newCard = deck.drawCard();
        System.out.println(name + " picked up: ");
        newCard.showCard();
        hand.addCard(newCard);
    }

    protected void playCard() {
        boolean cardPlayed = false;

        while (!cardPlayed){
            System.out.println("Which card? (number from 0 - " +  (hand.getHandSize() - 1) + ")");
            int cardIndex = scanner.nextInt();
            scanner.nextLine();

            // checks index is within bounds
            if (cardIndex < 0 || cardIndex >= hand.getHandSize()){
                System.out.println("Invalid index");
                continue; // skips the rest of the loop and starts iterating again
            }

            Card selectedCard = hand.getCard(cardIndex);

            // checks card can be played
            if (selectedCard.canBePlayedOn(deck.getTopCard())){
                hand.removeCard(cardIndex);
                deck.setTopCard(selectedCard);
                System.out.println(name + " played:");
                selectedCard.showCard();
                cardPlayed = true;  // exits after playing card
            }
            else {
                System.out.println("This card cannot be played. Please select a valid card.");
            }
        }
    }
}
