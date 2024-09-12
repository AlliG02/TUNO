package com.uno.core.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Game {
    private List<Player> players;
    private Player humanPlayer;
    private Player computerPlayer;
    private Scanner scanner;
    private Deck sharedDeck;
    private String winner;
    private boolean reverseOrder = false;
    private boolean repeatTurn = false;
    public Player currentPlayer;

    public Game(List<Player> players) {

        sharedDeck = new Deck();
        humanPlayer = new HumanPlayer("Human", sharedDeck);
        computerPlayer = new ComputerPlayer(sharedDeck);
        this.players = players;
        this.players.add(humanPlayer);
        this.players.add(computerPlayer);
        this.currentPlayer = humanPlayer;
        scanner = new Scanner(System.in);
        // Title screen
        titleScreen();
    }

    private void startGame() {
        boolean gameOngoing = true;
        // Game loop
        while (gameOngoing) {
            // screen stuff
            System.out.println(computerPlayer.name + " has " + computerPlayer.hand.getHandSize() + " cards remaining. The top card is: \n");
            sharedDeck.getTopCard().showCard();
            System.out.println("Deck is:");
            sharedDeck.showDeck();
            System.out.println("Trash pile is:");
            sharedDeck.trash.showTrash();
            System.out.println();

            currentPlayer.takeTurn(this);

            // exit the game loop if there is a winner
            if (currentPlayer.hand.getHandSize() == 0) {
                winner = currentPlayer.name;
                gameOngoing = false;
                break;
            }
            // current player has another go if the repeatTurn flag is true (skip or reverse cards)
            if (!repeatTurn){
                currentPlayer = getNextPlayer();
            }
            else {
                repeatTurn = false; // flag is reset after extra turn
            }
            // handle deck refill if needed
            if (sharedDeck.deckIsEmpty()) {
                if (!sharedDeck.trash.trashIsEmpty()) {
                    // refill the deck with the trash pile
                    sharedDeck.refillFromTrash(sharedDeck.trash.getTrash()); }
                else {
                    sharedDeck.refillFromNewDeck();
                }
            }
        }
        endScreen();
    }

    // Apply the PlusTwo effect to the next player
    public void plusTwoEffect() {
        Player nextPlayer = getNextPlayer();
        for (int i = 0; i < 2; i++){
            nextPlayer.hand.addCard(sharedDeck.drawCard());
        }
        repeatTurn = true;  // Skips the next player's turn
    }

    // Apply the PlusTwo effect to the next player
    public void plusFourEffect() {
        Player nextPlayer = getNextPlayer();
        for (int i = 0; i < 4; i++){
            nextPlayer.hand.addCard(sharedDeck.drawCard());
        }
        repeatTurn = true;  // Skips the next player's turn
    }

    // set reverseOrder to the negation of its current value
    public void toggleReverseFlag(){
        this.reverseOrder = !this.reverseOrder;
    }

    public void repeatCurrentPlayer(){
        this.repeatTurn = true; 
    }

    public Player getNextPlayer(){
        int currentPlayerIndex = players.indexOf(currentPlayer);
        if (reverseOrder){
            return players.get((currentPlayerIndex - 1 + players.size()) % players.size());
        }
        else {
            return players.get((currentPlayerIndex + 1) % players.size()); // modulo ensures we stay within the bounds of arraylist
        }
    }

    private void rules(){
        System.out.println("Java has no built in lorem ipsum function :'(");
    }

    private void endScreen(){
        System.out.println(winner + " won the game!");
        System.out.println("PLay again ? (1) Quit? (2)");
        int againOrQuit = scanner.nextInt();

        switch(againOrQuit){
            case(1):
                titleScreen();
            case(2):
                System.exit(0);
        }
    }

    private void titleScreen(){
        System.out.println("UU    UU  NNN    NN    OOOOOO");
        System.out.println("UU    UU  NNNN   NN   OO    OO");
        System.out.println("UU    UU  NN NN  NN  OO      OO");
        System.out.println("UU    UU  NN  NN NN  OO      OO");
        System.out.println("UU    UU  NN   NNNN   OO    OO");
        System.out.println(" UUUUUU   NN    NNN    OOOOOO ");
        System.out.println();
        System.out.println("  Welcome to UNO!");
        System.out.println("  Press '1' to Start, '2' for Rules, '3' to Exit.");

        int selection = scanner.nextInt();

        switch(selection){
            case(1):
                startGame();
                break;
            case(2):
                rules();
                break;
            case(3):
                System.exit(0);
        }

    }
}