package Assignment;

import java.io.*;
import java.util.*;

public class EncryptionAlgorithm {
    public void runAlgorithm(String[] args) {
        String option = "";
        String message = "";
        LinkedList deck = null;

        try {
            option = args[0];
            deck = readDeckFile(args[1]);
            message = processMessage(args[2]);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Usage: java SolitaireEncryption [option] [deck_file] [message_string]");
            System.exit(1);
        } catch (FileNotFoundException | WrongCardNumberException | WrongDeckLengthException | DuplicateCardException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        switch (option) {
            case "keygen":
                deck.displayKeyGeneration(message.length());
                break;
            case "en":
                deck.displayEncryption(message);
                break;
            case "de":
                deck.displayDecryption(message);
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
        //check if the deck contain invalid card number, duplicate card or wrong deck length

        int[] deck = new int[28];
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


        //check if the deck contain duplicate card
        Arrays.sort(deck);

        for (int i = 0; i < 28; i++) {
            if (deck[i] != (i + 1))
                throw new DuplicateCardException();
        }
    }
}
