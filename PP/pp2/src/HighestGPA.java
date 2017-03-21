import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by shubhankar on 06/09/16.
 */
public class HighestGPA {
    public static void main(String[] args) throws FileNotFoundException {
        new HighestGPA().run();
    } //method main

    public void run() throws FileNotFoundException {
        final double NEGATIVE_GPA = -1.0;

        final String IN_FILE_PROMPT = "Enter file path";
        Scanner keyboardScanner = new Scanner(System.in);
        System.out.println(IN_FILE_PROMPT);
        String inFileName = keyboardScanner.nextLine();
        Scanner fileScanner = new Scanner(new File(inFileName));
        final String NO_VALID_INPUT = "Error: the given file has no valid input.";
        final String BEST_MESSAGE = "\n\nThe student with highest grade point is ";

        String name, best_student = null;
        double gpa, highestGPA = NEGATIVE_GPA;

        while (fileScanner.hasNextLine()) {
            Scanner lineScanner = new Scanner(fileScanner.nextLine());
            name = lineScanner.next();
            gpa = lineScanner.nextDouble();
            if (gpa > highestGPA) {
                highestGPA = gpa;
                best_student = name;
            } //if
        } //while
        if (highestGPA == NEGATIVE_GPA) {
            System.out.println(NO_VALID_INPUT);
        } else System.out.println(BEST_MESSAGE + best_student);
    } //method run
} //class HighestGPA
