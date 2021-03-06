package Stack;

public class Stack_Using_Array
{
    private int[] arr;
    private int tos;

    Stack_Using_Array(int size)
    {
        arr = new int[size];
        tos = 0;
    }

    public int size()
    {
        return tos;
    }

    public boolean isFull()
    {
        return size() == arr.length;
    }

    public boolean isEmpty()
    {
        return size()==0;
    }

    public void push(int data)
    {
        if(isFull())
            System.out.println("Stack is Full");
        else
            arr[tos++]=data;
    }

    public int pop() throws Exception
    {
        if(isEmpty())
            throw new Exception("Stack is Empty");

        int temp = arr[tos-1];
        arr[tos-1] = 0;
        tos--;
        return temp;
    }

    public int peek() throws Exception
    {
        if(isEmpty())
            throw new Exception("Stack is Empty");

        int temp = arr[tos];
        return temp;
    }

     public void display()
     {
         for (int i=tos-1; i>=0; i--)
         {
             System.out.print(arr[i]+ " ");
         }
         System.out.println();
     }
}