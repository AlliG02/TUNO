package com.uno.core.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Collections;

public class Deck {

    private Card topCard;
    private List<Card> deck;
    private Game game;
    public TrashPile trash;

    // constructor for default deck
    // 10 normal cards of each colour
    // 1 skip, plus two and reverse of each colour
    // 2 plus fours and wilds
    public Deck(Game game){
        deck = new ArrayList<>();
        trash = new TrashPile();
        this.game = game;

        // add blue cards
        for (int i = 0; i < 10; i++){
            deck.add(new Card(i, Colour.BLUE)); // normal
        }
        deck.add(new ReverseCard(Colour.BLUE)); // reverse
        deck.add(new SkipCard(Colour.BLUE)); // skip
        deck.add(new PlusTwo(Colour.BLUE)); // plus two

        // add red cards
        for (int i = 0; i < 10; i++){
            deck.add(new Card(i, Colour.RED)); // normal
        }
        deck.add(new ReverseCard(Colour.RED)); // reverse
        deck.add(new SkipCard(Colour.RED)); // skip
        deck.add(new PlusTwo(Colour.RED)); // plus two

        // add yellow cards
        for (int i = 0; i < 10; i++){
            deck.add(new Card(i, Colour.YELLOW)); // normal
        }
        deck.add(new ReverseCard(Colour.YELLOW)); // reverse
        deck.add(new SkipCard(Colour.YELLOW)); // skip
        deck.add(new PlusTwo(Colour.YELLOW)); // plus two

        // add green cards
        for (int i = 0; i < 10; i++){
            deck.add(new Card(i, Colour.GREEN)); // normal
        }
        deck.add(new ReverseCard(Colour.GREEN)); // reverse
        deck.add(new SkipCard(Colour.GREEN)); // skip
        deck.add(new PlusTwo(Colour.GREEN)); // plus two

        // two plus fours and wild cards
        for (int i = 0; i < 1; i++){
            deck.add(new PlusFour(Colour.WHITE));
            deck.add(new WildCard(Colour.WHITE));
        }

        // shuffle the deck
        Collections.shuffle(deck);

        // find valid starting card
        Iterator<Card> iterator = deck.iterator();
        while (iterator.hasNext()) {
            Card card = iterator.next();
            if (!(card instanceof ReverseCard || card instanceof SkipCard || card instanceof PlusTwo || card instanceof PlusFour || card instanceof WildCard)) { // ensure top card is a normal card
                topCard = card;
                iterator.remove();  // Safely removes the current element from the deck
                break;  // Exit the loop after finding the top card
            }
        }

    }

