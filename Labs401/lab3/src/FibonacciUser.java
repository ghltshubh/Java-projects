public class FibonacciUser {
    public static long f(int num, long previous, long current) {
        if (num == 1 || num == 2) {
            return current;
        }
        else {
            current = previous + current;
            previous = current - previous;
            return f(num - 1, previous, current);
        }
    }

    public static long fib(int num) {
        long current = 1, previous = 1;
        return f(num, previous, current);
    }


    public static void main(String[] args) {
        double start = System.nanoTime();
        System.out.println(fib(40));
        double end = System.nanoTime() - start;
        System.out.println(end + " ns");
    }
}