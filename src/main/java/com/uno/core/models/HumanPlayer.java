package com.uno.core.models;

import java.util.Scanner;

public class HumanPlayer extends Player{

    private Scanner scanner;
    private Card newCard;

    public HumanPlayer(String name, EndlessDeck sharedDeck){
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
        System.out.println("1. Play a card");
        System.out.println("2. Pick up a card");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        switch (choice) {
            case 1:
                // Logic to play a card
                // pick card
                // card needs to be playable
                //
                break;
            case 2:
                pickupCard();
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }
}
