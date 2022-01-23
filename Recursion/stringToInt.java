package Recursion;

/*
write a recursive function to convert a given string into the number it represents. That is input will be a numeric string that contains only numbers, you need to convert the string into a corresponding integer and return the answer. 

Sample Input: 
“2029” 

Sample Output: 
2029
*/

import java.util.Scanner;

public class stringToInt
{
    static int sum=0;
    public static int convert(String s, int index)
    {
        if(index==s.length())
            return sum;
        if(s.charAt(0)!=0)
            sum = sum * 10 + Integer.parseInt(String.valueOf(s.charAt(index)));
        return convert(s, index+1);
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(convert(s,0));
    }
}
