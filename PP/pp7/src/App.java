/**
 * Created by shubhankar on 9/20/16.
 */
public class App {
    public static long factorial(int num) {
        if (num == 0 || num == 1)
            return 1;
        else
            return factorial(num - 1)*num;
    }
    public static void main(String[] args) {
        System.out.println(factorial(5));
    }
}
