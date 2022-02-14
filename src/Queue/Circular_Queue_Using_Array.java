package Queue;

public class Circular_Queue_Using_Array
{
    private int[] queue;
    private int front;
    private int rear;
    private int size;

    Circular_Queue_Using_Array(int size)
    {
        queue = new int[size];
        front=0;
        rear=0;
        this.size=0;
    }

    public int size()
    {
        return size;
    }

    public boolean isFull()
    {
        return size() == queue.length;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public void enQueue(int data) throws Exception
    {
        if (isFull())
            throw new Exception("Queue is Full");

        queue[(rear)%queue.length]=data;
        rear++;
        size++;
    }

    public int deQueue() throws Exception
    {
        if (isEmpty())
            throw new Exception("Queue is Empty");

        int temp = queue[front];
        queue[front]=0;
        front = (front+1)%queue.length;
        size--;
        return temp;
    }

    public int getFront()
    {
        System.out.println(front);
        return queue[front%queue.length];
    }

    public int getRear()
    {
        System.out.println(rear);
        return queue[(rear%queue.length)-1];
    }

    public void display()
    {
        for (int i=0; i<size(); i++)
        {
            System.out.print(queue[(front+i)%queue.length]+ " ");
        }
        System.out.println();
    }
}
