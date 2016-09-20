package com.anthony;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Random;

/*
  Imagine you are writing a program that plays a card game. In one part of the
  program, you will need a deck of cards from which random cards are drawn. Write a program
  that can simulate a shuffled deck of cards. Use a data structure to store each of the cards
  in a standard deck of cards. Your program should be able to deal a card at random from the deck.
 */

public class Main {
    private static Scanner numberScanner = new Scanner(System.in);
    private static Scanner stringScanner = new Scanner(System.in);
    private static Random randomNumber = new Random();
    public static void main(String[] args) {
        // Draw how many cards?
        int drawAmount = 5;
        // Create deck data structure
        ArrayList<String> deck = new ArrayList<String>();
        // Add cards to deck at random
        createDeck(deck);
        // Draw random cards
        for (int i = 0; i < drawAmount; i++) {
            String cardDraw = drawCard(deck);
            System.out.println("You drew a " + cardDraw);
        }
        numberScanner.close();
        stringScanner.close();
    }

    private static String drawCard(ArrayList<String> deck) {
        int randomCard = randomNumber.nextInt(deck.size());
        return deck.get(randomCard);
    }

    // Method to create deck
    private static void createDeck(ArrayList<String> deck) {
        // Generate suit and card
        int suit = 0;
        int card = 1;
        while (true) {
            // Get random suit
            String suitLetter;
            if (suit == 0) {
                suitLetter = "Hearths";
            } else if (suit == 1) {
                suitLetter = "Diamonds";
            } else if (suit == 2) {
                suitLetter = "Clubs";
            } else {
                suitLetter = "Spades";
            }
            while (true) {
                // Get random card value
                String cardFace;
                if (card == 1) {
                    cardFace = "Ace of ";
                    card ++;
                } else if (card > 1 && card < 11) {
                    cardFace = (card + " of ");
                    card ++;
                } else if (card == 11) {
                    cardFace = "Jack of ";
                    card ++;
                } else if (card == 12) {
                    cardFace = "Queen of ";
                    card ++;
                } else {
                    cardFace = "King of ";
                    card = 1;
                    suit ++;
                }
                deck.add(cardFace + suitLetter);
                if (cardFace.equalsIgnoreCase("King of ")){
                    break;
                }
            }
            if (suit == 4){
                break;
            }
        }
    }
}
