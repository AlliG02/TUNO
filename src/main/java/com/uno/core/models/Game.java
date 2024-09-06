package com.uno.core.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private List<Player> players;
    private Player player1;
    private Player player2;
    private Scanner scanner;
    private EndlessDeck sharedDeck;
    private String winner;

    public Game() {

        sharedDeck = new EndlessDeck();
        player1 = new HumanPlayer("Human", sharedDeck);
        player2 = new ComputerPlayer(sharedDeck);
        players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
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
            System.out.println();

            for (Player player : players) {
                if (player.hand.getHandSize() == 0){
                    winner = player.name;
                    gameOngoing = false;
                }
                player.takeTurn();
            }
        }
        endScreen();
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