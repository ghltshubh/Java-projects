/**
 * Created by shubhankar on 10/4/16.
 */

public class CS401DblLinkedListImpl<E> extends CS401LinkedListImpl<E>
{
    private LinkEntry<E> head;
    private LinkEntry<E> tail;
    private int num_elements = 0;

    public CS401DblLinkedListImpl()
    {
        head = tail = null;
    }

    public boolean is_empty()
    {
        return head == null;

    }

    public boolean is_full() { return false; }

    public int size() { return num_elements; }

    /*
     * Add e to the end of the doubly linked list.
     * Returns true - if e was successfully added, false otherwise.
     */
    public boolean add(E e) {
        add(Where.BACK, e);
        return true;
    }

    /**
     * Remove element indicated by i.
     * If the element exists in the collection, return that element back
     * to the user.  If index is out of bounds, return null.
     */
    public E remove(int i)
    {
        /**
         * Add code here. */
        LinkEntry<E> j = head;
        E ele;
        if (i > num_elements || i < 1) {
            return null;
        }

        else if (i == 1) {
            ele = j.element;
            head = head.next;
            head.previous = null;
        }

        else if (i == num_elements) {
            /*for (int k=1; k<(num_elements - 2); k++) {
                j = j.next;
            }
            ele = (j.next).element;
            j.next = null;
            tail = j;*/

            ele = tail.element;
            tail = tail.previous;
            tail.next = null;
        }

        else {
            for (int k = 1; k < (i - 2); k++) {
                j = j.next;
            }
            ele = (j.next).element;
            ((j.next).next).previous = j;
            j.next = (j.next).next;
        }
        num_elements--;
        return ele;
    }

    /**
     * Determines if e is in the collection.
     * Hint: Remember lecture on comparison.
     * Returns true if e is in the collection, false otherwise. */
    public boolean contains(E e)
    {
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

    /**
     * Add e to either front of the linked list or the end of the linked
     * list, depending on the value of the parameter where.
     * If where == MIDDLE, return false.
     * Returns true if element added to back or front, or false if asked
     * to add in the middle. */
    public boolean add(Where where, E e)  {

        if (where == Where.MIDDLE)
            return false;

        LinkEntry<E> ne = new LinkEntry<E>();
        ne.element = e;

        /**
         * Add code here.
         * Hint: follow the same logic as
         * CS401LinkedListImpl::add(Where where, E e) except account for
         * the previous and next references in the doubly linked list. */

        if (head == null && tail == null) {
            head = tail = ne;
            num_elements++;
            return true;
        }

        else if (where == Where.BACK) {
            tail.next = ne;
            ne.previous = tail;
            tail = ne;
        }

        else if (where == Where.FRONT) {
            /**
             * Add code here. */
            ne.next = head;
            if (head != null) {
                head.previous = ne;
            }
            head = ne;

        }
        num_elements++;
        return true;
    }

    /**
     * Add e to the middle of a linked list.  More specifically, add e
     * after index in the linked list.
     * First element of the linked list is 1, second is 2, and so on.
     *
     * Returns true if element added, false if where != MIDDLE. */
    public boolean add(Where where, int index, E e)  {

        /**
         * Add code here.
         * Hint: follow the same logic as
         * CS401LinkedListImpl::add(Where where, int index, E e) except
         * account for the previous and next references in the doubly
         * linked list. */

        LinkEntry<E> ne = new LinkEntry<>();
        ne.element = e;
        LinkEntry<E> j = head;
        LinkEntry<E> t = tail;
        for (int i=1; i<index-2; i++) {
            j = j.next;
        }
        ne.next = j.next;
        ne.previous = j;
        (j.next).previous = ne;
        j.next = ne;
        num_elements++;

        return true;
    }

    /**
     * Print the doubly linked list starting at the beginning.
     */
    public void print_from_beginning()
    {
        /** Add code here **/
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
        System.out.println(result.toString());

        return;
    }

    /**
     * Print the doubly linked list starting the end.
     */
    public void print_from_end()
    {
        /** Add code here **/
        StringBuilder result = new StringBuilder();
        LinkEntry<E> le = tail;

        /**
         * Add code here.
         * Traverse the linked list and serialize each object.  Add the
         * serialized form to result. */
        for (int i=num_elements; i>=1; i--) {
            result = result.append(le.element);
            le = le.previous;
        }
        System.out.println(result.toString());
        return;
    }

    /* ------------------------------------------------------------------- */
   /* Inner classes                                                      */
    protected class LinkEntry<E>
    {
        protected E element;
        protected LinkEntry<E> next;
        protected LinkEntry<E> previous;
        protected LinkEntry() { element = null; next = previous = null; }
    }
} /* CS401LinkedListImpl<E> */