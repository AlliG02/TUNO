package com.uno.core.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Collections;

public class Deck {

    private Card topCard;
    private List<Card> deck;
    public TrashPile trash;

    public Deck(){
        deck = new ArrayList<>();
        trash = new TrashPile();

        // add blue cards
        for (int i = 0; i < 10; i++){
            deck.add(new Card(i, Colour.BLUE));
        }
        // add red cards
        for (int i = 0; i < 10; i++){
            deck.add(new Card(i, Colour.RED));
        }
        // add yellow cards
        for (int i = 0; i < 10; i++){
            deck.add(new Card(i, Colour.YELLOW));
        }
        // add green cards
        for (int i = 0; i < 10; i++){
            deck.add(new Card(i, Colour.GREEN));
        }

        // shuffle the deck
        Collections.shuffle(deck);

        // find valid starting card
        Iterator<Card> iterator = deck.iterator();
        while (iterator.hasNext()) {
            Card card = iterator.next();
            if (card instanceof Card) { // This check needed for when special cards added
                topCard = card;
                iterator.remove();  // Safely removes the current element from the deck
                break;  // Exit the loop after finding the top card
            }
        }

    }

    // add old top card to trash, set new top card
    public void setTopCard(Card newTopCard){
        trash.addToTrash(topCard);
        topCard = newTopCard;
    }

    // getter for top card
    public Card getTopCard(){
        return topCard;
    }

    // draw a card
    public Card drawCard(){
        Card drawnCard = deck.get(0);
        deck.remove(drawnCard);
        return drawnCard;
    }

    // see deck for debug purposes
    public void showDeck(){
        for (Card card : deck){
            card.showCard();
        }
    }
}
