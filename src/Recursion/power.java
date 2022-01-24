package Recursion;

/*
 Write a program to find x to the power n (i.e. x^n). Take x and n from the user. You need to return the answer.
Do this recursively.
Input format :
Two integers x and n (separated by space)
Output Format :
x^n (i.e. x raise to the power n)
Sample Input 1 :
 3 4
Sample Output 1 :
81
*/

import java.util.Scanner;

public class power
{
    public int pow(int n, int x)
    {
        if (n == 0)
            return 0;
        else if (x==0)
            return 1;
        else
            return n*pow(n,x-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        power obj = new power();
        int n = sc.nextInt();
        int x = sc.nextInt();
        int res =obj.pow(n,x);
        System.out.println(res);
    }
}
