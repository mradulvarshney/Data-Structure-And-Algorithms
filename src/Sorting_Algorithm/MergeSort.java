package Sorting_Algorithm;

import java.util.Scanner;

public class MergeSort
{
    public int[] mergeTwoSortedArray(int[] arr1, int[] arr2)
    {
        int[] merged = new int[arr1.length+ arr2.length];
        int i=0, j=0, k=0;
        while (i<arr1.length && j< arr2.length)
        {
            if (arr1[i]<=arr2[j])
            {
                merged[k++]=arr1[i];
                i++;
            }
            else
            {
                merged[k++]=arr2[j];
                j++;
            }
        }
        if (i<arr1.length)
        {
            while(i<arr1.length)
            {
                merged[k++]=arr1[i];
                i++;
            }
        }
        else
        {
            while(j<arr2.length)
            {
                merged[k++]=arr2[j];
                j++;
            }
        }
        return merged;
    }

    public int[] mergeSort(int[] arr, int lo, int hi)
    {
        if (lo==hi)
        {
            int[] ar = new int[1];
            ar[0]=arr[lo];
            return ar;
        }
        int mid = (lo+hi)/2;
        int[] fh = mergeSort(arr, lo, mid);
        int sh[] = mergeSort(arr, mid+1, hi);

        int[] merge = mergeTwoSortedArray(fh, sh);
        return merge;
    }

    public static void main(String[] args)
    {
        MergeSort obj = new MergeSort();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of Array:-");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++)
        {
            arr[i] = sc.nextInt();
        }

        int[] res = obj.mergeSort(arr, 0, arr.length-1);

        for (int i : res)
        {
            System.out.print(i+ " ");
        }
    }
}