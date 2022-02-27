package Queue;

public class Doubly_Ended_Queue_Using_Singly_LL
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
    public void enQueue_rear(int data)
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

    public void enQueue_front(int data)
    {
        //create a new node
        Node nn = new Node();
        nn.data=data;
        nn.next=null;

        //attach
        if(this.size>0)
        {
            nn.next=head;
        }

        //update summary object
        if(this.size==0)
        {
            this.head=nn;
            this.tail=nn;
            this.size++;
        }
        else
        {
            this.head=nn;
            this.size++;
        }
    }

    private Node getNodeAt(int index) throws Exception
    {
        if(this.size==0)
            throw new Exception("LL is empty");
        if(index<0 || index>this.size-1)
            throw new IndexOutOfBoundsException("Invalid Index");
        Node tmp = this.head;
        for (int i=0; i<index; i++)
        {
            tmp=tmp.next;
        }
        return tmp;
    }

    public void deQueue_front() throws Exception
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

    public void deQueue_rear() throws Exception
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
            Node sm2 = getNodeAt(this.size-2);
            this.tail=sm2;
            this.tail.next=null;
            this.size--;
        }
    }
}