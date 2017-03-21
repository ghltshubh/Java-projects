/**
 * Created by shubhankar on 9/21/16.
 */
public class PowerOddEven {
    public static long power(long i, long n) {
        if (n == 0) {
            return 1;
        }
        else if (n % 2 == 0) {
            return power(i * i, n / 2);
        }
        else return i * power(i * i, n / 2);
    }

    public static void main(String[] args) {
        double start = System.nanoTime();
        System.out.println(power(2,62));
        double end = System.nanoTime() - start;
        System.out.println(end);
    }
}
