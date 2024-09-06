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
                // player function to check they can take turn
                player.takeTurn();
                // Check game status and update accordingly
                // e.g., check if any player has won
            }
        }
    }

    private void rules(){
        System.out.println("Java has no built in lorem ipsum function :'(");
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

//package com.uno;
//
//import java.util.Scanner;
//import java.util.ArrayList;
//import java.util.Random;
//
//class Game {
//    private ArrayList<Card> playerDeck;
//    private ArrayList<Card> computerDeck;
//    private ArrayList<Card> playablePlayerCards;
//    private ArrayList<Card> playableComputerCards;
//    private Card topCard;
//
//    // make Player and EndlessDeck classes that can be fed into Game
//    public Game(){
//        playerDeck = new ArrayList<>();
//        computerDeck = new ArrayList<>();
//        playablePlayerCards = new ArrayList<>();
//        playableComputerCards = new ArrayList<>();
//        topCard = new Card();
//
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Welcome to UNO!");
//        System.out.println("s - Start");
//        System.out.println("r - Rules");
//        System.out.println("e - Exit");
//
//        String action = scanner.nextLine();
//
//        switch (action){
//
//            case "s":
//                // create decks
//                System.out.println();
//
//                for (int i = 0; i < 1; i++){
//                    computerDeck.add(createCard());
//                }
//
//                for (int i = 0; i < 7; i++){
//                    playerDeck.add(createCard());
//                }
//
//                boolean winner = false;
//
//                while (!winner) {
//
//                    System.out.println("Computer cards remaining: " + computerDeck.size() + "\n");
//                    System.out.println("The current card is:\n");
//                    topCard.showCard();
//                    System.out.println();
//                    System.out.println("Your deck:\n");
//
//                    showDeck();
//
//                    if (!canPlay(topCard, playerDeck)){
//
//                        // player turn
//                        System.out.println("YOUR TURN! You must pick up a card. (pickup)");
//                        action = scanner.nextLine();
//
//                        while (!action.equals("pickup")){
//                            System.out.println("You must pick up a card. (pickup)");
//                            action = scanner.nextLine();
//                        }
//
//                        playerDeck.add(createCard());
//
//                        // computer turn
//                        computerTurn(topCard, computerDeck);
//
//                    }
//                    else{
//
//                        // player turn
//                        System.out.println("YOUR TURN! Play a card? (play) OR pick up a new card? (pickup)");
//                        action = scanner.nextLine();
//
//                        while (!action.equals("play") && !action.equals("pickup")){
//                            System.out.println("Invalid option. Try again");
//                            action = scanner.nextLine();
//                        }
//
//                        switch (action){
//
//                            case "pickup":
//
//                                playerDeck.add(createCard());
//                                showDeck();
//                                break;
//
//                            case "play":
//
//                                System.out.println("Pick a card. (choose a number between 0 and " + (playerDeck.size() - 1) + ")");
//                                int cardToPlay = scanner.nextInt();
//
//                                while (cardToPlay < 0 || cardToPlay > playerDeck.size()){
//                                    System.out.println("Number out of bounds. Pick again");
//                                    cardToPlay = scanner.nextInt();
//                                }
//
//                                topCard = playerDeck.get(cardToPlay);
//                                playerDeck.remove(cardToPlay);
//
//                                if (!hasWon()){
//                                    // computer turn
//                                    computerTurn(topCard, computerDeck);
//                                    winner = hasWon();
//                                }
//                                else{
//                                    winner = true;
//                                }
//
//                        }
//                    }
//
//                }
//
//            case "r":
//
//                System.out.println("Rules here");
//                break;
//
//            case "e":
//
//                System.out.println("Exiting");
//                break;
//
//        }
//    }
//
//    public boolean hasWon(){
//        if (playerDeck.size() == 0){
//            System.out.println("Congrats, you won!");
//            return true;
//        }
//        else if (computerDeck.size() == 0){
//            System.out.println("Sorry, you lost!");
//            return true;
//        }
//        else {
//            return false;
//        }
//    }
//
//    public void computerTurn(Card top, ArrayList<Card> deck){
//        if (!canPlay(top, deck)){
//            computerDeck.add(createCard());
//        }
//        else {
//            Random random = new Random();
//
//            for (Card card : deck){
//                if (top.colour.equals(card.colour) || top.number == card.number){
//                    playableComputerCards.add(card);
//                }
//            }
//
//            topCard = playableComputerCards.get(random.nextInt(playableComputerCards.size()));
//            computerDeck.remove(topCard);
//        }
//
//    }
//
//    public boolean canPlay(Card top, ArrayList<Card> deck){
//
//        for (Card card : deck){
//            if (top.colour.equals(card.colour) || top.number == card.number){
//                playablePlayerCards.add(card);
//            }
//        }
//
//        if (playablePlayerCards.size() == 0) {
//            playablePlayerCards.clear();
//            return false;
//        }
//        else{
//            playablePlayerCards.clear();
//            return true;
//        }
//
//    }
//
//    public Card createCard(){
//        Card card = new Card();
//        return card;
//    }
//
//    public void showDeck(){
//        for (Card card: playerDeck){
//            card.showCard();
//            System.out.println("  " + playerDeck.indexOf(card));
//            System.out.println();
//        }
//    }
//
//    public static void main(String args[]){
////        Game game = new Game();
//        System.out.println("Just testing the main method works");
//    }
//
//}