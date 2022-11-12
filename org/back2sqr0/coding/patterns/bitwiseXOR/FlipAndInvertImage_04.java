package org.back2sqr0.coding.patterns.bitwiseXOR;

/*
Problem Statement:

Given a binary matrix representing an image, we want to flip the image horizontally, then invert it.

To flip an image horizontally means that each row of the image is reversed. For example, flipping [0, 1, 1] horizontally results in [1, 1, 0].

To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [1, 1, 0] results in [0, 0, 1].

Example 1:

Input: [
  [1,0,1],
  [1,1,1],
  [0,1,1]
]
Output: [
  [0,1,0],
  [0,0,0],
  [0,0,1]
]
Explanation: First reverse each row: [[1,0,1],[1,1,1],[1,1,0]]. Then, invert the image: [[0,1,0],[0,0,0],[0,0,1]]

Example 2:

Input: [
  [1,1,0,0],
  [1,0,0,1],
  [0,1,1,1],
  [1,0,1,0]
]
Output: [
  [1,1,0,0],
  [0,1,1,0],
  [0,0,0,1],
  [1,0,1,0]
]
Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]. Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]

 */
public class FlipAndInvertImage_04 {
    public static int[][] flipAndInvertImage(int[][] arr) {

        /*
        Time Complexity: The time complexity of this solution is O(n) as we iterate through all elements of the input.
        Space Complexity: The space complexity of this solution is O(1)
        */
        int C = arr[0].length;
        for (int[] row: arr) {
            for (int i = 0; i < (C + 1) / 2; ++i) {
                int tmp = row[i] ^ 1;
                row[i] = row[C - 1 - i] ^ 1;
                row[C - 1 - i] = tmp;
            }
        }
        return arr;

        /*
          Iteration 1:
        int[][] result = new int[arr.length][arr[0].length];
        //For Each Row
        for(int i=0; i< arr.length; i++){
            int[] row = arr[i];

            //Flip -- reversing each row
            for(int x = 0, y=row.length -1; x < y; x++, y--){
                int temp = row[x];
                row[x] = row[y];
                row[y] = temp;
            }

            //Invert -- complement
            for(int k = 0; k < row.length; k++){
                row[k] ^= 1;
            }

            result[i] =  row;
        }

        return result;
        */
    }

    public static void print(int[][] arr) {
        for(int i=0; i < arr.length; i++) {
            for (int j=0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 0, 1}, {1, 1, 1}, {0, 1, 1}};
        print(flipAndInvertImage(arr));

        int[][]arr2 = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
        print(flipAndInvertImage(arr2));
    }

}
