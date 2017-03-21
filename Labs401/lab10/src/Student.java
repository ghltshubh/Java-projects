/**
 * Created by shubhankar on 10/31/16.
 */
public class Student implements Comparable<Student> {
    String firstName, midName, lastName;
    int ID;

    public Student(String lastName, String midName, String firstName, int ID) {
        this.firstName = firstName;
        this.midName = midName;
        this.lastName = lastName;
        this.ID = ID;
    }

    public Student(int ID) {
        this.ID = ID;
    }

    @Override
    public int compareTo(Student s) {
        if (this.ID > s.ID) {
            return 1;
        }
        else if (this.ID < s.ID) {
            return -1;
        } else return 0;
    }

    @Override
    public String toString() {
        return lastName + " " + midName + " " + firstName + " " + ID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        return ID == student.ID;

    }

    @Override
    public int hashCode() {
        return ID;
    }
}
