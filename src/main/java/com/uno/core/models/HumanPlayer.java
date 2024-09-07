package com.uno.core.models;

import java.util.Scanner;

public class HumanPlayer extends Player{

    private Scanner scanner;

    public HumanPlayer(String name, Deck sharedDeck){
        super(name, sharedDeck);
        hand.fillHand();
        scanner = new Scanner(System.in);
    }

    @Override
    public void takeTurn() {
        // Example logic for taking a turn
        // Check if they can even pickup first
        System.out.println(name + ", it's your turn!\n");
        hand.showHand();
        System.out.println();

        boolean hasPlayableCards = hand.hasPlayableCard(deck.getTopCard());
        boolean validChoice = false;

        while(!validChoice){
            if (hasPlayableCards){
                System.out.println("1. Play a card");
                System.out.println("2. Pick up a card");


                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline

                switch (choice) {
                    case 1:
                        System.out.println();
                        playCard();
                        validChoice = true;
                        break;
                    case 2:
                        pickupCard();
                        validChoice = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please choose either 1 or 2.");
                        break;
                }
            }
            else{
                System.out.println("You have no cards that match. You must pickup a card.");
                pickupCard();
                validChoice = true;
            }
        }
    }
}
