package LinkedList;

public class Linked_List
{
    private static class Node
    {
        int data;
        Node next;
    }
    private Node head;
    private Node tail;
    private int size;

    public void addLast(int data)
    {
        Node nn = new Node();
        nn.data = data;
        nn.next = null;
        if(this.size>0)
        {
            this.tail.next = nn;
        }
        if(this.size==0)
        {
            this.head = nn;
            this.tail = nn;
            this.size++;
        }
        else
        {
            this.tail = nn;
            this.size++;
        }
    }

    public int size()
    {
        int length=0;
        Node tmp=head;
        while(tmp!=null)
        {
            length++;
            tmp=tmp.next;
        }
        return length;
    }

    public int get(int index)
    {
        if(index<0 || index>size())
            throw new IndexOutOfBoundsException();
        else
        {
            Node tmp=head;
            for (int i=0; i<index; i++)
            {
                tmp=tmp.next;
            }
            return tmp.data;
        }
    }

}
