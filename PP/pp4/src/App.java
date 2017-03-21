/**
 * Created by shubhankar on 13/09/16.
 */
public class App {
    public static void main(String[] args) {
        System.out.println(new Recursion().factorial(20));
    }   //method main
}   //class App

class Recursion {
    public long factorial(int num) {
        if (num == 1) {
            return 1;
        } else return num * factorial(num - 1);
    }   //method factorial
}   //class Recursion