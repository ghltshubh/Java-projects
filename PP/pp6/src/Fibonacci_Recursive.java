/**
 * Created by shubhankar on 13/09/16.
 */
public class Fibonacci_Recursive {
    public static long fibonacci_recursive(int num) {
        if (num == 0 || num == 1) {
            return 1;
        } else
            return fibonacci_recursive(num - 1) + fibonacci_recursive(num - 2);
    }

    public static void main(String[] args) {
        double start = System.currentTimeMillis();
        System.out.println(fibonacci_recursive(45));
        double end = System.currentTimeMillis() - start;
        System.out.println("Time taken: " + end + " ms");
    }
}
