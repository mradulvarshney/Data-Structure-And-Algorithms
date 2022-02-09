package LinkedList;

import java.util.Scanner;

public class Palindrome_LL
{
    public static boolean checkPalindrome(Linked_List list, int start, int end) throws Exception
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
            Linked_List list = new Linked_List();
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
