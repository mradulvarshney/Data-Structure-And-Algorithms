package Trees;

import java.util.*;

public class GenericTree
{
    Scanner sc = new Scanner(System.in);
    private class Node
    {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }
    private Node root;
    private int size;

    public GenericTree()
    {
       root = insert(null, 0);
    }

    private Node insert(Node parent, int ith)
    {
        if (parent==null)
        {
            System.out.println("Enter the data for root node");
        }
        else
        {
            System.out.println("Enter the data for "+ ith+ "th child node of "+ parent.data);
        }

        int item = sc.nextInt();
        Node nn = new Node();
        this.size++;
        nn.data = item;

        System.out.println("Enter no. of children for "+ nn.data);
        int noc = sc.nextInt();

        for (int i=0; i<noc; i++)
        {
            Node child = insert(nn, i);
            nn.children.add(child);
        }

        return nn;
    }

    public void display()
    {
        display(root);
    }

    private void display(Node node)
    {
        String str = node.data + "->";

        for (Node child : node.children)
        {
            str += child.data + " ";
        }
        str += ".";
        System.out.println(str);

        for (Node child : node.children)
        {
            display(child);
        }
    }

    public int size()
    {
        return this.size;
    }

    public boolean find(int data)
    {
        boolean res = find(root, data);
        return res;
    }

    private boolean find(Node node, int item)
    {
        if (node.data==item)
        {
            return true;
        }

        for (Node child : node.children)
        {
            if(find(child, item))
                return true;
        }

        return false;
    }

    public int max()
    {
        return max(root);
    }

    private int max(Node node)
    {
        int tm = node.data;
        for (Node child : node.children)
        {
            int cm = max(child);
            if (cm>tm)
                tm=cm;
        }
        return tm;
    }

    public int height()
    {
        return height(root);
    }

    private int height(Node node)
    {
        int th = -1;
        for (Node child : node.children)
        {
            int ch = height(child);
            if (ch>th)
                th=ch;
        }
        return th+1;
    }
}
