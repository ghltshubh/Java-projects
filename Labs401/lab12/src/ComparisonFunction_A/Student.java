package ComparisonFunction_A;

/**
 * Created by shubhankar on 11/14/16.
 */
public class Student implements Comparable<Student> {
    String firstName, midName, lastName;
    int ID;

    public Student(String lastName, String firstName, String midName, int ID) {
        this.firstName = firstName;
        this.midName = midName;
        this.lastName = lastName;
        this.ID = ID;
    }

    @Override
    public int compareTo(Student s) {
        if (!(this.lastName.equals(s.lastName))) {
            return (this.lastName).compareTo(s.lastName);
        } else if (!(this.firstName.equals(s.firstName))) {
            return (this.firstName).compareTo(s.firstName);
        } else if (!(this.lastName.equals(s.lastName))) {
            return (this.lastName).compareTo(s.lastName);
        } else if (this.ID > s.ID) {
            return 1;
        } else if (this.ID < s.ID) {
            return -1;
        } else return 0;
    }

    @Override
    public String toString() {
        return lastName + ", " + firstName + " " + midName + " " + ID;
    }
}