package Arrays;

/*
Write a program to input the elements of a two- dimensional array. 
Then from this array, make two arrays one that stores all 
odd elements of the two-dimensional array 
and the other that stores all even elements of the array.
Note:-  Resulting arrays will be of ArrayList type 
*/
import java.util.ArrayList;
import java.util.Scanner;

public class even_odd
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no. of rows and columns");
        int m=sc.nextInt();
        int n= sc.nextInt();
        int[][] arr =new int[m][n];
        ArrayList<Integer> even=new ArrayList();
        ArrayList<Integer> odd=new ArrayList();
        for(int i=0;i<m;i++)
        {
            for (int j = 0; j < n; j++)
            {
                arr[i][j]= sc.nextInt();
                if(arr[i][j]%2==0)
                    even.add(arr[i][j]);
                else
                    odd.add(arr[i][j]);
            }
        }
        System.out.println(even);
        System.out.println(odd);
    }
}
