import java.util.Scanner;

public class duplicateElements
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of the Array");
        int[] arr=new int[sc.nextInt()];
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.print(arr[0]+" ");
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]==arr[i-1])
            {
                continue;
            }
            else
                System.out.print(arr[i]+" ");
        }
    }
}
