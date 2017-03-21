/**
 * Created by shubhankar on 13/09/16.
 */
public class App2 {
    public static void main(String[] args) {
        System.out.println(new Recursion2().factorial(20));
    }   //method main
}   //class App2

class Recursion2 {
    public long factorial(int num) {
        if (num == 1) {
            return 1;
        }
        long temp = num;
        for (int k = num - 1; k >= 1; k--) {
            temp = temp * k;
        }
        return temp;
    }
}
