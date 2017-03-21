/**
 * Created by shubhankar on 10/7/16.
 */
public class CS401StackArrayImpl<E> implements CS401StackInterface<E>
{
    private int num_elements;
    private int max_elements;
    private E[] elements;

    public CS401StackArrayImpl(int n)
    {
        max_elements = n;
        num_elements = 0;
        elements = (E[]) new Object[max_elements];
    }

    CS401StackArrayImpl() {
        this(10);
    }
    /**
     * Push an element on the stack.  If the stack is full, then allocate
     * more memory to hold a new stack, copy existing elements to the new
     * stack and add the new element to the newly enlarged stack.
     * Do not use System.arraycopy().  You are essentially implementing
     * what System.arraycopy() will do when you expand an existing array. **/
    public void push(E e)
    {
        /** Add code here **/
        if (is_full()) {
            grow();
        }
        if (elements[num_elements] == null) {
            elements[num_elements] = e;
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
        e = elements[num_elements - 1];
        elements[num_elements - 1] = null;
        num_elements--;
        return e;
    }

    public E peek()
    {
        /** Add code here **/
        if (num_elements == 0) {
            return null;
        }
        return elements[num_elements - 1];

    }

    public int size()
    {
        /** Add code here **/
        return num_elements;
    }

    public boolean is_full() {
        return num_elements == max_elements;
    }

    public boolean is_empty() {
        return num_elements == 0;
    }

    public boolean grow() {
        max_elements = 2 * max_elements;
        CS401StackArrayImpl<E> stackArray = new CS401StackArrayImpl<>(max_elements);
        for (int i = 0; i < max_elements/2; i++) {
            stackArray.elements[i] = this.elements[i];
        }
        this.elements = stackArray.elements;
        System.out.println("Capacity reached.  Increasing storage...");
        System.out.println("Growing stack capacity by " + max_elements/2 + " elements. New capacity is " + max_elements + " elements.");
        return true;
    }


} /* CS401StackArrayImpl<E> */