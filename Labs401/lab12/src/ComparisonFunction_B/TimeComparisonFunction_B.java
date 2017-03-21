package ComparisonFunction_B;

import ComparisonFunction_A.HeapSort;
import ComparisonFunction_A.MergeSort;
import ComparisonFunction_A.QuickSort;
import ComparisonFunction_A.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by shubhankar on 11/14/16.
 */
public class TimeComparisonFunction_B {
    public static void main(String[] args) throws IOException {
        ArrayList<Student> studentArray = new ArrayList<>();

        String fileName = "src/student-64000.dat";

        File fileObject = new File(fileName);

        Scanner in = new Scanner(fileObject).useDelimiter(",\\s|\\s");

        for (int i = 0; i < 64000; i++) {
            Student student;
            if (in.hasNextLine()) {
                student = new Student(in.next(), in.next(), in.next(), in.nextInt());
                studentArray.add(student);
            }
        }

        //--------------------------------Heap sort---------------------------//
        HeapSort hs = new HeapSort();
        double start = System.nanoTime();
        hs.sort(studentArray);
        double heapSortTime = (System.nanoTime() - start) / 1000000.0;

        System.out.println("COMPARISON FUNCTION B");

        System.out.format("Heap sort of data file: %.2f ms %n", heapSortTime);


        //--------------------------------Merge sort---------------------------//

        MergeSort ms = new MergeSort();

        double start2 = System.nanoTime();

        ms.mergeSort(studentArray);

        double mergeSortTime = (System.nanoTime() - start2) / 1000000.0;

        System.out.format("Merge sort of data file:  %.2f ms %n", mergeSortTime);


        //--------------------------------Quick sort---------------------------//

        QuickSort qs = new QuickSort();

        double start3 = System.nanoTime();

        qs.sort(studentArray);

        double quickSortTime = (System.nanoTime() - start3) / 1000000.0;

        System.out.format("Quick sort of data file:  %.2f ms %n", quickSortTime);

    }
}
