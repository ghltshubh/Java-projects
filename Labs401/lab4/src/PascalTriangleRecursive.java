import java.util.Scanner;

/**
 * Created by shubhankar on 9/20/16.
 */
public class PascalTriangleRecursive {
    public static int recursive(int row, int col) {
        if (row < col) {
            throw new StackOverflowError();
        }
        if (row == col || col == 1) {
            return 1;
        }
        else {
            return recursive(row - 1, col) + recursive(row - 1, col - 1);
        }
    }

    public static void main(String[] args) {
        double start = System.currentTimeMillis();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter row: ");
        int row = sc.nextInt();
        System.out.println("Enter column: ");
        int col = sc.nextInt();
        System.out.println(recursive(row,col));
        double end = System.currentTimeMillis() - start;
        System.out.println("Time: " + end + " ms");
    }
}