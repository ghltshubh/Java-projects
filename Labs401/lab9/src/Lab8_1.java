/**
 * Created by shubhankar on 10/25/16.
 */
import java.util.*;

public class Lab8_1
{
    public static void main (String[] args)
    {
        new Lab8_1().run();
    } // method main


    public void run()
    {
        final String PROMPT = "\nPlease enter the number of " +
                "elements to be inserted for the first trial: ";

        final String SIZE_MESSAGE = "The tree size is ";

        final String RATIO_MESSAGE = "The ratio of the average height to the log, " +
                        "base 2, of the tree size is ";

        final int SIZES = 5;

        final int TRIALS_PER_SIZE = 20;

        CS401BST<Double> t = new CS401BST<>();

        Scanner sc = new Scanner (System.in);

        int n, totalHeight;

        double averageHeight;

        while (true)
        {
            try
            {
                System.out.print (PROMPT);
                n = sc.nextInt();

                for (int i = 1; i <= SIZES; i++)
                {
                    for (int j = 0; j < TRIALS_PER_SIZE; j++)
                    {
                        for (int k = 0; k < n; k++) {
                            t.add((Math.random()));
                        }
                    } // for each trial
                    System.out.println();
                    System.out.println(SIZE_MESSAGE + n);
                    totalHeight = t.height();
                    averageHeight = (double)totalHeight / TRIALS_PER_SIZE;
                    System.out.println (RATIO_MESSAGE + averageHeight / (Math.log(n) / Math.log(2.0)));
                    n *= 2;
                } // for each size
                break;
            }//try
            catch (InputMismatchException e)
            {
                System.out.println (e);
                sc.nextLine();
            }//catch InputMismatchException
        } // while
    } // method run

} // class Lab8_1
