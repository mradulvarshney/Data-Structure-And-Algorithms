package Queue;

public class Queue_Using_LinkedList
{
    private static class Node
    {
        int data;
        Node next;
    }
    private Node head;
    private Node tail;
    private int size;

    public void display()
    {
        Node temp = this.head;
        while (temp!=null) {
            System.out.print(temp.data + ", ");
            temp = temp.next;
        }
        System.out.println();
    }
    public void enQueue(int data)
    {
        //create new node
        Node nn = new Node();
        nn.data = data;
        nn.next = null;

        //attach
        if(this.size>0)
        {
            this.tail.next = nn;
        }

        //update summary object
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
        return this.size;
    }

    public void deQueue() throws Exception
    {
        if(this.size==0)
            throw new Exception("LL is empty");
        if(this.size==1)
        {
            this.head=null;
            this.tail=null;
            this.size--;
        }
        else
        {
            this.head = this.head.next;
            this.size--;
        }
    }

    public int getFront()
    {
        return head.data;
    }

    public int getRear()
    {
        return tail.data;
    }
}
