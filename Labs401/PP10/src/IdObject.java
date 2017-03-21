import java.util.Objects;

public class IdObject {
    Object value;

    public IdObject(Object x) {
        value = x;
    }
    public Object Identity() {
        return value;
    }

    public static void run() {
        IdObject obj1 = new IdObject("Hello World");
        Object x1, x2;

        x1 = obj1.Identity();
        System.out.println(x1);

        IdObject obj2 = new IdObject(63);
        x2 = obj2.Identity();
        System.out.println(x2);
    }

    public static void main(String[] args) {
        IdObject.run();
    }

}