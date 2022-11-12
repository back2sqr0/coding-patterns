package org.back2sqr0.coding.patterns.bitwiseXOR;

/*
  Given an array of n-1 integers in the range from 1 to n, find the one number that is missing from the array.

  The straight forward way to solve this problem by
        1. Find the sum of all integers from 1 to n; let’s call it s1.
        2. Subtract all the numbers in the input array from s1; this will give us the missing number.

  To Avoid Integer Overflow - While finding the sum of numbers from 1 to n, we can get integer overflow when n is large. - Using XOR operator

  The important property of XOR that it returns 0 if both the bits in comparison are the same.
  In other words, XOR of a number with itself will always result in 0. This means that if we XOR all the numbers in the input array
  with all numbers from the range 1 to n then each number in the input is going to get zeroed out except the missing number.

    1. XOR all the numbers from 1 to n, let’s call it x1.
    2. XOR all the numbers in the input array, let’s call it x2.
    3. The missing number can be found by x1 XOR x2.

Following are some important properties of XOR to remember:

    Taking XOR of a number with itself returns 0, e.g.,

        1 ^ 1 = 0
        29 ^ 29 = 0

    Taking XOR of a number with 0 returns the same number, e.g.,

        1 ^ 0 = 1
        31 ^ 0 = 31

    XOR is Associative & Commutative, which means:

    (a ^ b) ^ c = a ^ (b ^ c)
    a ^ b = b ^ a

 */
public class MissingNumber_00 {
    public static int findMissingNumber(int[] arr) {
        int n = arr.length + 1;
        // find XOR of all numbers from 1 to n.
        int x1 = 1;
        for (int i = 2; i <= n; i++)
            x1 = x1 ^ i;

        // x2 represents XOR of all values in arr
        int x2 = arr[0];
        for (int i = 1; i < n-1; i++)
            x2 = x2 ^ arr[i];

        // missing number is the xor of x1 and x2
        return x1 ^ x2;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 5, 2, 6, 4 };
        System.out.print("Missing number is: " + MissingNumber_00.findMissingNumber(arr));
    }
}
