/**
 * This example code calculates EMI for a month for Mortgage loan
 *
 * formula : principal * ( (interest_rate * (1 + interest_rate) ^ tenure_months) / (((1 + interest_rate) ^ tenure_months) - 1) )
 *
 * @author Yashwanth
 */
package com.solution;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {

    public static void main(String [] args) {

        System.out.println("=====================================================");
        System.out.println("               MORTGAGE EMI CALCULATOR");
        System.out.println("=====================================================");
        System.out.println("Please enter the details to  calculate Mortgage...");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal: ");
        int principal = scanner.nextInt();

        System.out.print("Annual Interest Rate (in %): ");
        float annualRate = scanner.nextFloat();
        float monthlyRate = (annualRate / 100) / 12;

        System.out.print("Period (Years): ");
        byte tenure = scanner.nextByte();
        int tenureInMOnths = tenure * 12;


        double result = principal * ((monthlyRate * Math.pow((1 + monthlyRate), tenureInMOnths)) / (Math.pow((1 + monthlyRate), tenureInMOnths) - 1));
        System.out.println("Mortgage EMI is = " + NumberFormat.getCurrencyInstance().format(result));
    }
}
