package Arrays;

/*
Mr Raman is having two unsorted arrays with names myarr1 and myarr2. They can be of any size.
They may contain duplicate values also. Raman wants for each element in myarr1[ ]
to count elements greater than or equal to it in array myarr2[].

Example

Imagine the size of both the arrays are 5

myarr1[]  values  {3,4,1,2,2}
myarr2[] values  {1,2,1,3,1}

Output :
1,0,5,2,2
*/

import java.util.Scanner;

public class count
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array myarr1[]:");
        int[] myarr1 = new int[sc.nextInt()];
        System.out.println("Enter size of array myarr2[]:");
        int[] myarr2 = new int[sc.nextInt()];
        System.out.println("Enter elements in myarr1[]:");
        for(int i=0;i<myarr1.length;i++)
        {
            myarr1[i]= sc.nextInt();
        }
        System.out.println("Enter elements in myarr2[]:");
        for(int i=0;i<myarr2.length;i++)
        {
            myarr2[i]= sc.nextInt();
        }
        for(int i:myarr1)
        {
            int count=0;
            for(int j:myarr2)
            {
                if(j>=i)
                {
                    count++;
                }
            }
            System.out.print(count+",");
        }
    }
}
