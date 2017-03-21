package ComparisonFunction_A;

import java.util.ArrayList;

/**
 * Created by shubhankar on 11/14/16.
 */
public class QuickSort  {
    private ArrayList<Student> numbers;

    public ArrayList<Student> sort(ArrayList<Student> values) {

        if (values == null || values.size() == 0) {
            return null;
        }
        numbers = values;
        int number = values.size();
        quickSort(0, number - 1);

        return new ArrayList<>(numbers);
    }

    private void quickSort(int low, int high) {
        int i = low, j = high;

        Student pivot = numbers.get(low + (high-low)/2);

        while (i <= j) {

            while (numbers.get(i).compareTo(pivot) < 0) {
                i++;
            }
            while (numbers.get(j).compareTo(pivot) > 0) {
                j--;
            }

            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }

        if (low < j)
            quickSort(low, j);
        if (i < high)
            quickSort(i, high);
    }

    private void exchange(int i, int j) {
        Student temp = numbers.get(i);

        numbers.set(i, numbers.get(j));
        numbers.set(j, temp);
    }
}