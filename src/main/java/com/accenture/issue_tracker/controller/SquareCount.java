package com.accenture.issue_tracker.controller;

import java.util.ArrayList;
import java.util.List;

public class SquareCount {

    public static int countSquares(String s) {
        int squareCount = 0;
        int length = s.length();

        // Iterate through the string
        for (int i = 0; i < length - 3; i++) {
            for (int j = i + 4; j <= length; j++) {
                // Check for consecutive identical sub-words
                if (j + 4 <= length && s.substring(i, i + 4).equals(s.substring(j, j + 4))) {
                    squareCount++;
                }
            }
        }
        return squareCount;
    }

    public static void main(String[] args) {
        String string = "33112244";
        int numSquares = countSquares(string);
        System.out.println(numSquares);
    }
}