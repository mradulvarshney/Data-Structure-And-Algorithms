package Recursion;

public class stairCase
{
    public static int count(int curr, int end)
    {
        if(curr==end)
        {
            System.out.println("=="+curr);
            System.out.println();
            return 1;
        }
        if(curr>end)
        {
            System.out.println(">"+curr);
            System.out.println();
            return 0;
        }
        int c=0;
        for(int i=1;i<=3;i++)
        {
            System.out.println("i="+i);
            System.out.println("curr="+curr);
            System.out.println("c="+c);
            c += count(curr + i, end);
            System.out.println();
            System.out.println("i="+i);
            System.out.println("curr="+curr);
            System.out.println("c="+c);
            System.out.println();
        }
        return c;
    }
    public static void main(String[] args)
    {
        System.out.println(count(0,4));
    }
}
