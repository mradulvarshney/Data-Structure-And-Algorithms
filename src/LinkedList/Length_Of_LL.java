package LinkedList;

/*
Length Of LL
For a given singly linked list of integers, find and return its length. Do it using an iterative method.
Input format :
The first line contains an Integer 't' which denotes the number of ClassTestQuestions.test cases or queries to be run. Then the ClassTestQuestions.test cases follow.
First and the only line of each ClassTestQuestions.test case or query contains elements of the singly linked list separated by a single space.
 Remember/Consider :
While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element.
Output format :
For each ClassTestQuestions.test case, print the length of the linked list.
Output for every ClassTestQuestions.test case will be printed in a separate line.
 Constraints :
1 <= t <= 10^2
0 <= N <= 10^5
Time Limit: 1 sec
Sample Input 1 :
1
3 4 5 2 6 1 9 -1
Sample Output 1 :
7
Sample Input 2 :
2
10 76 39 -3 2 9 -23 9 -1
-1
Sample Output 2 :
8
0
*/

import java.util.Scanner;

public class Length_Of_LL
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of testcases:");
        int testcase = sc.nextInt();
        while(testcase--!=0)
        {
            Singly_Linked_List list = new Singly_Linked_List();
            System.out.println("Enter elements in LL");
            System.out.println("To exit from LL input -1 at the end.");
            while (true)
            {
                int n = sc.nextInt();
                if (n == -1)
                    break;
                list.addLast(n);
            }
            System.out.println("Length of LinkedList is "+ list.size());
            System.out.println();
        }
    }
}