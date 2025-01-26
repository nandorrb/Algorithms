/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package test.chapter1.three;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class InfixToPostFix {

    /**
     * Convert Infix expression to Postfix expression
     * Last Updated : 06 Dec, 2024
     * Write a program to convert an Infix expression to Postfix form.
     * <p>
     * Infix expression: The expression of the form “a operator b” (a + b) i.e., when an operator is
     * in-between every pair of operands.
     * Postfix expression: The expression of the form “a b operator” (ab+) i.e., When every pair of
     * operands is followed by an operator.
     * <p>
     * Examples:
     * <p>
     * Input: A + B * C + D
     * Output: ABC*+D+
     * <p>
     * <p>
     * Input: ((A + B) – C * (D / E)) + F
     * Output: AB+CDE/*-F+
     *
     * @param infixExpression
     * @return posfixExpression
     */
    static String convert(String infixExpression) {
        Stack<String> stringStack = new Stack<>();
        String cleanInfixExpression = infixExpression.replace(" ", "");

        // First loop ,  processses * and /
        boolean priorityOperation = false;
        for (char c : cleanInfixExpression.toCharArray()) {
            stringStack.push(String.valueOf(c));

            if (c == '*' || c == '/') {
                priorityOperation = true;
            }
            else if (priorityOperation) {
                priorityOperation = false;
                processExpression(stringStack);
            }
        }

        // Second loop, processes + and -
        while (stringStack.size() > 2) {
            processExpression(stringStack);
        }

        return stringStack.toString().replace(" ", "");
    }

    static String convertWithParenthesis(String infixExpression) {
        Stack<String> stringStack = new Stack<>();
        String cleanInfixExpression = infixExpression.replace(" ", "");
        // First loop ,  processses * and /
        for (char c : cleanInfixExpression.toCharArray()) {
            if (c == ')') {
                processExpression(stringStack);
            }
            else if (c == '(') {
                /// nothing
            }
            else {
                stringStack.push(String.valueOf(c));
            }
        }

        // Second loop, processes + and -
        while (stringStack.size() > 2) {
            processExpression(stringStack);
        }

        return stringStack.toString().replace(" ", "");
    }

    private static void processExpression(Stack<String> stringStack) {
        if (stringStack.size() > 2) {
            String b = stringStack.pop();
            String operator = stringStack.pop();
            String a = stringStack.pop();
            String expression = a + b + operator;
            stringStack.push(expression);
        }
    }

    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();


        String input = "A + B * C + D";
        System.out.println(input);
        System.out.println("ABC*+D+");
        System.out.println(convert(input));
        System.out.println("-----------------");
        input = "A + B - C * D + E / F + G * H - I + J * K";
        System.out.println(input);
        System.out.println("AB+CD*-EF/+GH*+I-JK*+");
        System.out.println(convert(input));
        System.out.println("-----------------");
        input = "((A + B) – ( C * (D / E) ) ) + F";
        System.out.println(input);
        System.out.println("AB+CDE/*-F+");
        System.out.println(convertWithParenthesis(input));

        System.out.println("-----------------");
        input = "((A + ((B * C) + D)) – (C * (D / E))) + F";
        System.out.println(input);
        System.out.println("AB+CDE/*-F+");
        System.out.println(convertWithParenthesis(input));
    }
}
