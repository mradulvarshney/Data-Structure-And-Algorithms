package Sorting_Algorithm;

import java.util.Scanner;

public class InsertionSort
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array:- ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = sc.nextInt();
        }

        for (int i=1; i<=arr.length-1; i++)
        {
            int val = arr[i];
            int j = i-1;
            while (j>=0 && arr[j]>val)
            {
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=val;
        }

        for (int i=0; i< arr.length; i++)
        {
            System.out.print(arr[i]+ " ");
        }
    }
}