    // constructor for custom deck
    public Deck(int normalCards, int reverseCards, int skipCards, int plusTwoCards, int plusFourCards, int wildCards) {
        deck = new ArrayList<>();
        trash = new TrashPile();

        // add blue cards
        for (int i = 0; i < normalCards; i++) {
            deck.add(new Card(i, Colour.BLUE));
        }
        for (int i = 0; i < reverseCards; i++) {
            deck.add(new Card(i, Colour.BLUE));
        }
        for (int i = 0; i < skipCards; i++) {
            deck.add(new Card(i, Colour.BLUE));
        }
        for (int i = 0; i < plusTwoCards; i++) {
            deck.add(new Card(i, Colour.BLUE));
        }

        // add red cards
        for (int i = 0; i < normalCards; i++) {
            deck.add(new Card(i, Colour.RED));
        }
        for (int i = 0; i < reverseCards; i++) {
            deck.add(new Card(i, Colour.RED));
        }
        for (int i = 0; i < skipCards; i++) {
            deck.add(new Card(i, Colour.RED));
        }
        for (int i = 0; i < plusTwoCards; i++) {
            deck.add(new Card(i, Colour.RED));
        }

        // add yellow cards
        for (int i = 0; i < normalCards; i++) {
            deck.add(new Card(i, Colour.YELLOW));
        }
        for (int i = 0; i < reverseCards; i++) {
            deck.add(new Card(i, Colour.YELLOW));
        }
        for (int i = 0; i < skipCards; i++) {
            deck.add(new Card(i, Colour.YELLOW));
        }
        for (int i = 0; i < plusTwoCards; i++) {
            deck.add(new Card(i, Colour.YELLOW));
        }

        // add yellow cards
        for (int i = 0; i < normalCards; i++) {
            deck.add(new Card(i, Colour.GREEN));
        }
        for (int i = 0; i < reverseCards; i++) {
            deck.add(new Card(i, Colour.GREEN));
        }
        for (int i = 0; i < skipCards; i++) {
            deck.add(new Card(i, Colour.GREEN));
        }
        for (int i = 0; i < plusTwoCards; i++) {
            deck.add(new Card(i, Colour.GREEN));
        }

        for (int i = 0; i < plusFourCards; i++) {
            deck.add(new Card(i, Colour.YELLOW));
        }
        for (int i = 0; i < wildCards; i++) {
            deck.add(new Card(i, Colour.YELLOW));
        }

        // shuffle the deck
        Collections.shuffle(deck);

        // find valid starting card
        Iterator<Card> iterator = deck.iterator();
        while (iterator.hasNext()) {
            Card card = iterator.next();
            if ((!(card instanceof ReverseCard)) && (!(card instanceof SkipCard))) { // This check needed for when special cards added
                topCard = card;
                iterator.remove();  // Safely removes the current element from the deck
                break;  // Exit the loop after finding the top card
            }
        }
    }

//    // test constructor just for skip cards
//    public Deck(){
//        deck = new ArrayList<>();
//        trash = new TrashPile();
//
//        // add blue cards
//        for (int i = 0; i < 10; i++){
//            deck.add(new Card(i, Colour.BLUE));
//            deck.add(new SkipCard(Colour.BLUE)); // reverse
//        }
//
//        // add red cards
//        for (int i = 0; i < 10; i++){
//            deck.add(new SkipCard(Colour.RED)); // reverse
//        }
//        // shuffle the deck
//        Collections.shuffle(deck);
//        // find valid starting card
//        Iterator<Card> iterator = deck.iterator();
//        while (iterator.hasNext()) {
//            Card card = iterator.next();
//            if ((!(card instanceof ReverseCard)) && (!(card instanceof SkipCard))) { // This check needed for when special cards added
//                topCard = card;
//                iterator.remove();  // Safely removes the current element from the deck
//                break;  // Exit the loop after finding the top card
//            }
//        }
//    }

//    // test constructor just for plus two cards
//    public Deck(){
//        deck = new ArrayList<>();
//        trash = new TrashPile();
//
//        // add blue cards
//        for (int i = 0; i < 10; i++){
//            deck.add(new Card(i, Colour.BLUE));
//            deck.add(new PlusTwo(Colour.BLUE)); // reverse
//        }
//
//        // add red cards
//        for (int i = 0; i < 10; i++){
//            deck.add(new PlusTwo(Colour.RED)); // reverse
//        }
//        // shuffle the deck
//        Collections.shuffle(deck);
//        // find valid starting card
//        Iterator<Card> iterator = deck.iterator();
//        while (iterator.hasNext()) {
//            Card card = iterator.next();
//            if ((!(card instanceof ReverseCard)) && (!(card instanceof SkipCard))) { // This check needed for when special cards added
//                topCard = card;
//                iterator.remove();  // Safely removes the current element from the deck
//                break;  // Exit the loop after finding the top card
//            }
//        }
//    }

//    // test constructor just for wild cards
//    public Deck(){
//        deck = new ArrayList<>();
//        trash = new TrashPile();
//
//        // add blue cards
//        for (int i = 0; i < 10; i++){
//            deck.add(new Card(i, Colour.BLUE));
//            deck.add(new WildCard(Colour.WHITE)); // reverse
//        }
//
//        // add red cards
//        for (int i = 0; i < 10; i++){
//            deck.add(new PlusTwo(Colour.RED)); // reverse
//        }
//        // shuffle the deck
//        Collections.shuffle(deck);
//        // find valid starting card
//        Iterator<Card> iterator = deck.iterator();
//        while (iterator.hasNext()) {
//            Card card = iterator.next();
//            if ((!(card instanceof ReverseCard)) && (!(card instanceof SkipCard))) { // This check needed for when special cards added
//                topCard = card;
//                iterator.remove();  // Safely removes the current element from the deck
//                break;  // Exit the loop after finding the top card
//            }
//        }
//    }
//
//    // test constructor just for plus four cards
//    public Deck(){
//        deck = new ArrayList<>();
//        trash = new TrashPile();
//
//        // add blue cards
//        for (int i = 0; i < 10; i++){
//            deck.add(new Card(i, Colour.BLUE));
//            deck.add(new PlusFour(Colour.WHITE)); // reverse
//        }
//
//        // add red cards
//        for (int i = 0; i < 10; i++){
//            deck.add(new PlusFour(Colour.WHITE)); // reverse
//        }
//        // shuffle the deck
//        Collections.shuffle(deck);
//        // find valid starting card
//        Iterator<Card> iterator = deck.iterator();
//        while (iterator.hasNext()) {
//            Card card = iterator.next();
//            if ((!(card instanceof ReverseCard)) && (!(card instanceof SkipCard))) { // This check needed for when special cards added
//                topCard = card;
//                iterator.remove();  // Safely removes the current element from the deck
//                break;  // Exit the loop after finding the top card
//            }
//        }
//    }

    public void refillFromTrash(List<Card> trashPile) {
        deck.clear();
        deck.addAll(trashPile);    // Add all cards from the trash pile back to the deck
        trashPile.clear();         // Empty the trash pile
        Collections.shuffle(deck); // Shuffle the newly refilled deck
    }

    public void refillFromNewDeck() {
        deck.clear();
        Deck newDeck = new Deck(game);
        deck.addAll(newDeck.deck);
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
        if (!deck.isEmpty()) {
            for (Card card : deck) {
                card.showCard();
            }
        }
        else {
            System.out.println("The deck is empty.");
        }
    }

    public boolean deckIsEmpty(){
        return deck.isEmpty();
    }
}
