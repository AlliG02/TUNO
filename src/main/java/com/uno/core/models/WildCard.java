package com.uno.core.models;

import java.util.Scanner;

public class WildCard extends Card{

    public WildCard(Colour colour){
        super(colour);
        createGridSpecialCards('W');
    }

    @Override
    public void play(Game game) {
        Colour chosenColour = chooseColour();
        this.colour = chosenColour;
        System.out.println(game.currentPlayer.name + " played wild! The colour is now " + chosenColour);
    }

    private Colour chooseColour(){
        Scanner scanner = new Scanner(System.in);
        Colour chosenColour = null;

        while (chosenColour == null){
            System.out.println("Choose a color: (1) Red, (2) Green, (3) Blue, (4) Yellow");
            int colourChoice = scanner.nextInt();

            switch (colourChoice){
                case 1:
                    chosenColour = Colour.RED;
                    break;
                case 2:
                    chosenColour = Colour.GREEN;
                    break;
                case 3:
                    chosenColour = Colour.BLUE;
                    break;
                case 4:
                    chosenColour = Colour.YELLOW;
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a color: (1) Red, (2) Green, (3) Blue, (4) Yellow");
                    break;
            }
        }
        return chosenColour;
    }

    // will need to adapt for computer player
}
