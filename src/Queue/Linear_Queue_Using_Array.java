package Queue;

public class Linear_Queue_Using_Array
{
    private int[] queue;
    private int front;
    private int rear;
    private int size;

    Linear_Queue_Using_Array(int size)
    {
        queue = new int[size];
        front=0;
        rear=0;
        size=0;
    }

    public int size()
    {
        return size;
    }

    public boolean isFull()
    {
        return size == queue.length;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public void enQueue(int data) throws Exception
    {
        if (isFull())
            throw new Exception("Queue is Full");

        queue[rear++]=data;
        size++;
    }

    public int deQueue() throws Exception
    {
        if (isEmpty())
            throw new Exception("Queue is Empty");

        int temp = queue[front];
        queue[front]=0;
        front = front+1;
        if(front==queue.length)
        {
            front=0;
            rear=0;
            size=0;
        }
        return temp;
    }

    public int getFront() throws Exception
    {
        if (isEmpty())
            throw new Exception("Queue is Empty");
        return queue[front];
    }

    public int getRear() throws Exception
    {
        if (isEmpty())
            throw new Exception("Queue is Empty");
        return queue[front+size-1];
    }

    public void display()
    {
        for (int i =front; i < rear; i++)
            System.out.print(queue[i] + " ");
        System.out.println();
    }
}
