/**
 * Created by shubhankar on 10/11/16.
 */
/*
 * Floating front and back implementation of a queue using an array */

public class CS401QueueArrayFloatingImpl<E> implements CS401QueueInterface<E>  {
    private E[] data;
    private int front, back;
    private int capacity;

    public CS401QueueArrayFloatingImpl(int num_elems)   {
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
        back = (back + 1)%capacity;
    }

    public E remove()  {

        /*** Add code ***/
        if (is_empty()) {
            return null;
        }
        E e = data[front];
        front = (front + 1)%capacity;
        return e;

    }
    public E peek()  {

        /*** Add code ***/
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
        capacity = capacity * 2;
        CS401QueueArrayFloatingImpl<E> arrayFloating = new CS401QueueArrayFloatingImpl<>(capacity);
        for (int i=0; i<capacity/2; i++) {
            arrayFloating.data[i] = data[i];
        }
        data = arrayFloating.data;
    }

}
