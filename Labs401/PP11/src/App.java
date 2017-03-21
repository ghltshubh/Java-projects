/**
 * Created by shubhankar on 11/19/16.
 */
public class App {
    public static void main(String[] args) {

    }
}

class Movie {
    private String name;

    public Movie(String name) {
        this.name = name;
    }

    public String plot() {
        return "No plat here";
    }

    public String getName() {
        return name;
    }
}

class Jaws extends Movie {
    public Jaws() {
        super("Jaws");
    }

    @Override
    public String plot() {
        return "A shark wats lots of people";
    }
}

class IndepenceDay extends Movie {
    public
}