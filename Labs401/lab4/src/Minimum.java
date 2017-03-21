/**
 * Created by shubhankar on 9/21/16.
 */
public class Minimum {
    public static int minimum(int A[], int size) {
        int temp;
        if (size == 1) {
            return A[size - 1];
        }
        if (minimum(A, size - 1) > A[size - 1]) {
            temp = A[size - 1];
        }
        else
            temp = minimum(A, size - 1);
        return temp;
    }

    public static void main(String[] args) {
        int[] A = {10, -20, 1- 2, 0, 5, 100};
        System.out.println(minimum(A,A.length));
    }
}
