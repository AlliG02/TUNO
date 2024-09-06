package com.uno.core.models;

public enum Colour {

    RED("Red", "\u001B[31m"),
    BLUE("Blue", "\u001B[34m"),
    GREEN("Green", "\u001B[32m"),
    YELLOW("Yellow", "\u001B[33m");

    private final String name;
    private final String ansiCode;

    Colour(String name, String ANSI) {
        this.name = name;
        this.ansiCode = ANSI;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getAnsiCode() {
        return ansiCode;
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
