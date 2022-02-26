package Stack;

public class Stack_Using_LinkedList
{
    private class Node
    {
        int data;
        Node next;
    }
    private Node head;
    private Node tail;
    private int size;

    public void display()
    {
        Node temp = head;
        while (temp!=null)
        {
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }

    public void push(int data)
    {
        Node nn = new Node();
        nn.data=data;
        nn.next=null;

        if(size>0)
        {
            nn.next=head;
        }

        if(this.size==0)
        {
            head = nn;
            tail = nn;
            size++;
        }
        else
        {
            head = nn;
            size++;
        }
    }

    public int pop() throws Exception
    {
        if(this.size==0)
            throw new Exception("Stack is empty");

        int data= head.data;
        if(size==1)
        {
            head=null;
            tail=null;
            size--;
        }
        else
        {
            head = head.next;
            size--;
        }
        return data;
    }

    public int peek() throws Exception
    {
        if(this.size==0)
            throw new Exception("Stack is empty");

        return head.data;
    }
}
