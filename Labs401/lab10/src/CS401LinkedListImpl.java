/**
 * Created by shubhankar on 10/31/16.
 */
import java.util.Iterator;

public class CS401LinkedListImpl<E> implements CS401CollectionInterface<E>, Iterable<E> {
    protected LinkEntry<E> head;
    protected LinkEntry<E> tail;
    protected int num_elements = 0;


    public CS401LinkedListImpl() {
        head = tail = null;
    }

    protected class CS401LinkedListIterator implements Iterator<E> {
        protected LinkEntry<E> current;
        protected CS401LinkedListIterator() {
            current = head;
        }
        public E next()
        {
            /* To be filled in by students … */
            return (current.next).element;
        }
        public boolean hasNext() {
            return current != null;
        }
        public void remove() /* Remove the element under the iterator. */
        {
            /*
            * * To be filled in by students ... */
            current.next = (current.next).next;
            num_elements--;
        }
    } /* class CS401LinkedListIterator() */


    @Override
    public Iterator<E> iterator() {
        return new CS401LinkedListIterator();
    }

    /**
     * Methods inherited from CS401CollectionInterface
     */
    public boolean is_empty() {
        return head == null;

    }

    public boolean is_full() {
        return false;
    }

    public int size() {
        return num_elements;
    }

    /*
     * Adds element e at the end of the linked list. */
    public boolean add(E e) {
        add(Where.BACK, e);

        return true;
    }

    /**
     * Remove element indicated by i.
     * If the element exists in the collection, return that element back
     * to the user.  If index is out of bounds, return null.
     */
    public E remove(int i) {
        /**
         *Add code here.
         **/
        LinkEntry<E> j = head;
        E ele;
        if (i > num_elements) {
            return null;
        }

        else if (i == 1) {
            ele = j.element;
            head = head.next;
            num_elements--;
        }

        else if (i == num_elements) {
            for (int k=1; k<num_elements-2;k++) {
                j = j.next;
            }
            ele = (j.next).element;
            j.next = null;
            tail = j;
            num_elements--;
        }

        else {
            for (int k = 1; k < i - 2; k++) {
                j = j.next;
            }
            ele = (j.next).element;
            j.next = (j.next).next;
            num_elements--;
        }
        return ele;
    }

    /**
     * Determines if e is in the collection.
     * Hint: Remember lecture on comparison.
     * Returns true if e is in the collection, false otherwise.
     */
    public boolean contains(E e) {
        /**
         * Add code here. */
        LinkEntry<E> le = head;
        boolean ret = false;
        for (int i=1; i<num_elements; i++) {
            if ((le.element).equals(e)) {
                ret = true;
            }
            le = le.next;
        }
        return ret;
    }


    public E search(E e) {
        LinkEntry<E> le = head;
        while (true) {
            {
                if (le == null)
                    break;
                if ((le.element).equals(e)) {
                    return le.element;
                }
                le = le.next;
            }
        }
        return null;
    }

    /**
     * Add e to either front of the linked list or the end of the linked
     * list, depending on the value of the parameter where.
     * If where == MIDDLE, return false.
     * Returns true if element added to back or front, or false if asked
     * to add in the middle.
     */
    public boolean add(Where where, E e) {

        if (where == Where.MIDDLE) return false;

        LinkEntry<E> ne = new LinkEntry<E>();
        ne.element = e;

        if (head == null && tail == null) {
            head = tail = ne;
            num_elements++;
            return true;
        }

        if (where == Where.BACK) {
            tail.next = ne;
            tail = ne;
        }
        else if (where == Where.FRONT) {
            /**
             * Add code here. */
            ne.next = head;
            head = ne;

        }
        num_elements++;
        return true;
    }

    /**
     * Add e to the middle of a linked list.  More specifically, add e
     * after index in the linked list.
     * First element of the linked list is 1, second is 2, and so on.
     * <p>
     * Returns true if element added, false if where != MIDDLE.
     */
    public boolean add(Where where, int index, E e) {
        /**
         * Add code here. */
        LinkEntry<E> ne = new LinkEntry<>();
        ne.element = e;
        LinkEntry<E> j = head;
        for (int i=1; i<index; i++) {
            j = j.next;
        }
        ne.next = j.next;
        j.next = ne;
        num_elements++;
        return true;
    }

    /**
     * Print the collection class (linked list) by iterating over all of
     * the elements in the collection class and serializing them.
     * Returns a Java String object that represents the serialization of
     * the collection class.
     */
    public String toString() {

        StringBuilder result = new StringBuilder();
        LinkEntry<E> le = head;

        /**
         * Add code here.
         * Traverse the linked list and serialize each object.  Add the
         * serialized form to result. */
        for (int i=1; i<=num_elements; i++) {
            result = result.append(le.element);
            le = le.next;
        }
        return result.toString();
    }


    /* ------------------------------------------------------------------- */
   /* Inner classes                                                      */
    protected class LinkEntry<E> {
        protected E element;
        protected LinkEntry<E> next;
    }
   /* ------------------------------------------------------------------- */

} /* CS401LinkedListImpl<E> */
