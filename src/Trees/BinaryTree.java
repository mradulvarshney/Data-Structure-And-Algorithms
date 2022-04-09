package Trees;

import java.util.Scanner;

public class BinaryTree
{
    Scanner sc = new Scanner(System.in);

    private class Node
    {
        int data;
        Node left;
        Node right;
    }
    private Node root;

    public BinaryTree()
    {
        root = insert(null, false);
    }
    private Node insert(Node parent, boolean ilc) // ilc = is left child
    {
        if (parent==null)
        {
            System.out.println("Enter the data for the root node:");
        }
        else
        {
            if (ilc)
            {
                System.out.println("Enter the data for left child of "+ parent.data);
            }
            else
            {
                System.out.println("Enter the data for right child of "+ parent.data);
            }
        }

        int item = sc.nextInt();
        Node nn = new Node();
        nn.data=item;

        System.out.println(nn.data+ " has left child ?");
        boolean hlc = sc.nextBoolean(); // has left child
        if (hlc)
        {
            nn.left = insert(nn, true);
        }
        System.out.println(nn.data+ " has right child ?");
        boolean hrc = sc.nextBoolean(); // has right child
        if (hrc)
        {
            nn.right = insert(nn, false);
        }

        return nn;
    }

    public void display()
    {
        display(root);
    }
    private void display(Node node)
    {
        if (node == null)
        {
            return;
        }

        String str = "";
        if (node.left == null)
        {
            str += ".";
        }
        else
        {
            str += node.left.data;
        }
        str += "<-"+ node.data+ "->";
        if (node.right==null)
        {
            str += ".";
        }
        else
        {
            str += node.right.data;
        }
        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    public int size()
    {
        return size(root);
    }
    private int size(Node node)
    {
        if (node==null)
        {
            return 0;
        }
        int ts = 0;
        int ls = size(node.left);
        ts+=ls;
        int rs = size(node.right);
        ts+=rs;

        return ts+1;
    }

    public int max()
    {
        return max(root);
    }
    private int max(Node node)
    {
        if (node == null)
        {
            return 0;
        }
        int tm = node.data; // total max
        int lm = max(node.left); // left max
        if (lm>tm)
            tm=lm;
        int rm = max(node.right); // right max
        if (rm>tm)
            tm=rm;
        return tm;
    }

    public boolean find(int item)
    {
        return find(root, item);
    }
    private boolean find(Node node, int item)
    {
        if (node == null)
        {
            return false;
        }
        if(node.data == item)
        {
            return true;
        }
        boolean lf = find(node.left, item); // left find
        if (lf)
            return true;
        boolean rf = find(node.right, item); // right find
        if (rf)
            return true;
        return false;
    }

    /*
        NLR = preOrder
        LRN = postOrder
        LNR = inOrder

        NRL = reverse postOrder
        RLN = reverse preOrder
        RNL = reverse inOrder
    */

    public void preOrder() // NLR
    {
        preOrder(root);
    }
    private void preOrder(Node node)
    {
        if (node == null)
        {
            return;
        }
        // N
        System.out.println(node.data);

        //L
        preOrder(node.left);

        //R
        preOrder(node.right);
    }

    public void postOrder() // LRN
    {
        postOrder(root);
    }
    private void postOrder(Node node)
    {
        if (node == null)
        {
            return;
        }
        //L
        postOrder(node.left);

        //R
        postOrder(node.right);

        // N
        System.out.println(node.data);
    }

    public void inOrder() // LNR
    {
        inOrder(root);
    }
    private void inOrder(Node node)
    {
        if (node == null)
        {
            return;
        }
        //L
        inOrder(node.left);

        // N
        System.out.println(node.data);

        //R
        inOrder(node.right);
    }
    int max = Integer.MIN_VALUE;
    public int maxSubTreeSum()
    {
        maxSubTreeSum(root);
        return max;
    }
    private int maxSubTreeSum(Node node)
    {
        if (node == null)
            return 0;
        int ls = maxSubTreeSum(node.left);
        int rs = maxSubTreeSum(node.right);
        if (max<ls+rs+ node.data)
            max = ls + rs + node.data;
        return ls+ rs+ node.data;
    }
}
