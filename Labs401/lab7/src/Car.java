/**
 * Created by shubhankar on 10/12/16.
 */
public class Car {
    protected int arrivalTime;

    /*public Car() {
    }*/

    public Car(int nextArrivalTime) {
        arrivalTime = nextArrivalTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }
}
