package LinkedList;

public class Circular_Doubly_Linked_List
{
    private class Node
    {
        int data;
        Node next;
        Node prev;
    }
    private Node head;
    private Node tail;
    private int size;

    public void display_from_beginning()
    {
        Node temp=head;
        while (temp!=tail)
        {
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println(temp.data);
    }

    public void display_from_end()
    {
        Node temp=tail;
        while (temp!=head)
        {
            System.out.print(temp.data+" ");
            temp=temp.prev;
        }
        System.out.println(temp.data);
    }

    public void addLast(int data)
    {
        Node nn = new Node();
        nn.data=data;
        nn.next=null;
        nn.prev=null;

        if (size>0)
        {
            tail.next=nn;
            nn.prev=tail;
        }

        if (size==0)
        {
            head=nn;
            tail=nn;
            size++;
        }
        else
        {
            tail=nn;
            tail.next=head;
            head.prev=tail;
            size++;
        }
    }

    public void addFirst(int data)
    {
        Node nn = new Node();
        nn.data=data;
        nn.next=null;
        nn.prev=null;

        if(size>0)
        {
            nn.next=head;
            head.prev=nn;
        }

        if (size==0)
        {
            head=nn;
            tail=nn;
            size++;
        }
        else
        {
            head=nn;
            head.prev=tail;
            tail.next=head;
            size++;
        }
    }

    public void addAt(int data, int index) throws Exception
    {
        if(index<0 || index>size-1)
            throw new Exception("Invalid Index");

        if(index==0)
            addFirst(data);
        else if(index==this.size)
            addLast(data);
        else
        {
            Node nm1 = getNodeAt(index-1);
            Node np1 = getNodeAt(index);
            Node nn = new Node();
            nn.data = data;
            nn.next = null;
            nn.prev=null;

            //update summary object
            nm1.next=nn;
            nn.next=np1;
            nn.prev=nm1;
            np1.prev=nn;
            size++;
        }
    }

    public Node getNodeAt(int index) throws Exception
    {
        if (size==0)
            throw new Exception("LL is empty");
        if(index<0 || index>size-1)
            throw new Exception("Invalid Index");
        Node temp=head;
        for (int i=0; i<index; i++)
            temp=temp.next;
        return temp;
    }

    public int getAt(int index) throws Exception
    {
        if (size==0)
            throw new Exception("LL is empty");
        if(index<0 || index>size-1)
            throw new Exception("Invalid Index");
        Node temp=head;
        for (int i=0; i<index; i++)
            temp=temp.next;
        return temp.data;
    }

    public int size()
    {
        return size;
    }

    public void removeFirst()
    {
        if (size==0)
            System.out.println("LL is empty");
        else if(size==1)
        {
            head=null;
            tail=null;
            size--;
        }
        else
        {
            head=head.next;
            head.prev=tail;
            size--;
        }
    }

    public void removeLast()
    {
        if (size==0)
            System.out.println("LL is empty");
        else if(size==1)
        {
            head=null;
            tail=null;
            size--;
        }
        else
        {
            tail=tail.prev;
            tail.next=head;
            size--;
        }
    }

    public void removeAt(int index) throws Exception
    {
        if (size==0)
            System.out.println("LL is empty");
        else if(index<0 || index>size-1)
            System.out.println("Invalid Index");
        else
        {
            if (index==0)
                removeFirst();
            else if (index==size-1)
                removeLast();
            else
            {
                Node nm1 = getNodeAt(index - 1);
                Node np1 = getNodeAt(index + 1);
                nm1.next = np1;
                np1.prev = nm1;
                size--;
            }
        }
    }
}
