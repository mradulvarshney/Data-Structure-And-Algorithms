package Searching_Algorithm;

import java.util.*;

public class Binary_Search
{
    public static int search(int[] arr, int item)
    {
        int lo = 0;
        int hi = arr.length-1;
        while (lo<=hi)
        {
            int mid = (lo+hi)/2;
            if (item>arr[mid])
            {
                lo = mid+1;
            }
            else if (item<arr[mid])
            {
                hi = mid-1;
            }
            else
                return mid;
        }
        return -1;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t=0;
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] arr =  new int[n];
        for (int i=0; i<n; i++)
            arr[i]=sc.nextInt();
        Arrays.sort(arr);
        System.out.print("Enter the element to search: ");
        int item = sc.nextInt();
        int res = search(arr, item);
        if (res>=0)
            System.out.println("Element found at index " + res);
        else
            System.out.println("Element not found.");
    }
}
