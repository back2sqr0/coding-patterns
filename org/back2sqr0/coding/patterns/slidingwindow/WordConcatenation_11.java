package org.back2sqr0.coding.patterns.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Words Concatenation:
Given a string and a list of words, find all the starting indices of substrings in the given string that are a
concatenation of all the given words exactly once without any overlapping of words. It is given that all words are of the same length.

Example 1:
Input: String="catfoxcat", Words=["cat", "fox"]
Output: [0, 3]
Explanation: The two substring containing both the words are "catfox" & "foxcat".

Example 2:
Input: String="catcatfoxfox", Words=["cat", "fox"]
Output: [3]
Explanation: The only substring containing both the words is "catfox".

 */
public class WordConcatenation_11 {

    public static List<Integer> findWordConcatenation(String str, String[] words) {
        List resultIndices = new ArrayList<Integer>();

        int wordLength = words[0].length();
        int windowStart = 0, matched = 0;
        Map<String, Integer> wordFrequenceyMap = new HashMap<>();

        for(String word : words)
            wordFrequenceyMap.put(word, wordFrequenceyMap.getOrDefault(word,0) + 1);


        for(int windowEnd = 0; windowEnd < str.length(); windowEnd += wordLength){
            String rightWord = str.substring(windowEnd, windowEnd+wordLength);

            if(wordFrequenceyMap.containsKey(rightWord)){
                wordFrequenceyMap.put(rightWord, wordFrequenceyMap.get(rightWord) - 1);

                if(wordFrequenceyMap.get(rightWord) == 0){
                    matched++;
                }

            }

            if(matched == wordFrequenceyMap.size()){
                resultIndices.add(windowStart);
                windowEnd += wordLength;
            }


            if( (windowEnd - windowStart + 1) >= words.length * wordLength){
                String leftWord = str.substring(windowStart, windowStart+wordLength);

                if(wordFrequenceyMap.containsKey(leftWord)) {

                    if(wordFrequenceyMap.get(leftWord) == 0)
                        matched--;

                    wordFrequenceyMap.put(leftWord, wordFrequenceyMap.get(leftWord) + 1);
                }

                windowStart += wordLength;
                windowEnd -= wordLength;
            }
        }

        return resultIndices;
    }

    public static void main(String[] args){
        System.out.println(WordConcatenation_11.findWordConcatenation("catfoxcat", new String[]{"cat", "fox"}));
        System.out.println(WordConcatenation_11.findWordConcatenation("catcatfoxfox", new String[]{"cat", "fox"}));
    }
}
