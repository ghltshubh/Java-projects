import java.util.ArrayList;

/**
 * Created by shubhankar on 11/7/16.
 */
public class InsertionSort {
    public void insertionSort(ArrayList<Student> array) {
        int n = array.size();
        for (int j = 1; j < n; j++) {
            Student key = array.get(j);
            int i = j - 1;
            while ((i > -1) && (array.get(i).compareTo(key) > 0)) {
                array.set(i + 1, array.get(i));
                i--;
            }
            array.set(i + 1, key);
        }
    }
}