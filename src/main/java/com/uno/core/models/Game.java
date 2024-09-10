package com.uno.core.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Game {
    private List<Player> players;
    private Player player1;
    private Player player2;
    private Scanner scanner;
    private Deck sharedDeck;
    private String winner;
    private Boolean skipNextTurn = false;
    private Boolean reverseOrder = false;

    public Game(List<Player> players) {

        sharedDeck = new Deck(this);
        player1 = new HumanPlayer("Human", sharedDeck);
        player2 = new ComputerPlayer(sharedDeck);
        this.players = players;
        this.players.add(player1);
        this.players.add(player2);
        scanner = new Scanner(System.in);
        // Title screen
        titleScreen();
    }

    private void startGame() {

        // Game loop
        boolean gameOngoing = true;

        while (gameOngoing) {
            // screen stuff
            System.out.println(player2.name + " has " + player2.hand.getHandSize() + " cards remaining. The top card is: \n");
            sharedDeck.getTopCard().showCard();
            System.out.println("Deck is:");
            sharedDeck.showDeck();
            System.out.println("Trash pile is:");
            sharedDeck.trash.showTrash();
            System.out.println();

            // ternary operator. Reverses the player list depending on the reverse flag.
            List<Player> currentPlayers = reverseOrder ? reverse(players) : players;

            // need to figure reversing out

            for (int i = 0; i < currentPlayers.size(); i++) {
                Player player = currentPlayers.get(i);

                // exit the game loop if there is a winner
                if (player.hand.getHandSize() == 0){
                    winner = player.name;
                    gameOngoing = false;
                    break;
                }
                else{
                    player.takeTurn();
                    if (sharedDeck.deckIsEmpty()){
                        if (!sharedDeck.trash.trashIsEmpty())
                            // refill the deck with the trash pile
                            sharedDeck.refillFromTrash(sharedDeck.trash.getTrash());
                        else{
                            sharedDeck.refillFromNewDeck();
                        }
                    }
                }
            }

        }
        endScreen();
    }

    // set reverseOrder to the negation of its current value
    public void toggleReverseFlag(){
        this.reverseOrder = !this.reverseOrder;
    }

    private List<Player> reverse(List<Player> list){
        List<Player> reversedList = new ArrayList<>(list);
        Collections.reverse(reversedList);
        return reversedList;
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