/* *****************************************************************************
 *  Name:              Fernando Rubio
 *  Coursera User ID:  99f10e17bd6b7e7f61d187b45df23273
 *  Last modified:     29/01/2025
 **************************************************************************** */

package test.chapter1.three;

import edu.princeton.cs.algs4.Stack;

public class Parenthesis {

    static boolean validateBalance(String input) {
        // if (input.allowerdCharacters("{}()[]")) {
        //     throw new IllegalArgumentException("");
        // }

        Stack<Character> characterStack = new Stack<>();
        for (char c : input.toCharArray()) {
            if (c == '[' || c == '(' || c == '{') {
                characterStack.push(c);
            }
            else if (c == ']' || c == ')' || c == '}') {
                if (characterStack.isEmpty()) {
                    return false;
                }

                char lastChar = characterStack.pop();

                if (!((lastChar == '{' && c == '}') || (lastChar == '[' && c == ']') || (
                        lastChar == '(' && c == ')'))) {
                    return false;
                }
            }

        }
        return true;

    }

    public static void main(String[] args) {
        String input1 = "[()]{}{[()()]()}"; // true
        String input2 = "[(])"; // false\
        System.out.println(validateBalance(input1));
        System.out.println(validateBalance(input2));

    }
}
