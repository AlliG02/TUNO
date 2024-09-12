package com.uno;
import com.uno.core.models.Deck;
import com.uno.core.models.Game;
import com.uno.core.models.HumanPlayer;
import com.uno.core.models.Player;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[]args){
        List<Player> players = new ArrayList<>();
        new Game(players);
    }
}