package test;


import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LambdasExample {

    // Static method that uses a Function (lambda for transformations)
    public static List<Integer> transformList(List<Integer> list,
                                              Function<Integer, Integer> transformer) {
        return list.stream()
                   .map(transformer) // Apply the lambda to each element
                   .collect(Collectors.toList());
    }

    // Static method that uses a Predicate (lambda for filtering)
    public static List<Integer> filterList(List<Integer> list, Predicate<Integer> filter) {
        return list.stream()
                   .filter(filter) // Apply the lambda as a condition
                   .collect(Collectors.toList());
    }

    // Static method that uses a BiFunction (lambda for combining two values)
    public static int combineValues(int a, int b, BiFunction<Integer, Integer, Integer> combiner) {
        return combiner.apply(a, b); // Apply the lambda to combine the two values
    }

    // Static method that applies a custom Function to a single value
    public static <T, R> R applyFunction(T input, Function<T, R> function) {
        return function.apply(input);
    }

    public static void main(String[] args) {
        // Example usage of the static methods

        // 1. Transforming a list
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        List<Integer> squaredNumbers = transformList(numbers, n -> n * n);
        System.out.println("Squared Numbers: " + squaredNumbers);

        // 2. Filtering a list
        List<Integer> evenNumbers = filterList(numbers, n -> n % 2 == 0);
        System.out.println("Even Numbers: " + evenNumbers);

        // 3. Combining two values
        int sum = combineValues(10, 20, (a, b) -> a + b);
        System.out.println("Sum: " + sum);

        // 3.1. Combining two values
        sum = combineValues(10, 20, Integer::sum);
        System.out.println("Sum: " + sum);

        int product = combineValues(10, 20, (a, b) -> a * b);
        System.out.println("Product: " + product);

        // 4. Applying a custom function to a single value
        String result = applyFunction(5, n -> "The number is: " + n);
        System.out.println(result);
    }
}
