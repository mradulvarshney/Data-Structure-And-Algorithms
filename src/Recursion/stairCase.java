package Recursion;

public class stairCase
{
    public static int count(int curr, int end)
    {
        if(curr==end)
            return 1;
        if(curr>end)
            return 0;
        int c=0;
        for(int i=1;i<=3;i++)
            c+=count(curr+i, end);
        return c;
    }
    public static void main(String[] args)
    {
        System.out.println(count(0,4));
    }
}
