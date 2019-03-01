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
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        if (option.equals("keygen")) {
            deck.displayKeyGeneration(message_string.length());
        }
    }

    public static String processMessage(String message) {
        String result = "";
        for (char c : message.toCharArray()) {
            if (Character.isLetter(c)) {
                result += Character.toUpperCase(c);
            }
        }
        return result;
    }

    public static LinkedList readDeckFile(String deckFilePath) throws FileNotFoundException {
        LinkedList deck = new LinkedList();
        Scanner file = new Scanner(new File(deckFilePath));
        while (file.hasNextInt()) {
            deck.addToTail(file.nextInt());
        }
        return deck;
    }
}
