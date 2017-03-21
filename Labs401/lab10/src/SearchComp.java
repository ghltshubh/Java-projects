
import java.io.*;
import java.util.Scanner;

/**
 * Created by shubhankar on 10/31/16.
 */
public class SearchComp {
    CS401BST<Student> tree;
    CS401LinkedListImpl<Student> linkedList;

    private void loadRecords() throws FileNotFoundException {
        System.out.println("Loading records...");
        String line;
        tree = new CS401BST<>();
        linkedList = new CS401LinkedListImpl<>();


        //-----------------------Linked List Input Timing--------------------//
        double start = System.nanoTime();
        Scanner scf = new Scanner(new File("src/student-64000.dat"));
        while (scf.hasNextLine()) {
            line = scf.nextLine();
            Scanner sc = new Scanner(line);
            linkedList.add(new Student(sc.next(), sc.next(), sc.next(), sc.nextInt()));
        }
        double time = System.nanoTime() - start;
        System.out.println("Time taken to load the records in linked list: " + time / 1000000.0 + " ms" + "\n");


        //-----------------------Binary Tree Input Timing--------------------//
        double start2 = System.nanoTime();
        Scanner scf2 = new Scanner(new File("src/student-64000.dat"));
        while (scf2.hasNextLine()) {
            line = scf2.nextLine();
            Scanner sc = new Scanner(line);
            tree.add(new Student(sc.next(), sc.next(), sc.next(), sc.nextInt()));
        }
        double time2 = System.nanoTime() - start2;
        System.out.println("Time taken to load the records in binary tree: " + time2 / 1000000.0 + " ms" + "\n");
    }

    public static void main(String[] args) throws FileNotFoundException {
        SearchComp x = new SearchComp();
        x.loadRecords();

        x.linkedListTiming(483293267);
        x.treeTiming(483293267);

        x.linkedListTiming(1902997270);
        x.treeTiming(1902997270);

        x.linkedListTiming(856408684);
        x.treeTiming(856408684);

        x.linkedListTiming(143507366);
        x.treeTiming(143507366);

        x.linkedListTiming(307954472);
        x.treeTiming(307954472);

        x.linkedListTiming(876561221);
        x.treeTiming(876561221);


        //----------------------Binary Search Tree Timing------------------//
    }

    public void linkedListTiming(int ID) {
        double start = System.nanoTime();
        System.out.println("Searching for student ID " + ID);
        Student student = linkedList.search((new Student(ID)));
        if (student != null) System.out.println("Success (record found): " + student);
        else System.out.println("Record not found");
        double time = System.nanoTime() - start;
        System.out.println("Time taken to search the records in linked list: " + time / 1000000.0 + " ms");
    }

    public void treeTiming(int ID) {
        double start = System.nanoTime();
        tree.search((new Student(ID)));
        double time = System.nanoTime() - start;
        System.out.println("Time taken to search the records in binary tree: " + time / 1000000.0 + " ms" + "\n");
    }
}
