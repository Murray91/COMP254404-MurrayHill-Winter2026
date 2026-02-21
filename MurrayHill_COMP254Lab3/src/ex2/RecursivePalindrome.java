package ex2;

/**
 * Exercise 2
 * Determines if a string is a palindrome using recursion.
 */
public class RecursivePalindrome {

    public static boolean isPalindrome(String s) {

        // Base case
        if (s.length() <= 1) {
            return true;
        }

        // If first and last characters don't match
        if (s.charAt(0) != s.charAt(s.length() - 1)) {
            return false;
        }

        // Recursive case: remove first and last characters
        return isPalindrome(s.substring(1, s.length() - 1));
    }
}