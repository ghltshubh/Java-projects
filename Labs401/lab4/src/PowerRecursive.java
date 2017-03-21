/**
 * Created by shubhankar on 9/21/16.
 */
public class PowerRecursive {
    public static long power(long i, long n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        if (n == 0) {
            return 1;
        }
        long ret = i * power(i, n - 1);
        if (ret > Long.MAX_VALUE || ret < 0) {
            throw new IllegalArgumentException();
        }
        return ret;
    }
    public static void main(String[] args) {
        double start = System.nanoTime();
        System.out.println(power(2,6));
        double end = System.nanoTime() - start;
        System.out.println(end);
    }
}
