package LinkedList;

/*
Print ith Node

For a given a singly linked list of integers and a position 'i', print the node data at the 'i-th' position.
 Note :
Assume that the Indexing for the singly linked list always starts from 0.

If the given position 'i',  is greater than the length of the given singly linked list, then don't print anything.
Input format :
The first line contains an Integer 't' which denotes the number of ClassTestQuestions.test cases or queries to be run. Then the ClassTestQuestions.test cases follow.

The first line of each ClassTestQuestions.test case or query contains the elements of the singly linked list separated by a single space.

The second line contains the value of 'i'. It denotes the position in the given singly linked list.
 Remember/Consider :
While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element.
Output format :
For each ClassTestQuestions.test case, print the node data at the 'i-th' position of the linked list(if exists).

Output for every ClassTestQuestions.test case will be printed in a seperate line.
 Constraints :
1 <= t <= 10^2
0 <= N <= 10^5
i  >= 0
Time Limit: 1sec
Sample Input 1 :
1
3 4 5 2 6 1 9 -1
3
Sample Output 1 :
2
Sample Input 2 :
2
3 4 5 2 6 1 9 -1
0
9 8 4 0 7 8 -1
3
Sample Output 2 :
3
0
*/

import java.util.Scanner;

public class getElementAtIndex
{
    public static void main(String[] args) throws Exception
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
            System.out.println("Enter the index:");
            int index = sc.nextInt();
            System.out.println("Data at index "+ index+ " is "+ list.getAt(index));
        }
    }
}
