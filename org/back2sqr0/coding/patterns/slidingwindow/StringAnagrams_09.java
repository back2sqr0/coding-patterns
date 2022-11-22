package org.back2sqr0.coding.patterns.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
String Anagrams: Given a string and a pattern, find all anagrams of the pattern in the given string.

Every anagram is a permutation of a string. As we know, when we are not allowed to repeat characters while finding permutations of a string, we get N!
permutations (or anagrams) of a string having N characters. For example, here are the six anagrams of the string “abc”:

abc
acb
bac
bca
cab
cba

Write a function to return a list of starting indices of the anagrams of the pattern in the given string.

Example 1:
Input: String="ppqp", Pattern="pq"
Output: [1, 2]
Explanation: The two anagrams of the pattern in the given string are "pq" and "qp".

Example 2:
Input: String="abbcabc", Pattern="abc"
Output: [2, 3, 4]
Explanation: The three anagrams of the pattern in the given string are "bca", "cab", and "abc".

Solution#
This problem follows the Sliding Window pattern and is very similar to Permutation in a String.
In this problem, we need to find every occurrence of any permutation of the pattern in the string.
We will use a list to store the starting indices of the anagrams of the pattern in the string.

Time Complexity#
The time complexity of the above algorithm will be O(N + M) where ‘N’ and ‘M’ are the number of characters
in the input string and the pattern respectively.

Space Complexity#
The space complexity of the algorithm is O(M) since in the worst case, the whole pattern can have distinct
characters which will go into the HashMap. In the worst case, we also need O(N) space for the result list,
this will happen when the pattern has only one character and the string contains only that character.

 */
public class StringAnagrams_09 {

    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List resultIndices = new ArrayList<Integer>();

        int windowStart = 0, matched = 0;
        Map<Character, Integer> frequenceyCharMap = new HashMap<>();
        for(char letter : pattern.toCharArray())
            frequenceyCharMap.put(letter,frequenceyCharMap.getOrDefault(letter,0) + 1);

        // our goal is to match all the characters from the 'charFrequencyMap' with the current window
        // try to extend the range [windowStart, windowEnd]
        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++){
            char rightChar = str.charAt(windowEnd);

            if(frequenceyCharMap.containsKey(rightChar)){
                frequenceyCharMap.put(rightChar, frequenceyCharMap.get(rightChar) - 1);
                if(frequenceyCharMap.get(rightChar) == 0)  //Character is completely matched
                    matched++;
            }

            if(matched == frequenceyCharMap.size()){
                resultIndices.add(windowStart);
            }

            if(windowEnd >= pattern.length() - 1){ // shrink the window by one character
                char leftChar = str.charAt(windowStart);

                if(frequenceyCharMap.containsKey(leftChar)){
                    if(frequenceyCharMap.get(leftChar) == 0)
                        matched--; // before putting the character back, decrement the matched count

                    // put the character back for matching
                    frequenceyCharMap.put(leftChar,frequenceyCharMap.get(leftChar)+1);
                }

                windowStart++;
            }


        }

        return resultIndices;
    }

    public static void main(String[] args){
        System.out.println(StringAnagrams_09.findStringAnagrams("ppqp","pq"));
        System.out.println(StringAnagrams_09.findStringAnagrams("abbcabc","abc"));
    }

}
