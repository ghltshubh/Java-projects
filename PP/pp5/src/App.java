/**
 * Created by shubhankar on 13/09/16.
 */
public class App {
    public static void main(String[] args) {
        new PrintDecimal().print_decimal(6781);
    }
}

class PrintDecimal {
    public void print_decimal(long n) {
        if (n >= 10) {
            print_decimal(n / 10);
        }
        System.out.println("Digit: " + n%10);
    }
}