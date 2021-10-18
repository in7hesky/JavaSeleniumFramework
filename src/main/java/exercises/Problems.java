package exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Problems {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //formattedOutput();
        //dollarGame();
        //rollADie();
        countFees();
    }

    //1. Java Fundamentals Problem
    public static void formattedOutput() {

        int year, wholeNum;
        String adjective = "";

        System.out.print("Year: ");
        year = scanner.nextInt();
        System.out.print("Whole Number: ");
        wholeNum = scanner.nextInt();
        System.out.print("Adjective: ");
        adjective = scanner.next();

        System.out.printf("In a %s winter morning of %d I drank %d cups of coffee%n",
                adjective, year, wholeNum);
    }

    //2. Relational and Logical Operators Problem
    public static void dollarGame() {
        double target = 100;
        double[] valuesInCents = {1, 5, 10, 25};
        // 0.01, 0.05, 0.10, 0.25
        System.out.println("Choose amount of:\npennies, nickels, dimes, quarters\naccordingly: ");
        double totalInDollars = 0;
        for (int i = 0; i < 4; i++) {
            totalInDollars += scanner.nextInt() * valuesInCents[i];
        };

        if (totalInDollars == target) {
            System.out.println("You win");
        } else if (target < totalInDollars) {
            System.out.println("Too much money: " + (totalInDollars - target));
        } else {
            System.out.println("Not enough money: " + (target - totalInDollars));
        }
    }

    //3. Loops Problem
    public static void rollADie() {
        int spaces = 20;
        int currentPosition = 0;
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            currentPosition += random.nextInt(6) + 1;

            if (currentPosition > 20)
                break;

            System.out.println("You're on space " + currentPosition + " \\ Left to win: " + (spaces - currentPosition));
            if (currentPosition == spaces) {
                System.out.println("You win");
                return;
            }
        }

        System.out.println("You lost");

    }

    //4. -------Variables Scope Problem START------
    public static void countFees() {
        System.out.print("Enter base cost of the plan: ");
        double planFee = scanner.nextDouble();
        System.out.print("Enter overage minutes amount: ");
        int overageMinutes = scanner.nextInt();

        double overageFee = countOverageFee(overageMinutes);
        double subtotalTax = countSubtotalTax(planFee + overageFee);

        System.out.println("--Phone Bill Statement--\n" +
                "Plan: " + planFee + "\nOverage: " + overageFee + "\nTax: " + subtotalTax +
                "\nTotal: " + countFinalTotal(planFee, overageFee, subtotalTax) + "$" );
    }

    private static double countFinalTotal(double planFee, double overageFee, double subtotalTax) {
        return planFee + overageFee + subtotalTax;
    }

    private static double countOverageFee(int minutes) {
        double chargeForMinute = 0.25;
        return minutes * chargeForMinute;
    }

    private static double countSubtotalTax(double subtotal) {
        double charge = 0.15;
        return (double)Math.round(subtotal * 0.15 * 10) / 10;
    }

    //-------Variables Scope Problem END------------

    //5. Overloading Methods within a Class [billcalc package] ...

    //6.


}
