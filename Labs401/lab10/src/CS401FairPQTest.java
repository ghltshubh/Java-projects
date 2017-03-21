import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CS401FairPQTest
{
    public static void main(String[] args) throws FileNotFoundException {
        String line;
        CS401FairPQ<Student> pq = new CS401FairPQ<Student>();
        Scanner scf = new Scanner(new File("src/student-5.dat"));
        while (scf.hasNextLine()) {
            line = scf.nextLine();
            Scanner sc = new Scanner(line);
            pq.add(new Student(sc.next(), sc.next(), sc.next(), sc.nextInt()));
        }

        System.out.println("Added data to a MIN HEAP.  Heap is:");
        System.out.println(pq);

        System.out.println("Removing elements from heap:");
        System.out.println(" Removed: " + pq.remove());
        System.out.println("Heap is now:");
        System.out.println(pq);
        System.out.println(" Removed: " + pq.remove());
        System.out.println(" Removed: " + pq.remove());
        System.out.println(" Removed: " + pq.remove());
        System.out.println(" Removed: " + pq.remove());

        System.out.println("Remaining elements in heap are:");
        System.out.println(pq);
    }
}