import java.util.Scanner;

/**
 * Created by shubhankar on 06/09/16.
 */
public class App {
    public static void main(String[] args) {
        split("You're 21?? I'll need to see some ID.");
    }

    public static void split(String line) {
        Scanner sc = new Scanner(line).useDelimiter("[^a-zA-Z0-9']+");

        while (sc.hasNext()) {
            System.out.println(sc.next().toUpperCase());
        }
    } //method split
}
