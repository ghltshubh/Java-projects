/**
 * Created by shubhankar on 13/09/16.
 */
public class Fibonacci_Iterative {
    public static long fibonacci_iterative(int n) {
        long a = 0;
        long b = 1;
        long sum = 0;
        if (n == 1) {
            return 1;
        }
        else
            for (long i = 1; i < n; i++) {
                sum = a + b;
                a = b;
                b = sum;
            }
            return sum;
    }
    public static void main(String[] args) {
        double start = System.currentTimeMillis();
        System.out.println(fibonacci_iterative(94));
        double end = System.currentTimeMillis() - start;
        System.out.println("Time: " + end + " ms");
    }
}
