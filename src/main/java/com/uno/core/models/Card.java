package com.uno.core.models;
import java.util.Random;

class Card {
    private static final String[] COLOURS = {"Red", "Blue", "Green", "Yellow"};
    private char[][] grid;
    private Random random;
    public int number;
    public String colour;


    // default constructor for standard cards
    public Card(){
        random = new Random();
        this.number = random.nextInt(9) + 1;
        this.colour = COLOURS[random.nextInt(COLOURS.length)];
        createGrid();
    }

    // constructor for specific numbers and colours
    public Card(int number, String colour){
        // Validate colour
        boolean validColour = false;
        for (String c : COLOURS) {
            if (c.equalsIgnoreCase(colour)) {
                validColour = true;
                break;
            }
        }
        if (!validColour) {
            throw new IllegalArgumentException("Invalid colour specified");
        }

        // Validate number
        if (number < 1 || number > 9) {
            throw new IllegalArgumentException("Number must be between 1 and 9");
        }

        this.colour = colour;
        this.number = number;
        createGrid();
    }

    public void createGrid(){
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

    public char[][] getGrid(){
        return this.grid;
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