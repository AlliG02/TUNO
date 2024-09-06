package com.uno.core.models;

public enum Colour {

    RED("Red"),
    BLUE("Blue"),
    GREEN("Green"),
    YELLOW("Yellow");

    private final String name;

    Colour(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public static Colour fromString(String colourName) {
        for (Colour colour : Colour.values()) {
            if (colour.name.equalsIgnoreCase(colourName)) {
                return colour;
            }
        }
        throw new IllegalArgumentException("Invalid colour: " + colourName);
    }

}
