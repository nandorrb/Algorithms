/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package test.chapter1.two;

import edu.princeton.cs.algs4.StdOut;

public class Sixteen {
    public static class Rational {
        private final int numerator;
        private final int denominator;

        public Rational(int numerator, int denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
        }

        public Rational plus(Rational that) {
            assert ((long) this.numerator * (long) that.denominator
            ) < Integer.MAX_VALUE :
                    "Overflow";
            assert (
                    +(long) that.numerator * (long) this.denominator) < Integer.MAX_VALUE :
                    "Overflow";
            assert ((long) this.numerator * (long) that.denominator
                    + (long) that.numerator * (long) this.denominator) < Integer.MAX_VALUE :
                    "Overflow";
            assert ((long) this.denominator * (long) that.denominator) < Integer.MAX_VALUE :
                    "Overflow";
            int newNumerator = this.numerator * that.denominator
                    + that.numerator * this.denominator;
            int newDenominator = this.denominator * that.denominator;
            return createNormalizedRationale(newNumerator, newDenominator);
        }

        /**
         * Greatest common divisor between two integers
         */
        private int gcd(int a, int b) {
            if (b == 0) return a;
            return gcd(b, a % b);
        }

        /**
         * creates a normalized rationale, gets the greatest common divisor and normalize numerator
         * and denominator, returns a new rationale
         */
        private Rational createNormalizedRationale(int numerator, int denominator) {
            int greatestCommonDivisor = Math.abs(gcd(numerator, denominator));
            numerator = numerator / greatestCommonDivisor;
            denominator = denominator / greatestCommonDivisor;
            return new Rational(numerator,
                                denominator);
        }


        public Rational minus(Rational that) {
            assert ((long) this.numerator * (long) that.denominator
            ) < Integer.MAX_VALUE :
                    "Overflow";
            assert ((long) that.numerator * (long) this.denominator) < Integer.MAX_VALUE :
                    "Overflow";
            assert ((long) this.numerator * (long) that.denominator
                    - (long) that.numerator * (long) this.denominator) < Integer.MAX_VALUE :
                    "Overflow";
            assert ((long) this.denominator * (long) that.denominator) < Integer.MAX_VALUE :
                    "Overflow";

            int newNumerator = this.numerator * that.denominator
                    - that.numerator * this.denominator;
            int newDenominator = this.denominator * that.denominator;
            return createNormalizedRationale(newNumerator, newDenominator);

        }

        public Rational times(Rational that) {

            assert ((long) this.numerator * (long) that.numerator) < Integer.MAX_VALUE :
                    "Overflow";
            assert ((long) this.denominator * (long) that.denominator) < Integer.MAX_VALUE :
                    "Overflow";

            int newNumerator = this.numerator * that.numerator;
            int newDenominator = this.denominator * that.denominator;
            return createNormalizedRationale(newNumerator, newDenominator);
        }

        public Rational dividedBy(Rational that) {
            assert ((long) this.numerator * (long) that.denominator) < Integer.MAX_VALUE :
                    "Overflow";
            assert ((long) this.denominator * (long) that.numerator) < Integer.MAX_VALUE :
                    "Overflow";

            int newNumerator = this.numerator * that.denominator;
            int newDenominator = this.denominator * that.numerator;
            return createNormalizedRationale(newNumerator, newDenominator);
        }

        public boolean equals(Rational that) {
            return this.denominator == that.denominator && this.numerator == that.numerator;
        }


        public String toString() {
            return this.numerator + "/" + this.denominator;
        }
    }

    public static void main(String[] args) {
        // 1/2
        Rational a = new Rational(1, Integer.MAX_VALUE);
        // 3/4
        Rational b = new Rational(3, 4);

        StdOut.println("a");
        StdOut.println(a);
        StdOut.println("b");
        StdOut.println(b);
        StdOut.println("+");
        StdOut.println(a.plus(b));
        StdOut.println("-");
        StdOut.println(a.minus(b));
        StdOut.println("==");
        StdOut.println(a.equals(b));
        StdOut.println("*");
        StdOut.println(a.times(b));
        StdOut.println("/");
        StdOut.println(a.dividedBy(b));


    }
}
