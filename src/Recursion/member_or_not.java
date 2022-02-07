package Recursion;

/*
Design a method that returns true if element num is a member of
given array and false if not by using the recursion.
*/

import java.util.Scanner;

public class member_or_not
{
    public static boolean check(int[] arr, int num, int index)
    {
        if(arr.length==index)
            return false;
        if(arr[index]==num)
            return true;
        return check(arr, num ,index+1);
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of an array");
        int[] arr = new int[sc.nextInt()];
        for (int i = 0; i < arr.length; i++)
            arr[i]= sc.nextInt();
        System.out.println("Enter element ot search");
        int num = sc.nextInt();
        System.out.println(check(arr, num,0));
    }
}
