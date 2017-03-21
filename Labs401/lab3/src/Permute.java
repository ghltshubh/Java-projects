public class Permute
{
    public static void main (String [ ] args)
    {
        System.out.println(permute("ACBD"));
    }

    public static String permute (String s)
    {
        return recPermute (s.toCharArray(), 0);
    }
    protected static String recPermute (char[] c, int k)
    {
        if (k == c.length - 1)
            return String.valueOf (c) + "\n";
        else
        {
            String allPermutations = new String();

            char temp;

            for (int i = k; i < c.length; i++)
            {
                temp = c [i];
                c [i] = c [k];
                c [k] = temp;
                allPermutations = allPermutations + recPermute (String.valueOf (c).toCharArray(), k + 1);
            }
            return allPermutations;
        }
    }
}