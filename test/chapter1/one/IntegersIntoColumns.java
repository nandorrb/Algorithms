package test.chapter1.one;


public class IntegersIntoColumns {
    public static void main(String[] args) {
        String name = args[0];
        int firstValue = Integer.parseInt(args[1]);
        int secondValue = Integer.parseInt(args[2]);

        double value;
        value = (double) firstValue / secondValue;
        System.out.printf("%s %d %d %.10f%n", name, firstValue, secondValue, value);
    }
}