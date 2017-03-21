import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by shubhankar on 10/12/16.
 */
public class CarWashUser {
    public static void main(String[] args) {
        run();
    }

    public static void run() {

        int nextArrivalTime;

        //final String INPUT_PROMPT = "\nPlease enter the next arrival time (or " + SENTINEL + " to quit): ";

        final String INPUT_PROMPT = "\nPlease enter the mean arrival time, maximum arrival time and mean service time(separated with spaces): ";

        System.out.println(INPUT_PROMPT);

        Scanner sc = new Scanner(System.in);

        nextArrivalTime = getTimeTillNext(sc.nextInt());//sc.nextInt();

        int maximumArrivalTime = sc.nextInt();

        CarWash carWash = new CarWash();

        while (true) {

            try {
                if (nextArrivalTime >= maximumArrivalTime) break;
                carWash.process(nextArrivalTime);
                carWash.washTime = carWash.washTime(getServiceTime(sc.nextInt()));
            } catch (Exception e) {
                System.out.println(e);
                sc.nextLine();
            }
        }
        carWash.finishUp();
        printResults(carWash);

    }

    public static void printResults(CarWash carWash) {
        LinkedList<String> results = carWash.getResults();
        System.out.println("Here are the results of the simulation: \n");
        for (String s : results) {
            System.out.println(s);
        }
    }

    public static int getTimeTillNext(int meanArrivalTime) {
        return (int) Math.round(-meanArrivalTime * Math.log(1 - Math.random()));
    }

    public static int getServiceTime(int meanServiceTime) {
        return (int) Math.round(-meanServiceTime * Math.log(1 - Math.random()));
    }
}


