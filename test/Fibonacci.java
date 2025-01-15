package test;

public class Fibonacci {

    // Recursive implementation
    public static long fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // Iterative implementation of Fibonacci
    public static long fibonacci2(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        long fiboLast = 0; // F(n-2)
        long fiboNew = 1;  // F(n-1)
        long currentFibo = 0;

        for (int i = 2; i <= n; i++) {
            currentFibo = fiboLast + fiboNew; // Compute F(n)
            fiboLast = fiboNew;              // Update F(n-2)
            fiboNew = currentFibo;           // Update F(n-1)
        }

        return currentFibo;
    }

    public static void main(String[] args) {
        long fiboLast = 0;
        long fiboNew = 1;
        long bias = 0;

        for (int n = 0; n < 90; n++) {
            //     System.out.println(n+" " + fibonacci(n));
            System.out.println(n + " " + fiboLast);
            bias = fiboNew;
            fiboNew = fiboNew + fiboLast;
            fiboLast = bias;
        }
    }
}
