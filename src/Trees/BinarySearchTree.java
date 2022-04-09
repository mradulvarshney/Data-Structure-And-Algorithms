package Trees;

public class BinarySearchTree
{
    private class Node
    {
        int data;
        Node left;
        Node right;
    }

    private Node root;

    BinarySearchTree(){}

    BinarySearchTree(int[] arr)
    {
        root = construct(arr, 0, arr.length-1 );
    }

    private Node construct(int[] arr, int lo, int hi) // this construct method make a balanced bst
    {
        if (lo>hi)
        {
            return null;
        }
        int mid = (lo+hi)/2;

        Node nn = new Node(); // create new node
        nn.data = arr[mid];

        nn.left = construct(arr, lo, mid-1);
        nn.right = construct(arr, mid+1, hi);

        return nn;
    }

    public void add(int item)
    {
        add(root, item);
    }
    private void add(Node node, int item)
    {
        if(node==null)
        {
            Node nn = new Node();
            nn.data = item;
            root = nn;
        }
        else
        {
            if (item>node.data)
            {
                if (node.right==null)
                {
                    Node nn = new Node();
                    nn.data=item;

                    node.right=nn;
                }
                else
                {
                    add(node.right, item);
                }
            }
            else
            {
                if (node.left==null)
                {
                    Node nn = new Node();
                    nn.data=item;

                    node.left=nn;
                }
                else
                {
                    add(node.left, item);
                }
            }
        }
    }

    public void display()
    {
        display(root);
    }
    private void display(Node node)
    {
        if (node==null)
            return;

        String str ="";
        if (node.left==null)
        {
            str+=".";
        }
        else
        {
            str+=node.left.data;
        }
        str+="<-"+ node.data+ "->";
        if (node.right==null)
        {
            str+=".";
        }
        else
        {
            str+=node.right.data;
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
            return 0;

        int ls = size(node.left);
        int rs = size(node.right);

        return ls+rs+1;
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
        if(node==null)
            return false;

        if (node.data==item)
            return true;

        boolean lf = find(node.left, item);
        boolean rf = find(node.right, item);

        return lf||rf;
    }

    public int sumOfAllLeafNodes()
    {
        return sumOfAllLeafNodes(root);
    }
    private int sumOfAllLeafNodes(Node node)
    {
        if(node==null)
        {
            return 0;
        }

        int ls = sumOfAllLeafNodes(node.left);
        int rs = sumOfAllLeafNodes(node.right);

        return ls+rs+node.data;
    }
}
