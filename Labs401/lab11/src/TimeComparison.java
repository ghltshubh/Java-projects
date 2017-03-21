import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by shubhankar on 11/7/16.
 */
public class TimeComparison {
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

        //--------------------------------Bubble sort---------------------------//
        BubbleSort bs = new BubbleSort();

        double start = System.nanoTime();

        bs.bubbleSort(studentArray);

        double bubbleSortTime = (System.nanoTime() - start) / 1000000.0;

        System.out.format("Bubble sort of data file:  %.2f ms %n", bubbleSortTime);

        String writeFile = "BubbleSorted.txt";

        File file = new File(writeFile);

        BufferedWriter bw = new BufferedWriter(new FileWriter(file));

        for (int j = 0; j < 64000; j++) {
            bw.write(studentArray.get(j).toString() + "\n");
        }
        bw.close();

        //---------------------------Selection sort--------------------------//
        SelectionSort ss = new SelectionSort();

        double start2 = System.nanoTime();

        ss.selectionSort(studentArray);

        double selectionSortTime = (System.nanoTime() - start2) / 1000000.0;

        System.out.format("Selection sort of data file:  %.2f ms %n", selectionSortTime);

        String writeFile2 = "SelectionSorted.txt";

        File file2 = new File(writeFile2);

        BufferedWriter bw2 = new BufferedWriter(new FileWriter(file2));

        for (int j = 0; j < 64000; j++) {
            bw2.write(studentArray.get(j).toString() + "\n");
        }

        bw2.close();


        //-------------------------Insertion sort---------------------------//

        InsertionSort is = new InsertionSort();

        double start3 = System.nanoTime();

        is.insertionSort(studentArray);

        double insertionTime = (System.nanoTime() - start3) / 1000000.0;

        System.out.format("Insertion sort of data file:  %.2f ms %n", insertionTime);

        String writeFile3 = "InsertionSorted.txt";

        File file3 = new File(writeFile3);

        BufferedWriter bw3 = new BufferedWriter(new FileWriter(file3));

        for (int j = 0; j < 64000; j++) {
            bw3.write(studentArray.get(j).toString() + "\n");
        }

        bw3.close();
    }
}