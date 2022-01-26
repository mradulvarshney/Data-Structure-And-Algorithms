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

//
//public class all_occurrence_search
//{
//    static Scanner sc = new Scanner(System.in);
//    static {System.out.println("Enter size of array: ");}
//    static int n =sc.nextInt(), c=0, a=0;
//    static int[] searchArr = new int[n];
//    public static int[] search(int[] arr, int n, int index)
//    {
//        if(index==arr.length)
//            return searchArr;
//        if (n==arr[index])
//        {
//            searchArr[a]=index;
//            a++;
//            c++;
//        }
//        return search(arr,n,index+1);
//    }
//
//    public static void main(String[] args)
//    {
//        int[] arr = new int[n];
//        for(int i=0;i<arr.length;i++)
//        {
//            arr[i]=sc.nextInt();
//        }
//        System.out.println("Enter element to search:");
//        int n= sc.nextInt();
//        searchArr = search(arr,n,0);
//        if(c==0)
//            System.out.println("No element found");
//        else
//            for (int i=0;i<c;i++)
//                System.out.print(searchArr[i]+" ");
//    }
//}



//********   Another method     ********//

public class all_occurrence_search
{
    public static int[] search(int[] arr, int data, int index, int count)
    {
        if(index==arr.length)
        {
            int[] r = new int[count];
            return r;
        }
        int[] ind = null;
        if(arr[index]==data)
            ind=search(arr,data,index+1,count+1);
        else
            ind=search(arr,data,index+1,count);
        if(arr[index]==data)
            ind[count]=index;
        return ind;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array:");
        int[] arr = new int[sc.nextInt()];
        for(int i=0;i< arr.length;i++)
            arr[i]=sc.nextInt();
        System.out.println("Enter the element to search:");
        int n = sc.nextInt();
        int[] res = search(arr, n, 0, 0);
        if(res.length==0)
            System.out.println("No element found.");
        else
            for(int i=0;i<res.length;i++)
                System.out.print(res[i]+" ");

    }
}