package com.uno.core.models;

public class PlusTwo extends Card{

    public PlusTwo(Colour colour){
        super(colour);
        createGridSpecialCards('②');
    }

    @Override
    public void play(Game game){
        System.out.println(game.currentPlayer.name + " played plus two! " + game.getNextPlayer().name + " must pick up two cards!");
        game.plusTwoEffect();
    }

}
