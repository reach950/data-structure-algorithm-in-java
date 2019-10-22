package com.example.data_structure_and_algorithm;

public class ValidAnagram {

    public static void main(String[] args) {
        String s = "rat";
        String t = "car";
        System.out.println(new ValidAnagram().isAnagram(s, t));
    }

    public boolean isAnagram(String s, String t) {
        int[] array = new int[26];
        for (char c : s.toCharArray()) {
            array[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            array[c - 'a']--;
        }
        for (int i : array) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}