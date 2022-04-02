package Searching_Algorithm;

import java.util.Scanner;

public class Linear_Search
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t=0;
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] arr =  new int[n];
        for (int i=0; i<n; i++)
            arr[i]=sc.nextInt();
        System.out.print("Enter the element to search: ");
        int num = sc.nextInt();
        for (int i=0; i<n; i++)
        {
            if (num==arr[i])
            {
                System.out.println("Element found at index " + i);
                t=1;
                break;
            }
        }
        if (t==0)
            System.out.println("Element not found.");
    }
}
