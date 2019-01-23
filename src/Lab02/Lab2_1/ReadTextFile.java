package Lab02.Lab2_1;

import java.util.*;
import java.io.*;

public class ReadTextFile {
    public static void main(String[] args) {
        try {
            String line;
            String filename = args[0];
            Scanner fin = new Scanner(new File(filename));
            while (fin.hasNextLine()) {
                line = fin.nextLine();
                System.out.println(line);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Usage: java ReadTextFile <filename>");
        } catch (FileNotFoundException e) {
            System.out.println("Failed to open file " + args[0]);
        }
    }
}

