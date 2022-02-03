package Arrays;

/*
Write a program to find whether the array of integers contains a duplicate number or not.
If yes, print the index where duplicate element is found.
*/

import java.util.Scanner;

public class duplicateElements
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of integers in array");
        int arr[]=new int[sc.nextInt()];
        for (int i = 0; i < arr.length; i++)
        {
            System.out.println("Enter integer");
            arr[i]=sc.nextInt();
        }
        int t=0;
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = i+1; j < arr.length; j++)
            {
                if(arr[i]==arr[j])
                {
                    t=1;
                    System.out.println("Duplicates of "+arr[i]+" found at index " +j);
                }
            }
        }
        if(t==0)
            System.out.println("No duplicates found.");
    }
}
