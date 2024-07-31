package com.github.alex4790354.p01ArraysAndStrings.p00Theory;

public class Task06ReverseString {

    public static void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            // Обмен элементов
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            // Сдвиг указателей
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
        System.out.println(java.util.Arrays.toString(s)); // [o, l, l, e, h]
    }

}
