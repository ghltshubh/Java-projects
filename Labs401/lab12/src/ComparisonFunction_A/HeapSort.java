package ComparisonFunction_A;

import java.util.ArrayList;

/**
 * Created by shubhankar on 11/17/16.
 */
public class HeapSort {

    private  ArrayList<Student> a;
    private  int n;


    public  void buildHeap(ArrayList<Student> a) {
        n = a.size()-1;
        for(int i=n/2; i>=0; i--){
            maxHeap(a,i);
        }
    }

    public  void maxHeap(ArrayList<Student> a, int i) {
        int left = 2 * i;
        int right = 2 * i + 1;

        int largest;
        if(left <= n && a.get(left).compareTo(a.get(i)) > 0){
            largest = left;
        } else {
            largest =i;
        }

        if(right <= n && a.get(right).compareTo(a.get(largest)) > 0) {
            largest = right;
        }
        if(largest !=i) {
            exchange(i, largest);
            maxHeap(a, largest);
        }
    }

    public  void exchange(int i, int j) {
        Student t = a.get(i);
        a.set(i,a.get(j));
        a.set(j, t);
    }

    public void sort(ArrayList<Student> myArray) {
        a = myArray;
        buildHeap(a);
        for(int i=n; i>0; i--) {
            exchange(0, i);
            n=n-1;
            maxHeap(a, 0);
        }
    }
}
