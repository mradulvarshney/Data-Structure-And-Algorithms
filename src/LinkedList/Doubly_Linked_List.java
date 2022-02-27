package LinkedList;

public class Doubly_Linked_List
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
        while (temp!=null)
        {
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }

    public void display_from_end()
    {
        Node temp=tail;
        while (temp!=null)
        {
            System.out.print(temp.data+" ");
            temp=temp.prev;
        }
        System.out.println();
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
            head.prev=nn;
            nn.next=head;
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
            tail.next=null;
            size--;
        }
    }

    public void remoevAt(int index) throws Exception
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
