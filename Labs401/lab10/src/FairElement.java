/**
 * Created by shubhankar on 11/2/16.
 */
class FairElement<E> implements Comparable<E>
{
    E element;

    long count;


    public FairElement (E element, long count)
    {
        this.element = element;
        this.count = count;
    } // constructor

    @Override
    public int compareTo(E o) {
        return 0;
    }
} // class FairElement