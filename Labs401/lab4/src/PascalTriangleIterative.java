import java.util.Scanner;
import java.util.UnknownFormatConversionException;

/**
 * Created by shubhankar on 9/15/16.
 */
public class PascalTriangleIterative {
    public static void pascalsTriangle(int level) {
        int[][] arr = new int[level][level];
        for (int row = 0; row < level; row++) {
            for (int col = 0; col < row; col++) {
                if (col == 0 || col == row) {
                    arr[row][col] = 1;
                }
                else
                    arr[row][col] = arr[row - 1][col] + arr[row - 1][col - 1];
                System.out.printf("%10d",arr[row][col]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        double start = System.currentTimeMillis();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows you want to print: ");
        if (sc.hasNextInt())
            pascalsTriangle (sc.nextInt());
        else System.out.println("NaN. Run again and input a number.");
        double end = System.currentTimeMillis() - start;
        System.out.println("Time: " + end + " ms");
    }
}
