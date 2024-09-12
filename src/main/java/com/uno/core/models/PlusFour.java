package com.uno.core.models;

import java.util.Scanner;

public class PlusFour extends Card{

    public PlusFour(Colour colour){
        super(colour);
        createGridSpecialCards('④');
    }

    @Override
    public void play(Game game) {
        Colour chosenColour = chooseColour();
        this.colour = chosenColour;
        System.out.println(game.currentPlayer.name + " played plus four! " + game.getNextPlayer().name + " Must pick up four cards. The colour is now " + chosenColour);
        game.plusFourEffect();
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
