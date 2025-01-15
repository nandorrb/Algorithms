/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package test.chapter1.one;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class DiceSimulation {
    static double[] exactProbabilityDistribution() {
        int SIDES = 6;
        int[] frequenncies = new int[2 * SIDES + 1];
        for (int i = 1; i <= SIDES; i++)
            for (int j = 1; j <= SIDES; j++)
                frequenncies[i + j]++;

        double[] probabilities = new double[2 * SIDES + 1];

        for (int k = 1; k <= 2 * SIDES; k++) {
            probabilities[k] = frequenncies[k] / 36.0;
        }


        return probabilities;
    }

    static double[] randomProbabilityDistribution(int n) {
        int SIDES = 6;
        int[] frequenncies = new int[2 * SIDES + 1];
        int dice1;
        int dice2;
        double[] probabilities = new double[2 * SIDES + 1];

        for (int i = 0; i < n; i++) {
            dice1 = StdRandom.uniformInt(SIDES) + 1;
            dice2 = StdRandom.uniformInt(SIDES) + 1;

            frequenncies[dice1 + dice2]++;
        }


        for (int k = 1; k <= 2 * SIDES; k++) {
            probabilities[k] = frequenncies[k] / (double) n;
        }


        return probabilities;
    }

    public static void main(String[] args) {

        for (int i = 10; i < 1000000; i++) {
            double[] distributionReal = exactProbabilityDistribution();
            double[] distributionRandom = randomProbabilityDistribution(i);
            if (Math.abs(distributionReal[2] - distributionRandom[2]) < 0.0001) {
                StdOut.printf("Solution is %d", i);
                break;
            }
        }
        /*
        for (double probability : exactProbabilityDistribution()) {
            StdOut.print(probability);
            StdOut.print(" ");
        }
        StdOut.println();

        for (double probability : randomProbabilityDistribution(1000000)) {
            StdOut.print(probability);
            StdOut.print(" ");
        }
        StdOut.println();


         */
    }
}
