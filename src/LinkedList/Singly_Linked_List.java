package LinkedList;

public class Singly_Linked_List
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
    public void addLast(int data)
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

    public void addFirst(int data)
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

    public void addAt(int data, int index) throws Exception
    {
        if(index<0 || index>this.size)
          throw new IndexOutOfBoundsException("Invalid Index");

        if(index==0)
            addFirst(data);
        else if(index==this.size)
            addLast(data);
        else
        {
            Node nm1 = getNodeAt(index-1);
            Node n = new Node();
            n.data = data;
            n.next = null;
            Node np1 = getNodeAt(index);
            nm1.next = n;
            n.next = np1;
            this.size++;
        }
    }

    public int size()
    {
        return this.size;
    }

    public int getAt(int index) throws Exception
    {
        if(this.size==0)
            throw new Exception("LL is empty");
        if(index<0 || index>this.size-1)
            throw new IndexOutOfBoundsException("Invalid Index");
        Node tmp=head;
        for (int i=0; i<index; i++)
        {
            tmp=tmp.next;
        }
        return tmp.data;
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

    public void removeFirst() throws Exception
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

    public void removeLast() throws Exception
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

    public void removeAt(int index) throws Exception
    {
        if(this.size==0)
            throw new Exception("LL is empty");
        if(index<0 || index>this.size-1)
            throw new IndexOutOfBoundsException("Invalid Index");
        if(index==0)
            removeFirst();
        else if(index==this.size-1)
            removeLast();
        else
        {
            Node nm1 = getNodeAt(index-1);
            Node n = getNodeAt(index);
            nm1.next=n.next;
            this.size--;
        }
    }

    public void sort() throws Exception
    {
        if(this.size==0)
            throw new Exception("LL is empty.");
        Node temp = this.head;
        while(temp!=null)
        {
            Node temp1 = temp.next;
            while(temp1!=null)
            {
                if(temp.data>temp1.data)
                {
                    int n = temp.data;
                    temp.data = temp1.data;
                    temp1.data=n;
                }
                temp1=temp1.next;
            }
            temp=temp.next;
        }
    }

    public void reverseData() throws Exception
    {
        int left = 0;
        int right = this.size-1;
        while (left<right)
        {
            Node ln = getNodeAt(left);
            Node rn = getNodeAt(right);

            int tmp = ln.data;
            ln.data = rn.data;
            rn.data = tmp;

            left++;
            right--;
        }
    }

    public int mid()
    {
        Node slow = this.head;
        Node fast = this.head;
        while(fast.next!=null && fast.next.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }
}
