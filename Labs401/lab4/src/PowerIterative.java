/**
 * Created by shubhankar on 9/21/16.
 */
public class PowerIterative {
    public static long power(long i, long n) {
        long temp = i;
        for (long k=n-1;k>=1;k--) {
            temp = temp*i;
        }
        return temp;
    }

    public static void main(String[] args) {
        double start = System.nanoTime();
        System.out.println(power(2,62));
        double end = System.nanoTime() - start;
        System.out.println(end);
    }
}
