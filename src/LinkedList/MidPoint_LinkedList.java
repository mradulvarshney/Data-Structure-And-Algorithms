package LinkedList;

/*
Mid Point Linked List

For a given singly linked list of integers, find and return the node present at the middle of the list.


Note : If the length of the singly linked list is even, then return the first middle node.

Example: Consider, 10 -> 20 -> 30 -> 40 is the given list, then the nodes present at the middle with respective data values are, 20 and 30. We return the first node with data 20.
 Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

The first and the only line of each test case or query contains the elements of the singly linked list separated by a single space.
Remember/Consider :
While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element
 Output Format :
For each test case/query, print the data value of the node at the middle of the given list.

Output for every test case will be printed in a seperate line.
Constraints :
1 <= t <= 10^2
0 <= M <= 10^5
Where M is the size of the singly linked list.

Time Limit: 1sec
Sample Input 1 :
1
1 2 3 4 5 -1
Sample Output 1 :
3
Sample Input 2 :
2
-1
1 2 3 4 -1
Sample Output 2 :
2
*/

import java.util.Scanner;

public class MidPoint_LinkedList
{
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of test cases you want to execute:");
        int testcases = sc.nextInt();
        while (testcases--!=0)
        {
            System.out.println("Enter elements in LL");
            System.out.println("To exit from LL input -1 at the end.");
            Singly_Linked_List list = new Singly_Linked_List();
            while (true)
            {
                int n = sc.nextInt();
                if (n==-1)
                    break;
                list.addLast(n);
            }
            if(list.size()==0)
                continue;
            else
                System.out.println(list.mid());
        }
    }
}
