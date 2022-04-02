package Searching_Algorithm;

import java.util.Scanner;

public class Linear_Search_UsingRecursion
{
    public static int search(int[] arr, int index, int num)
    {
        if(index==arr.length)
            return -1;
        if (num==arr[index])
            return index;
        return search(arr,index+1, num);
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] arr =  new int[n];
        for (int i=0; i<n; i++)
            arr[i]=sc.nextInt();
        System.out.print("Enter the element to search: ");
        int num = sc.nextInt();
        int res = search(arr, 0, num);
        if (res>0)
            System.out.println("Element found at index " + res);
        else
            System.out.println("Element not found.");
    }
}
