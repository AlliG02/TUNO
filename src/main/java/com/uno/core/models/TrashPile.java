package com.uno.core.models;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class TrashPile {

    private ArrayList<Card> trash;

    public TrashPile(){
        trash = new ArrayList<>();
    }

    public void addToTrash(Card usedCard){
        trash.add(usedCard);
    }

    // see trash pile for debug purposes
    public void showTrash(){
        if (!trash.isEmpty()){
            for (Card card : trash){
                card.showCard();
            }
        }
        else{
            System.out.println("Trash pile is empty");
        }
    }

    public void shuffleTrash(){
        Collections.shuffle(trash);
    }

    public ArrayList<Card> getTrash(){
        return trash;
    }

    public boolean trashIsEmpty(){
        return trash.isEmpty();
    }

}