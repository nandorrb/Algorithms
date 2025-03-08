package test.chapter1.four;

import edu.princeton.cs.algs4.StdRandom;

import java.util.random.RandomGenerator;

/**
 * Binary search for a fraction. Devise a methid that uses a logarithmic number of queries of the form
 * <p>Is the number less than x?< /p>
 * to find a rational number p/q such that 0<p<q<N .
 * Hint : Two fractions with denominations less than N cannot differ by more than 1/N^2.
 */
public class TwentyThree {
    record SolutionObject(
            int p,
            int q
    ) {
    }

    public static SolutionObject findClosesFraction(float x, int N) {
int[] pool = IntStream  //  generate 1  - N
        int  n1 = pool.length/2;
        int  n2 = pool.length/2;

        int p ;
        int q ;

        while (){
             p = pool[n1];
             q = pool[n2];

             double currentValue = ((double) p)/((double) q);

        }


        SolutionObject solutionObject = new SolutionObject(p,q);
        return solutionObject;
    }
    static void main(String[] args){

        System.out.println(findClosesFraction(5,500));
    }
}
