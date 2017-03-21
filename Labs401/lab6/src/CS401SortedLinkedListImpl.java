/**
 * Created by shubhankar on 10/4/16.
 */
public class CS401SortedLinkedListImpl<E> extends CS401LinkedListImpl<E>
{
    public CS401SortedLinkedListImpl()
    {
        super();
    }

    /**
     * Adds element e in sorted order in the collection class (linked
     * list).
     * Returns true if e was added successfully, false otherwise.
     */
    public boolean add(E e)
    {
        /**
         * Add code here. */
        LinkEntry<E> ne = new LinkEntry<>();
        ne.element = e;
        if (head == null && tail == null) {
            head = tail = ne;
            num_elements++;
            return true;
        } else {
            LinkEntry<E> prev = null;
            LinkEntry<E> temp;

            for (temp = head; temp != null; temp = temp.next) {
                int comp = ((Comparable) e).compareTo(temp.element);
                if (comp < 0) {
                    break;
                }
                prev = temp;
            }

            if (prev == null) {
                ne.next = head;
                head = ne;
            } else if (temp == null) {
                tail.next = ne;
                tail = ne;
            } else {
                ne.next = prev.next;
                prev.next = ne;
            }

        }
        num_elements++;
        return true;
    }

    /**
     * Print the sorted linked list in reverse order using recursion.
     */
    public void reverse_print()  {
        /**
         * Add code here
         */
        StringBuilder result = new StringBuilder();
        LinkEntry<E> le = head;

        /**
         * Add code here.
         * Traverse the linked list and serialize each object.  Add the
         * serialized form to result. */
        int current = num_elements;
        while (current != 0) {
            for (int i = 1; i < current; i++) {
                le = le.next;
            }
            result = result.append(le.element);
            current--;
            le = head;
        }
        System.out.println(result.toString());
        return;
    }

} /* CS401SortedLinkedListImpl<E> */