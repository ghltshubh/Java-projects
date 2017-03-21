package ComparisonFunction_A;

import java.util.ArrayList;

/**
 * Created by shubhankar on 11/14/16.
 */

public class MergeSort {

    public void mergeSort(ArrayList<Student> array) {
        if (array.size() > 1) {
            ArrayList<Student> left = leftHalf(array);
            ArrayList<Student> right = rightHalf(array);

            mergeSort(left);
            mergeSort(right);

            merge(array, left, right);
        }
    }

    public ArrayList<Student> leftHalf(ArrayList<Student> array) {
        int size1 = array.size() / 2;
        ArrayList<Student> left = new ArrayList<>(size1);
        for (int i = 0; i < size1; i++) {
            left.add(array.get(i));
        }
        return left;
    }

    public ArrayList<Student> rightHalf(ArrayList<Student> array) {
        int size1 = array.size() / 2;
        int size2 = array.size() - size1;
        ArrayList<Student> right = new ArrayList<>(size2);
        for (int i = 0; i < size2; i++) {
            right.add(array.get(i + size1));
        }
        return right;
    }

    public void merge(ArrayList<Student> result, ArrayList<Student> left, ArrayList<Student> right) {
        int i1 = 0;
        int i2 = 0;

        for (int i = 0; i < result.size(); i++) {
            if (i2 >= right.size() || (i1 < left.size() && (left.get(i1).compareTo(right.get(i2)) <= 0))) {
                result.set(i, left.get(i1));
                i1++;
            } else {
                result.set(i, right.get(i2));
                i2++;
            }
        }
    }
}