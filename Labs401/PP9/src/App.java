/**
 * Created by shubhankar on 11/3/16.
 */
public class App {
    public static void main(String[] args) {
        Person person1 = new Person();
        Person person2 = new Person();

        //person1.name = "Joe";
        //person1.age = 24;

        person1.setAge(24);
        person1.setName("Joe");

        person1.speak();

        int years = person1.calculateYearsToRetirement();

        System.out.println("Age to retirement is " + years);
    }
}

class Person {
    private String name;
    private int age;

    void speak() {
        System.out.println("My name is " + name);
    }

    int calculateYearsToRetirement() {
        return 65 - age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
