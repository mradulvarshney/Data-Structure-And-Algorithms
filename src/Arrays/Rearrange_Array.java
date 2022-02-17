package Arrays;

/*Print an array that contains the exact same number as the given array,
but rearrange so that all the even numbers come before all the odd numbers.
Other than that, the numbers can be in any order. You may modify and print the given array, or make a new array.

Rearrange ([3,3,2]) -> [2,3,3]
Rearrange(0,1,0,1,1,]) -> [0,0,1,1,1]

*/

import java.util.Arrays;
import java.util.Scanner;

public class Rearrange_Array
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] newArr = new int[n];
        int k=0;

        for (int i=0; i<n; i++)
        {
            arr[i] = sc.nextInt();
            if(arr[i]%2==0)
                newArr[k++]=arr[i];
        }
        for (int i=0; i<n; i++)
        {
            if(arr[i]%2!=0)
                newArr[k++]=arr[i];
        }

        System.out.println(Arrays.toString(newArr));
    }
}
