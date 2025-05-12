package com.mycompany.lab18_2b;

import java.util.*;
import java.io.*;

public class Lab18_2B {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java Lab18_2B <input-file>");
            System.exit(1);
        }

        List<String> words = new ArrayList<>();
        try (Scanner infile = new Scanner(new File(args[0]))) {
            while (infile.hasNext()) {
                words.add(infile.next());
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + args[0]);
            System.exit(1);
        }

        // Print all words
        RecPrint(words, 0);
        System.out.println();
        
        // Count and print words starting with 's' or 'S'
        int count = sCount(words, 0);
        System.out.println("\nCount of words that start with 's' or 'S': " + count);
    }

    public static void RecPrint(List<String> list, int index) {
        if (index >= list.size()) {
            return;
        }
        System.out.print(list.get(index) + " ");
        RecPrint(list, index + 1);
    }

    public static int sCount(List<String> list, int index) {
        if (index >= list.size()) {
            return 0;
        }
        String w = list.get(index);
        char first = Character.toLowerCase(w.charAt(0));
        if (first == 's') {
            System.out.println(w);
            return 1 + sCount(list, index + 1);
        } else {
            return sCount(list, index + 1);
        }
    }
}
