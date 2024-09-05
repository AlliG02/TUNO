package com.uno;

import java.util.Random;
import java.util.HashMap;
import java.util.Map;

class Card {
    private static final String[] COLOURS = {"Red", "Blue", "Green", "Yellow"};
    private char[][] grid;
    public int number;
    public String colour;

    // create card object and arrange in grid.
    public Card(){
        Random random = new Random();
        
        this.number = random.nextInt(9) + 1; 
        this.colour = COLOURS[random.nextInt(COLOURS.length)];
        this.grid = new char[3][3];
        
        char charNum = (char) ('0' + this.number);
        char charCol = this.colour.charAt(0);
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = charCol;
            }
        }     
        grid[1][1] = charNum;
    }

    public void showCard() {
    for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[i].length; j++) {
            System.out.print(grid[i][j] + " ");
        }
            System.out.println(); 
        }
    }

}