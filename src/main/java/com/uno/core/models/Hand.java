package com.uno.core.models;

import java.util.ArrayList;

public class Hand {

    private ArrayList<Card> cards;

    public Hand(){
        cards = new ArrayList<Card>();
    }

    public void fillHand(){
        for (int i = 0; i < 7; i++){
            cards.add(new Card());
        }
    }

    public void addCard(Card card){
        cards.add(card);
    }

    public void removeCard(int index){
        if (index >= 0 && index < cards.size())
            cards.remove(index);
        else {
            System.out.println("Index out of bounds");
        }
    }

    public Card getCard(int index){
        if (index >= 0 && index < cards.size())
            return cards.get(index);
        else {
            System.out.println("Index out of bounds");
            return null;
        }
    }

    public int getHandSize(){
        return cards.size();
    }

    public void showHand() {
        if (cards.isEmpty()) {
            System.out.println("No cards in hand.");
            return;
        }

        int cardHeight = 3;  // Number of rows in a card grid
        int cardWidth = 3;   // Number of columns in a card grid

        // Print the card grids row by row
        for (int row = 0; row < cardHeight; row++) {
            for (Card card : cards) {

                // Print each row of the current card
                char[][] grid = card.getGrid();
                for (int col = 0; col < cardWidth; col++) {
                    System.out.print(grid[row][col] + " ");
                }
                System.out.print("   ");  // Add some space between cards
            }
            System.out.println();  // Move to the next line after each row of cards is printed
        }
        // TODO add numbers
    }

    public boolean hasPlayableCard(Card topCard) {
        for (Card card : cards) {
            if (card.canBePlayedOn(topCard)) {
                return true;
            }
        }
        return false;
    }

}