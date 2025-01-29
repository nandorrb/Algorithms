/* *****************************************************************************
 *  Name:              Fernando Rubio
 *  Coursera User ID:  99f10e17bd6b7e7f61d187b45df23273
 *  Last modified:     29/01/2025
 **************************************************************************** */

package test.chapter1.three;

import edu.princeton.cs.algs4.Stack;

public class Nine {

    public static void main(String[] args) {
        String input = "1+2)*3-4)*5-6)))";

        // ((1+2)*((3-4)*(5-6)))"; true
        // (((1+2)*(3-4)*(5-6)))"; false
        // (1+2)*(((3-4)*(5-6)))"; false
        System.out.println(input);
        System.out.println(convert(input));
    }

    /**
     * Write a program that takes from standard input an expression without left
     * parentheses and prints the equivalent infix expression with the parentheses
     * inserted. For example, given the input:
     * 1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )
     * your program should print:
     * ( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )
     */
    private static String convert(String input) {
        Stack<String> characterStack = new Stack<>();
        for (char c : input.toCharArray()) {
            // if c == ')' , then pop 3 from stack and merge into parenthesis
            if (c == ')') {
                String a = characterStack.pop();
                String operator = characterStack.pop();
                String b = characterStack.pop();
                String expression = "(" + b + operator + a + ")";
                characterStack.push(expression);
            }
            else {
                characterStack.push(String.valueOf(c));
            }

        }

        return characterStack.toString();
    }
}
