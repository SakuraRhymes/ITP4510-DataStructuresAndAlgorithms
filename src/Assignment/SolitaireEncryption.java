package Assignment;

import java.io.*;
import java.util.*;

public class SolitaireEncryption {
    public static void main(String[] args) {
        String option = "", message_string = "";
        LinkedList deck = null;

        try {
            option = args[0];
            deck = readDeckFile(args[1]);
            message_string = processMessage(args[2]);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Usage: java SolitaireEncryption [option] [deck_file] [message_string]");
            System.exit(1);
        } catch (FileNotFoundException | WrongCardNumberException | WrongDeckLengthException | DuplicateCardException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        switch (option) {
            case "keygen":
                deck.displayKeyGeneration(message_string.length());
                break;
            case "en":
                deck.displayEncryption(message_string);
                break;
            case "de":
                deck.displayDecryption(message_string);
                break;
            default:
                throw new UnknownOptionException();
        }
    }

    private static String processMessage(String message) {
        //Remove non-letters character and converted all letters into upper-case

        String result = "";
        for (char c : message.toCharArray()) {
            if (Character.isLetter(c)) {
                result += Character.toUpperCase(c);
            }
        }
        return result;
    }

    private static LinkedList readDeckFile(String deckFilePath) throws FileNotFoundException {
        //Convert number in the text file into a linked list

        checkDeckFile(deckFilePath);

        LinkedList deck = new LinkedList();
        Scanner file = new Scanner(new File(deckFilePath));
        while (file.hasNextInt()) {
            deck.addToTail(file.nextInt());
        }

        return deck;
    }

    private static void checkDeckFile(String deckFilePath) throws FileNotFoundException {
        int[] deck = new int[28];
        int[] sampleDeck = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28};
        int cardCount = 0;

        Scanner file = new Scanner(new File(deckFilePath));
        while (file.hasNextInt()) {
            if (cardCount >= 28) {
                throw new WrongDeckLengthException();
            }
            deck[cardCount] = file.nextInt();

            if (deck[cardCount] > 28 || deck[cardCount] < 1)
                throw new WrongCardNumberException();

            cardCount++;
        }

        if (cardCount < 28)
            throw new WrongDeckLengthException();

        Arrays.sort(deck);

        for (int i = 0; i < 28; i++) {
            if (deck[i] != sampleDeck[i])
                throw new DuplicateCardException();
        }
    }
}
