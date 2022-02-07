package Recursion;

/*
Write a recursive function to convert a decimal no into a binary no, print the binary number.
*/

import java.util.Scanner;

public class decimalToBinary
{
    public static int binaryConvert(int num, String s)
    {
        if(num==0)
            return Integer.parseInt(s);
        else
        {
            int rem = num%2;
            s=rem+s;
            return binaryConvert(num/2, s);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a decimal number");
        int num = sc.nextInt();
        System.out.println("Binary representation of "+ num+ " is "+ binaryConvert(num,""));
    }
}
