/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package test.chapter1.three;

import edu.princeton.cs.algs4.Stack;

public class EvaluatePostFix {

    /**
     * Write a program EvaluatePostfix that takes a  postfix expression from standard input,
     * evaluates  it and prints the value. (Pipping the output of your program from the previous
     * exercise to this program gives the equivalent behaviour to Evaluate.)
     *
     * @param postfixExpression
     * @return
     */
    static double evaluate(String postfixExpression) {
        Stack<String> ops = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();
        for (char c : postfixExpression.toCharArray()) {
            if (c == '+') {
                Double b = vals.pop();
                Double a = vals.pop();
                vals.push(a + b);
            }
            else if (c == '-') {
                Double b = vals.pop();
                Double a = vals.pop();
                vals.push(a - b);
            }
            else if (c == '*') {
                Double b = vals.pop();
                Double a = vals.pop();
                vals.push(a * b);
            }
            else if (c == '/') {
                Double b = vals.pop();
                Double a = vals.pop();
                vals.push(a / b);
            }
            else {
                vals.push(Double.parseDouble(String.valueOf(c)));
            }
        }
        return vals.pop();
    }

    public static void main(String[] args) {

        String input = "((1+2)+3)";
        System.out.println(input);
        System.out.println(Evaluate.parseString(input));
        System.out.println(evaluate(InfixToPostFix.convertWithParenthesis(input)));

    }
}
