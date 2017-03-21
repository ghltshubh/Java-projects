import java.util.Comparator;
public class App {
    public static void main(String[] args) {

        //--------------5 FullTimeEmployee objects--------//
        FullTimeEmployee fte1 = new FullTimeEmployee("a", 100.00);
        FullTimeEmployee fte2 = new FullTimeEmployee("b", 50.00);
        FullTimeEmployee fte3 = new FullTimeEmployee("a", 100.00);
        FullTimeEmployee fte4 = new FullTimeEmployee("d", 250.00);
        FullTimeEmployee fte5 = new FullTimeEmployee("a", 100.00);

        //-------------------reflexivity----------------//

        System.out.println(fte1.equals(fte1));

        //---------------------symmetry----------------//

        System.out.println(fte1.equals(fte2));         // false

        System.out.println(fte2.equals(fte1));         // false

        //-------------------transitivity--------------//

        System.out.println(fte1.equals(fte3));         // true

        System.out.println(fte3.equals(fte5));         // true

        System.out.println(fte3.equals(fte1));         // true

        //-------------------consistency---------------//

        System.out.println(fte1.equals(fte4));         // false

        //--------------------actuality----------------//

        System.out.println(fte1.equals(null));         // false


        //---------Equality using Comparator interface-------//

        FullTimeEmployeeComparator ftc = new FullTimeEmployeeComparator();

        System.out.println(ftc.compare(fte1, fte2));         //1

        System.out.println(ftc.compare(fte2, fte3));         //-1

        System.out.println(ftc.compare(fte3, fte4));         //-1

        System.out.println(ftc.compare(fte4, fte5));         //1

        //---------Equality using Comparable interface-------//

        System.out.println(fte1.compareTo(fte2));            //1

        System.out.println(fte2.compareTo(fte3));            //-1

        System.out.println(fte3.compareTo(fte4));            //-1

        System.out.println(fte4.compareTo(fte5));            //1

    }
}

class FullTimeEmployee implements Comparable<FullTimeEmployee> {
    String name;
    Double grossPay;
    FullTimeEmployee(String name, Double grossPay) {
        this.name = name;
        this.grossPay = grossPay;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FullTimeEmployee)) {
            return false;
        }
        FullTimeEmployee fte = (FullTimeEmployee) obj;
        return name.equals(fte.name) && grossPay.equals(fte.grossPay);
    }

    @Override
    public int compareTo(FullTimeEmployee o) {
        int eq;

        if (this.name == o.name && this.grossPay == o.grossPay)
            eq = 0;
        else if (this.grossPay > o.grossPay)
            eq = 1;
        else
            eq = -1;
        return eq;
    }
}


class FullTimeEmployeeComparator implements Comparator<FullTimeEmployee>{

    @Override
    public int compare(FullTimeEmployee o1, FullTimeEmployee o2) {
        int eq;
        if (o1.name == o2.name && o1.grossPay == o2.grossPay)
            eq = 0;
        else if (o1.grossPay > o2.grossPay)
            eq = 1;
        else eq = -1;
        return eq;
    }
}