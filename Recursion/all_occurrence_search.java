package Recursion;

/*
Create an array of 5 elements with values {1,7,4,7,6}.Search value 7 in the given array 
and print all the  occurrence(index) of search value(7) by holding the index in a result array . Do it recursively 

The prototype of the method is as follows:-

public static int[] res(int arr[], int current index, int search_value)
{
	// set of statements;
}
*/

import java.util.Scanner;

public class all_occurrence_search
{
    static Scanner sc = new Scanner(System.in);
    static {System.out.println("Enter size of array: ");}
    static int n =sc.nextInt(), c=0, a=0;
    static int[] searchArr = new int[n];
    public static int[] search(int[] arr, int n, int index)
    {
        if(index==arr.length)
            return searchArr;
        if (n==arr[index])
        {
            searchArr[a]=index;
            a++;
            c++;
        }
        return search(arr,n,index+1);
    }

    public static void main(String[] args)
    {
        int[] arr = new int[n];
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter element to search:");
        int n= sc.nextInt();
        searchArr = search(arr,n,0);
        if(c==0)
            System.out.println("No element found");
        else
            for (int i=0;i<c;i++)
                System.out.print(searchArr[i]+" ");
    }
}
