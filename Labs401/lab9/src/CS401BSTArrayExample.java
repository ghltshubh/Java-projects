/**
 * Created by shubhankar on 10/26/16.
 */
public class CS401BSTArrayExample {
    public static void main (String[] args)
    {
        new CS401BSTArrayExample().run();
    } // method main

    public void run()  {
        run_example_1();
    }

    public void run_example_1()  {

        CS401BSTArray<Integer> t = new CS401BSTArray<>();
        int nums[] = {100, 59, 13, 82, 58, 63, 65, 46, 80, 62, 28, 71,
                92, 47, 93, 8};

        for (int i = 0; i < nums.length; i++)
            t.add(nums[i]);

        //---------------Lab8_2------------------------//
/*        System.out.println("LAB8 Q2: Number of leaves in the tree: " + t.leaves() + "\n\n\n");
        System.out.println("Height of the tree is: " + t.height());*/
        System.out.println("Tree:\nLength: " + t.size());
        System.out.println("Elements: ");
        t.inorder();
        System.out.println();

        Integer r = 100;
        System.out.println("Removing element " + r);
        if (t.remove(r))  {
            System.out.println("Element " + r + " removed.");
            System.out.println("Tree:\nLength: " + t.size());
            System.out.println("Elements: ");
            t.inorder();
            System.out.println();
        }
        else  {
            System.out.println("Element " + r + " does not exist in the tree.");
            System.out.println();
        }

        r = 59;
        System.out.println("Removing element " + r);
        if (t.remove(r))  {
            System.out.println("Element " + r + " removed.");
            System.out.println("Tree:\nLength: " + t.size());
            System.out.println("Elements: ");
            t.inorder();
            System.out.println();
        }
        else  {
            System.out.println("Element " + r + " does not exist in the tree.");
            System.out.println();
        }

        return;
    }

}
