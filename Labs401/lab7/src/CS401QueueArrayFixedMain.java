/**
 * Created by shubhankar on 10/11/16.
 */
public class CS401QueueArrayFixedMain {
    public static void main(String[] args) {
        CS401QueueArrayFixedImpl<String> arrayFixed = new CS401QueueArrayFixedImpl<>(5);

        arrayFixed.add("a");
        arrayFixed.add("b");
        arrayFixed.add("c");
        arrayFixed.add("d");
        arrayFixed.add("e");
        arrayFixed.add("f");

        System.out.println("Popped value is: " + arrayFixed.remove());

        System.out.println("Popped value is: " + arrayFixed.remove());

        System.out.println("Top value is: " + arrayFixed.peek());
    }
}
