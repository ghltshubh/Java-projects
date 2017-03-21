import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by shubhankar on 02/09/16.
 */
public class HighestGPA {
    public static void main(String[] args) throws FileNotFoundException {
        new HighestGPA().run();
    }   // method main

    public void run() throws FileNotFoundException {

        final double NEGATIVE_GPA = -1.0;

        final String NO_VALID_INPUT = "Error: the given file has no valid input";

        final String BEST_MESSAGE = "\n\nThe student with the highest grade point average is ";

        Scanner fileScanner = new Scanner(new File("/Users/shubhankar/IdeaProjects/CS 401 assignments/pp1/src/student.txt"));

        String name, bestStudent = null;

        double gpa, highestGPA = NEGATIVE_GPA;

        while (fileScanner.hasNextLine()) {
            Scanner lineScanner = new Scanner(fileScanner.nextLine());

            name = lineScanner.next();
            gpa = lineScanner.nextDouble();
            if (gpa > highestGPA) {
                highestGPA = gpa;
                bestStudent = name;
            }//if
        }//while
        if (highestGPA == NEGATIVE_GPA) {
            System.out.println(NO_VALID_INPUT);
        } else System.out.println(BEST_MESSAGE + bestStudent);
    }//method run
}//method main

