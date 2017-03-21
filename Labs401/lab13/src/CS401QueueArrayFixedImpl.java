/**
 * Created by shubhankar on 11/22/16.
 */
/*
 * Fixed front implementation of a Queue using arrays */

public class CS401QueueArrayFixedImpl<E> implements CS401QueueInterface<E>  {
    private E[] data;
    private int front, back;
    private int capacity;

    public CS401QueueArrayFixedImpl(int num_elems)   {
        capacity = num_elems;
        data = (E[]) new Object[capacity];
        front = back = 0;
    }

    public void add(E element) {

        /*** Add code ***/
        if (is_full()) {
            grow();
        }
        data[back] = element;
        back++;
    }

    public E remove()  {

        /*** Add code ***/
        if (is_empty()) {
            return null;
        }

        E e = data[front];
        for (int i=0; i<data.length-1; i++) {
            data[i] = data[i + 1];
        }
        back--;
        return e;
    }

    public E peek()  {

        /*** Add code ***/
        if (is_empty()) {
            return null;
        }
        return data[front];
    }

    public boolean is_empty()  {

        /*** Add code ***/
        return front == back;
    }

    public boolean is_full()  {

        /*** Add code ***/
        return back == capacity;
    }

    public void grow() {
        capacity = 2*capacity;
        CS401QueueArrayFixedImpl<E> queueArrayFixed = new CS401QueueArrayFixedImpl<>(capacity);
        for (int i=0; i<capacity/2; i++) {
            queueArrayFixed.data[i] = data[i];
        }
        data = queueArrayFixed.data;
    }
}