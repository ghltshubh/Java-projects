import java.io.Serializable;

public class Chores implements Comparable<Chores>, Serializable
{
    protected String chore_name;
    protected int    chore_time;

    public Chores(String n, int t)
    {
        chore_name = n;
        chore_time = t;
    }

    public String toString()
    {
        return "[" + chore_name + ":" + chore_time+ "]";
    }

    public int compareTo(Chores c)
    {
        if (this.chore_time > c.chore_time)
            return 1;
        else if (this.chore_time < c.chore_time)
            return -1;
        else /* (this.chore_time == c.chore_time)  */
            return 0;
    }
}
