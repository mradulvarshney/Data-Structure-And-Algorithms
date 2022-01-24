package Arrays;

/*Me Bean is very good in mathematics. He was given a number n and was told to find out number of trailing zeroes in n! (Factorial) . Can you help him?

Sample Input
5
Sample Output
1
Explanation
5! (Factorial) is 120, so there is one trailing zero.

Implement it by using loop
*/

import java.util.Scanner;

public class trailingZeroes
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int f=1, i=1, count=0;
        while(n>0)
        {
            f*=i;
            i++;
            n--;
        }
        while(f>0)
        {
            if(f%10 == 0)
            {
                count++;
                f/=10;
            }
            else break;
        }
        System.out.println("No. of trailing zeroes are: " + count);
    }
}
