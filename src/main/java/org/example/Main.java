package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println(isPalindrome(-1221)); // true
        System.out.println(isPalindrome(707));   // true
        System.out.println(isPalindrome(11212)); // false

        System.out.println(isPerfectNumber(6));  // true
        System.out.println(isPerfectNumber(28)); // true
        System.out.println(isPerfectNumber(5));  // false
        System.out.println(isPerfectNumber(-1)); // false

        System.out.println(numberToWords(123));  // One Two Three
        System.out.println(numberToWords(1010)); // One Zero One Zero
        System.out.println(numberToWords(-12));  // Invalid Value
    }

    // Palindrom Sayıyı Bulma Metodu
    public static boolean isPalindrome(int number) {
        number = Math.abs(number);
        int reversed = 0;
        int original = number;

        while (number != 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10;
        }

        return original == reversed;
    }

    // Mükemmel Sayıları Bulma Metodu
    public static boolean isPerfectNumber(int number) {
        if (number < 0) {
            return false;
        }

        int sum = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }

        return sum == number;
    }

    // Sayıları Kelimelere Dök Metodu
    public static String numberToWords(int number) {
        if (number < 0) {
            return "Invalid Value";
        }

        if (number == 0) {
            return "Zero";
        }

        int reversedNumber = reverse(number);
        int originalDigitCount = getDigitCount(number);
        int reversedDigitCount = getDigitCount(reversedNumber);

        StringBuilder words = new StringBuilder();

        while (reversedNumber > 0) {
            int digit = reversedNumber % 10;
            words.append(getWord(digit)).append(" ");
            reversedNumber /= 10;
        }

        for (int i = 0; i < (originalDigitCount - reversedDigitCount); i++) {
            words.append("Zero ");
        }

        return words.toString().trim();
    }

    public static int reverse(int number) {
        int reversed = 0;
        while (number != 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10;
        }
        return reversed;
    }

    public static int getDigitCount(int number) {
        if (number == 0) {
            return 1;
        }
        int count = 0;
        while (number > 0) {
            number /= 10;
            count++;
        }
        return count;
    }

    public static String getWord(int digit) {
        switch (digit) {
            case 0: return "Zero";
            case 1: return "One";
            case 2: return "Two";
            case 3: return "Three";
            case 4: return "Four";
            case 5: return "Five";
            case 6: return "Six";
            case 7: return "Seven";
            case 8: return "Eight";
            case 9: return "Nine";
            default: return "";
        }
    }
}
