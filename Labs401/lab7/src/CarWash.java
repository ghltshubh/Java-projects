import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by shubhankar on 10/12/16.
 */
public class CarWash {

    public final String OVERFLOW = " (Overflow)\n ";

    public final String HEADING = "\n\nTime\tEvent\t\tWaiting Time\n";

    protected static final int INFINITY = 10000;

    protected static final int MAX_SIZE = 5;

    protected Queue<Car> carQueue;

    protected LinkedList<String> results;

    protected int currentTime, nextDepartureTime, numberOfCars, waitingTime, sumOfWaitingTimes;

    protected int washTime;

    public CarWash() {
        carQueue = new LinkedList<Car>();

        results = new LinkedList<String>();

        results.add(HEADING);

        currentTime = 0;

        numberOfCars = 0;

        waitingTime = 0;

        sumOfWaitingTimes = 0;

        nextDepartureTime = INFINITY;
    }

    public LinkedList<String> process(int nextArrivalTime) {
        final String BAD_TIME = "The time of next arrival cannot be less than the current time.";

        if (nextArrivalTime < currentTime) {
            throw new IllegalArgumentException(BAD_TIME);
        }
        while (nextArrivalTime >= nextDepartureTime)
            processDeparture();
        return processArrival(nextArrivalTime);
    }

    private LinkedList<String> processArrival(int nextArrivalTime) {
        final String ARRIVAL = "\tArrival";

        currentTime = nextArrivalTime;
        results.add(Integer.toString(currentTime) + ARRIVAL);
        if (carQueue.size() == MAX_SIZE) {
            results.add(OVERFLOW);
        } else {
            numberOfCars++;
            if (nextDepartureTime == INFINITY) {
                nextDepartureTime = currentTime + washTime;
            }
            else carQueue.add(new Car(nextArrivalTime));
            results.add("\n");
        }
        return results;
    }

    protected LinkedList<String> processDeparture() {
        final String DEPARTURE = "\tDeparture\t\t";

        int arrivalTime;

        currentTime = nextDepartureTime;

        results.add(Integer.toString(currentTime) + DEPARTURE + Integer.toString(waitingTime) + "\n");

        if (!carQueue.isEmpty()) {
            Car car = carQueue.remove();
            arrivalTime = car.getArrivalTime();
            waitingTime = currentTime - arrivalTime;
            sumOfWaitingTimes += waitingTime;
            nextDepartureTime = currentTime + washTime;
        } else {
            waitingTime = 0;
            nextDepartureTime = INFINITY;
        }
        return results;
    }

    public LinkedList<String> finishUp() {
        while (nextDepartureTime < INFINITY) {
            processDeparture();
        }
        return results;
    }

    public LinkedList<String> getResults() {
        final String NO_CARS_MESSAGE = "There were no cars in the car wash.\n";

        final String AVERAGE_WAITING_TIME_MESSAGE = "\n\nThe average waiting time, in minutes, was ";

        if (numberOfCars == 0) {
            results.add(NO_CARS_MESSAGE);
        }
        else
            results.add(AVERAGE_WAITING_TIME_MESSAGE + Double.toString((double) sumOfWaitingTimes/numberOfCars));
        return results;
    }

    public int washTime(int meanArrivalTime) {
        double randomDouble = Math.random();
        return (int) Math.round( - meanArrivalTime * Math.log(1 - randomDouble));
    }

}
