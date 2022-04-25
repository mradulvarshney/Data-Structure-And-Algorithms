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
        int max = max(node.right);
        if (max<node.data)
            max=node.data;
        return max;
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

        if (item>node.data)
            return find(node.right, item);

        return find(node.left, item);
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
    int max = Integer.MIN_VALUE;
    public int maxSubTreeSum()
    {
        return maxSubTreeSum(root);
    }
    private int maxSubTreeSum(Node node)
    {
        if (node == null)
            return 0;
        int ls = maxSubTreeSum(node.left);
        int rs = maxSubTreeSum(node.right);
        if (max<ls+rs+node.data)
            max=ls+rs+node.data;

        return ls+rs+node.data;
    }

    public void remove(int item)
    {
        remove(root, null, false, item);
    }
    private void remove(Node node, Node parent, boolean ilc, int item)
    {
        if(item>node.data)
        {
            remove(node.right, node, false, item);
        }
        else if (item<node.data)
        {
            remove(node.left, node, true, item);
        }
        else
        {
            if (node.left==null && node.right==null)
            {
                if (ilc)
                {
                    parent.left=null;
                }
                else
                {
                    parent.right=null;
                }
            }
            else if (node.left==null && node.right!=null)
            {

            }
        }
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
        System.out.print(node.data+ " ");

        //R
        inOrder(node.right);
    }
}
