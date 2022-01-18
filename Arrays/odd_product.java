/*
Write a short Java function that takes an array of int values  
as an argument and determines 
if there is a pair of numbers in the array whose product is odd. 
 */
import java.util.Scanner;

public class odd_prduct
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        for (int i=0;i< arr.length;i++)
        {
            arr[i]=Integer.parseInt(sc.next());
        }
        for (int i=0;i< arr.length;i++)
        {
            for (int j=i+1;j< arr.length;j++)
            {
                if((arr[i]*arr[j])%2!=0)
                {
                    System.out.println("Product of "+arr[i]+" and "+arr[j]+" is odd.");
                }
            }
        }
    }
}
