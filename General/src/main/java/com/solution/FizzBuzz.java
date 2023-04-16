/**
 * Fizz buzz is a group word game for children to teach them about division. Players take turns to count incrementally,
 * replacing any number divisible by three with the word "fizz", and any number divisible by five with the word "buzz",
 * and any number divisible by both 3 and 5 with the word "fizzbuzz"
 *
 * @author Yashwanth
 *
 */
package com.solution;

import java.util.Scanner;

public class FizzBuzz {

    public static void main(String[] args) {
        System.out.println("==================");
        System.out.println("     FizzBuzz");
        System.out.println("==================");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter FizzBuzz number: ");
        int givenNumber = scanner.nextInt();

        boolean divisibleByThree = (givenNumber % 3) == 0;
        boolean divisibleByFive = (givenNumber % 5) == 0;

        var result = divisibleByThree && divisibleByFive ? "FizzBuzz" :
            divisibleByFive ? "Fizz" : divisibleByThree ? "Buzz" : String.valueOf(givenNumber);
        System.out.println(result);
    }
}
