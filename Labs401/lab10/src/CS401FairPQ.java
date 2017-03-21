import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by shubhankar on 11/2/16.
 */
public class CS401FairPQ<E> extends PriorityQueue<E>
{

    public static final int DEFAULT_INITIAL_CAPACITY = 11;

    protected long count;


    /**
     * Initializes this FairPQ object.
     */
    public CS401FairPQ()
    {
        super (DEFAULT_INITIAL_CAPACITY, new Natural<E>());
        count = 0;
    } // default constructor, elements are "naturally" ordered


    /**
     * Initializes this FairPQ object, in which comp
     * will be used for element comparisons.
     *
     * @param size the initial capacity of this FairPQ object.
     * @param comp a Comparator that dictates what type of
     *             comparison will be used between the
     *             elements of the FairPQ.
     */
    public CS401FairPQ (int size, Comparator<E> comp)
    {
        super (size, new Unnatural<E> (comp));
        count = 0;
    } // constructor, elements are "unnaturally" ordered by comp


    /**
     * Inserts a specified element to this FairPQ object.
     * The worstTime(n) is O(n), and averageTime(n) is constant.
     *
     * @param element -- the element that will be added to the FairPQ.
     */
    public boolean add (E element)
    {
        return super.add ((E)new FairElement<E> (element, count++));
    } // method add


    /**
     * Returns the smallest-valued element in this non-empty FairPQ object.
     *
     * @return the smallest-valued element in this FairPQ object
     */
    public E element()
    {
        FairElement<E> fairElement = (FairElement<E>)super.element();

        return fairElement.element;
    } // method element


    /**
     * Removes and returns the smallest-valued element in this
     * non-Empty FairPQ object.
     * The worstTime(n) is O(log n).
     *
     * @return the element that was just removed.
     */
    public E remove()
    {
        FairElement<E> fairElement = (FairElement<E>)super.remove();

        return (E)fairElement.element;
    } // method remove
} // classFairPQ