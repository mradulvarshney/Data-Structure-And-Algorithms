package LinkedList;

/*
In a sorted linked list (elements are sorted in ascending order), eliminate duplicates
from the given linked list, such that output linked list contains only unique elements.
*/

import java.util.Scanner;

public class Remove_Duplicates
{
    public static Linked_List removeDuplicates(Linked_List list, int index) throws Exception
    {
        if(index== list.size()-1)
            return list;
        if(list.getAt(index)== list.getAt(index+1)) {
            list.removeAt(index+1);
            return removeDuplicates(list, index);
        }
        return removeDuplicates(list, index+1);
    }

    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        Linked_List list = new Linked_List();
        System.out.println("After adding last element input -1");
        while(true)
        {
            int n = sc.nextInt();
            if(n==-1)
                break;
            list.addLast(n);
        }
        removeDuplicates(list, 0).display();
    }
}
