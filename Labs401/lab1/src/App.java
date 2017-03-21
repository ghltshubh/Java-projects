import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Kilometers travelled: ");         //Distance travelled in kilometers
        double km = sc.nextDouble();
        System.out.println("Enter fuel consumed in litres: ");      //Litres of fuel consumed in litres
        double ltr = sc.nextDouble();
        System.out.print("Fuel Economy: ");                         //Average fuel consumed in kilometer per litre
        System.out.format("%.2f",km / ltr);
        System.out.println(" kmpl");
    }
}
