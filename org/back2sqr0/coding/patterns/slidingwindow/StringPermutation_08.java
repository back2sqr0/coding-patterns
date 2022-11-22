package org.back2sqr0.coding.patterns.slidingwindow;

/*
Permutation in a String (hard)#

Given a string and a pattern, find out if the string contains any permutation of the pattern.

Permutation is defined as the re-arranging of the characters of the string. For example, “abc” has the following six permutations:

abc
acb
bac
bca
cab
cba

If a string has ‘n’ distinct characters, it will have n! permutations.

Example 1:
Input: String="oidbcaf", Pattern="abc"
Output: true
Explanation: The string contains "bca" which is a permutation of the given pattern.

Example 2:
Input: String="odicf", Pattern="dc"
Output: false
Explanation: No permutation of the pattern is present in the given string as a substring.
Example 3:

Input: String="bcdxabcdy", Pattern="bcdyabcdx"
Output: true
Explanation: Both the string and the pattern are a permutation of each other.
Example 4:

Input: String="aaacb", Pattern="abc"
Output: true
Explanation: The string contains "acb" which is a permutation of the given pattern.
 */
public class StringPermutation_08 {

    public static boolean findPermutation(String str, String pattern) {

        int sequenceCount = 0;

        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++){

            String rightChar = Character.toString(str.charAt(windowEnd));
            sequenceCount++;

            if(!pattern.contains(rightChar)){
                sequenceCount = 0;
            }

            //Found permutation of the pattern
            if(sequenceCount == pattern.length()){
                return  true;
            }

        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("Permutation exist: " + StringPermutation_08.findPermutation("oidbcaf", "abc"));
        System.out.println("Permutation exist: " + StringPermutation_08.findPermutation("odicf", "dc"));
        System.out.println("Permutation exist: " + StringPermutation_08.findPermutation("bcdxabcdy", "bcdyabcdx"));
        System.out.println("Permutation exist: " + StringPermutation_08.findPermutation("aaacb", "abc"));
        System.out.println("Permutation exist: " + StringPermutation_08.findPermutation("ppp", "pq")); // Wrong

    }

}
