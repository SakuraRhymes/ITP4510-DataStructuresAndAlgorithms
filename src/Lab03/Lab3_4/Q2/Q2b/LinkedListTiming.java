package Lab03.Lab3_4.Q2.Q2b;

import java.io.*;
import java.util.*;

public class LinkedListTiming {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        try {
            Scanner fin = new Scanner(new File(args[0]));
            String line;
            while (fin.hasNextLine()) {
                line = fin.nextLine();
                line = line.trim();
                list.addToTail(line);

            }
            fin.close();
            long startTime = System.nanoTime();
            String ans = list.search(args[1]);
            long endTime = System.nanoTime();
            if (ans == null)
                System.out.println("Not found; Time used: " + (endTime - startTime));
            else
                System.out.println("Found; Time used: " + (endTime - startTime));
        } catch (FileNotFoundException e) {
            System.out.println("Failed to open " + args[0]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Usage: LinkedListTiming <word_file> <search_word>");
        }
    }
}

