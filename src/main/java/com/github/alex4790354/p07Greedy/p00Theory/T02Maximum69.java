package com.github.alex4790354.p07Greedy.p00Theory;

/** You are given a positive integer num consisting only of digits 6 and 9.
 *  Return the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6).

 *  Input: num = 9669. Output: 9969
 *  Input: num = 9996. Output: 9999
 *  Input: num = 9999. Output: 9999

 *  TODO: reDo this
 */
public class T02Maximum69 {

    public static void main(String[] args) {

        T02Maximum69 test = new T02Maximum69();
        // Примеры использования
        System.out.println(test.solution2(9669)); // Ожидаемый результат: 9969
        System.out.println(test.solution(9996)); // Ожидаемый результат: 9999
        System.out.println(test.solution(9999)); // Ожидаемый результат: 9999
    }

    private int solution(int num) {
        String numStr = Integer.toString(num);
        char[] numArray = numStr.toCharArray();

        for (int i = 0; i < numArray.length; i++) {
            if (numArray[i] == '6') {
                numArray[i] = '9';
                break;
            }
        }

        return Integer.parseInt(new String(numArray));
    }

    private int solution2(int num) {
        String numStr = Integer.toString(num);
        char[] numArray = numStr.toCharArray();

        for (int i = 0; i < numArray.length; i++) {
            if (numArray[i] == '6') {
                numArray[i] = '9';
                System.out.println("i: " + i);
                break;
            }
        }
        return Integer.parseInt(new String(numArray));
    }

}
