public class Refs  {
    public static void main(String[] args)  {
        MyPoint p1 = new MyPoint(10, 20);
        MyPoint p2 = new MyPoint(30, 40);

        if (args.length == 0)  {
            System.out.println("usage: java Refs swap1|swap2|swap3");
            return;
        }

        print_memory("At start: main", "p1", p1);
        print_memory("At start: main", "p2", p2);

        if (args[0].compareTo("swap1") == 0)  {
            swap1(p1, p2);
            System.out.println(p1);
            System.out.println(p2);
            System.out.println();
        }
        else if (args[0].compareTo("swap2") == 0)  {
            swap2(p1, p2);
            System.out.println(p1);
            System.out.println(p2);
            System.out.println();
        }
        else if (args[0].compareTo("swap3") == 0)  {
            swap3(p1, p2);
            System.out.println(p1);
            System.out.println(p2);
            System.out.println();
        }
        else  {
            System.out.println("usage: java Refs swap1|swap2|swap3");
            return;
        }

        print_memory("At end: main", "p1", p1);
        print_memory("At end: main", "p2", p2);

        return;
    }

    public static void swap1(MyPoint arg1, MyPoint arg2)  {
        MyPoint temp;

        temp = arg1;
        arg1 = arg2;
        arg2 = temp;
        System.out.println();
        System.out.println("In swap1(): p1 is " + arg1 + ", p2 is " + arg2);
    }


    public static void swap2(MyPoint arg1, MyPoint arg2)  {
        Integer x, y;

        x = arg1.x;
        y = arg1.y;

        arg1.x = arg2.x;
        arg1.y = arg2.y;

        arg2.x = x;
        arg2.y = y;

        System.out.println();
        System.out.println("In swap2(): p1 is " + arg1 + ", p2 is " + arg2);
    }

    public static void swap3(MyPoint arg1, MyPoint arg2)  {
        MyPoint temp = new MyPoint(arg1.x, arg1.y);

        arg1.x = arg2.x;
        arg1.y = arg2.y;

        arg2 = temp;

        System.out.println();
        System.out.println("In swap3()");

    }

    public static void print_memory(String func, String name, MyPoint p)  {
        System.out.println(func + ": " + name + " address is " +
                p.getClass().getName() + "@"   +
                Integer.toHexString(System.identityHashCode(p)));
        System.out.println("   " + name + ".x address is " +
                p.x.getClass().getName() + "@"   +
                Integer.toHexString(System.identityHashCode(p.x)) +
                ", value is " + p.x);
        System.out.println("   " + name + ".y address is " +
                p.y.getClass().getName() + "@"   +
                Integer.toHexString(System.identityHashCode(p.y)) +
                ", value is " + p.y);
    }
}

class MyPoint  {
    public Integer x, y;

    public MyPoint(Integer arg_x, Integer arg_y)  {
        x = arg_x;
        y = arg_y;
    }

    public String toString()  {

        return "MyPoint[x=" + x + ",y=" + y + "]";
    }
}