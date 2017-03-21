import java.util.ArrayList;

/**
 * Created by shubhankar on 11/7/16.
 */
public class BubbleSort {
    public void bubbleSort(ArrayList<Student> arr) {
        int n = arr.size();
        Student temp;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                int comp = (arr.get(j - 1)).compareTo(arr.get(j));
                if (comp > 0) {
                    //swap elements
                    temp = arr.get(j - 1);
                    arr.set(j - 1, arr.get(j));
                    arr.set(j, temp);
                }
            }
        }
    }
}