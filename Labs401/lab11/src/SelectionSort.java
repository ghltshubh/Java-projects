import java.util.ArrayList;

/**
 * Created by shubhankar on 11/7/16.
 */
public class SelectionSort {
    public void selectionSort(ArrayList<Student> arr){
        for (int i = 0; i < arr.size() - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < arr.size(); j++){
                if (arr.get(j).compareTo(arr.get(index)) < 0){
                    index = j;//searching for lowest index
                }
            }
            Student smallerStudent = arr.get(index);
            arr.set(index, arr.get(i));
            arr.set(i, smallerStudent);
        }
    }
}
