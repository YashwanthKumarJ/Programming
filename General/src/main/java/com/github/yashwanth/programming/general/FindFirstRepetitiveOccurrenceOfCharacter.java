/**
 * This class provides solution to programming question generally asked in interviews (asked in
 * Google).
 *
 * For a given string with English alphabets, we need to find out if any character is repetitive.
 * If so, return the first character which was found.
 *
 * ABC  - Null  // No repetition
 * ABCB - B
 * CBADBEAF - B  // There are two repetition but we need to return first occurrence
 */
package com.github.yashwanth.programming.general;

import java.util.HashSet;
import java.util.Scanner;

public class FindFirstRepetitiveOccurrenceOfCharacter {
    private static final int NUMBER_OF_CHAR_IN_ENGLISH = 26;

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String givenString = scanner.next();
        Character ch = findFirstRepetitiveOccurrence(givenString);
        System.out.println(ch);
    }
    public static Character findFirstRepetitiveOccurrence(String str) {
        HashSet<Character> uniqueCharSet = new HashSet<>(NUMBER_OF_CHAR_IN_ENGLISH);
        for (int i=0; i<str.length(); i++) {
            Character currentChar = str.charAt(i);
            if (uniqueCharSet.contains(currentChar)) {
                return currentChar;
            }

            uniqueCharSet.add(currentChar);
        }

        return null;
    }
}
