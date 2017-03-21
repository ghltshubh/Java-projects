/**
 * Created by shubhankar on 10/8/16.
 */

public class CS401StackLinkedListImpl<E> implements CS401StackInterface<E> {
    private LinkEntry<E> head;
    private int num_elements;

    public CS401StackLinkedListImpl()
    {
        head = null;
        num_elements = 0;
    }

    public void push(E e)
    {
        /** Add code here **/
        LinkEntry<E> ne = new LinkEntry<>();
        ne.element = e;
        if (num_elements == 0) {
            head = ne;
        }
        else {
            ne.next = head;
            head = ne;
        }
        num_elements++;
        return;
    }

    public E pop()
    {
        /** Add code here **/
        E e;
        if (num_elements == 0) {
            return null;
        }
        else {
            e = head.element;
            head = head.next;
        }
        num_elements--;
        return e;
    }

    public E peek()
    {
        /** Add code here **/
        E e;
        if (num_elements == 0) {
            return null;
        }
        else {
            e = head.element;
        }
        return e;
    }

    public int size()
    {
        /** Add code here **/
        return num_elements;
    }

    public boolean is_empty() {
        return num_elements == 0;
    }

    /* ------------------------------------------------------------------- */
   /* Inner classes                                                      */
    protected class LinkEntry<E>
    {
        protected E element;
        protected LinkEntry<E> next;

        protected LinkEntry() { element = null; next = null; }
    }
} /* CS401StackLinkedListImpl<E> */