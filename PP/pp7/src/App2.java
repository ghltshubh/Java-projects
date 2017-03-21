/**
 * Created by shubhankar on 9/20/16.
 */
public class App2 {
    public static long factorial(int num) {
        long temp = num;
        if (num == 1 || num == 0) {
            return 1;
        }
        for (long k = num - 1; k > 0; k--) {
            temp = temp * k;
        }
        return temp;
    }
    public static void main(String[] args) {
        System.out.println(factorial(20));
    }
}
