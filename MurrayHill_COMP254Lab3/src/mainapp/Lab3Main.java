package mainapp;

import ex1.RecursiveProduct;
import ex2.RecursivePalindrome;
import ex3.RecursiveFileFinder;

import java.util.Scanner;

/**
 * Main driver program for COMP254 Lab 3.
 * Provides a menu to run all recursive exercises.
 */
public class Lab3Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\n=== COMP254 Lab 3 – Recursion ===");
            System.out.println("1. Recursive Product");
            System.out.println("2. Palindrome Checker");
            System.out.println("3. Recursive File Finder");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice;

            // Input validation
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // consume newline
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                continue;
            }

            switch (choice) {

                case 1:
                    System.out.print("Enter first positive integer (m): ");
                    int m = scanner.nextInt();

                    System.out.print("Enter second positive integer (n): ");
                    int n = scanner.nextInt();
                    scanner.nextLine();

                    int result = RecursiveProduct.recursiveProduct(m, n);

                    System.out.println("Product of " + m + " and " + n + " is: " + result);
                    break;

                case 2:
                    System.out.print("Enter a string: ");
                    String input = scanner.nextLine();

                    boolean isPal = RecursivePalindrome.isPalindrome(input);

                    if (isPal) {
                        System.out.println("\"" + input + "\" is a palindrome.");
                    } else {
                        System.out.println("\"" + input + "\" is NOT a palindrome.");
                    }
                    break;

                case 3:
                    System.out.print("Enter directory path: ");
                    String path = scanner.nextLine();

                    System.out.print("Enter filename to search for: ");
                    String filename = scanner.nextLine();

                    RecursiveFileFinder.find(path, filename);
                    break;

                case 4:
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please select 1-4.");
            }
        }
    }
}