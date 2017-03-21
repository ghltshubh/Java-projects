/**
 * Created by shubhankar on 10/7/16.
 */
public class CS401StackLinkedListMain {
    public static void main(String[] args) {
        CS401StackLinkedListImpl<String> linkedListStack = new CS401StackLinkedListImpl<>();
        linkedListStack.push("a");
        linkedListStack.push("b");
        linkedListStack.push("c");
        linkedListStack.push("d");
        linkedListStack.push("e");
        linkedListStack.push("f");
        linkedListStack.push("g");
        linkedListStack.push("h");
        linkedListStack.push("i");
        linkedListStack.push("j");


        System.out.println("Stack size is: " + linkedListStack.size());

        linkedListStack.push("k");

        System.out.println("Stack size is: " + linkedListStack.size());

        System.out.println("Popped value is: " + linkedListStack.pop());

        System.out.println("Popped value is: " + linkedListStack.pop());

        System.out.println("Top value is: " + linkedListStack.peek());

        System.out.println("Stack size is: " + linkedListStack.size());
    }
}
