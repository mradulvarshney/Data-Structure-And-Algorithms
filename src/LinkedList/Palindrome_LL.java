package LinkedList;

/*
Palindrome LinkedList

You have been given a head to a singly linked list of integers. Write a function check to whether the list given is a 'Palindrome' or not.
 Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

First and the only line of each test case or query contains the the elements of the singly linked list separated by a single space.
 Remember/Consider :
While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element.
 Output format :
For each test case, the only line of output that print 'true' if the list is Palindrome or 'false' otherwise.
 Constraints :
1 <= t <= 10^2
0 <= M <= 10^5
Time Limit: 1sec

Where 'M' is the size of the singly linked list.
Sample Input 1 :
1
9 2 3 3 2 9 -1
Sample Output 1 :
true
Sample Input 2 :
2
0 2 3 2 5 -1
*/

import java.util.Scanner;

public class Palindrome_LL
{
    public static boolean checkPalindrome(Singly_Linked_List list, int start, int end) throws Exception
    {
        if (start== list.size()-1)
            return true;
        if (list.getAt(start)!=list.getAt(end))
            return false;
        return checkPalindrome(list,start+1, end-1);
    }

    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of test cases you want to execute:");
        int testcases = sc.nextInt();
        while (testcases--!=0) {
            System.out.println("Enter elements in LL");
            System.out.println("To exit from LL input -1 at the end.");
            Singly_Linked_List list = new Singly_Linked_List();
            while (true) {
                int n = sc.nextInt();
                if (n == -1)
                    break;
                list.addLast(n);
            }
            System.out.println(checkPalindrome(list,0,list.size()-1));
        }
    }
}
