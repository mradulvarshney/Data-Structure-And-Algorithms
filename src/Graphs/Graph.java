package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Graph
{
    private class Vertex
    {
        HashMap<String, Integer> neighbour = new HashMap<>();
    }
    HashMap<String, Vertex> vertices;

    public Graph()
    {
        vertices = new HashMap<>();
    }

    public int numVertex()
    {
        return this.vertices.size();
    }

    public boolean containsVertex(String vname)
    {
        return this.vertices.containsKey(vname);
    }

    public void addVertex(String vname)
    {
        Vertex vtx = new Vertex();
        vertices.put(vname, vtx);
    }

    public void removeVertex(String vname)
    {
        Vertex vtx = vertices.get(vname);
        ArrayList<String> keys = new ArrayList<>(vtx.neighbour.keySet());
        for (String key : keys)
        {
            Vertex nbrvtx = vertices.get(key);
            nbrvtx.neighbour.remove(vname);
        }
        vertices.remove(vname);
    }

    public int numEdges()
    {
        int count = 0;
        ArrayList<String> keys = new ArrayList<>(vertices.keySet());
        for (String key : keys)
        {
            Vertex vtx = vertices.get(key);
            count+=vtx.neighbour.size();
        }

        return count/2;
    }

    public boolean containsEdge(String vname1, String vname2)
    {
        Vertex vtx1 = vertices.get(vname1);
        Vertex vtx2 = vertices.get(vname2);

        if(vtx1 == null || vtx2 == null || !vtx1.neighbour.containsKey(vname2))
        {
            return false;
        }
        return true;
    }

    public void addEdge(String vname1, String vname2, int cost)
    {
        Vertex vtx1 = vertices.get(vname1);
        Vertex vtx2 = vertices.get(vname2);

        if(vtx1 == null || vtx2 == null || vtx1.neighbour.containsKey(vname2))
        {
            return;
        }
        vtx1.neighbour.put(vname2, cost);
        vtx2.neighbour.put(vname1, cost);
    }

    public void removeEdge(String vname1, String vname2)
    {
        Vertex vtx1 = vertices.get(vname1);
        Vertex vtx2 = vertices.get(vname2);

        if(vtx1 == null || vtx2 == null || !vtx1.neighbour.containsKey(vname2))
        {
            return;
        }
        vtx1.neighbour.remove(vname2);
        vtx2.neighbour.remove(vname1);
    }

    public boolean hasPath(String vname1, String vname2, HashMap<String, Boolean> processed)
    {
        processed.put(vname1,true);
        if (containsEdge(vname1, vname2))
            return true;
        Vertex vtx = vertices.get(vname1);
        ArrayList<String> keys = new ArrayList<>(vtx.neighbour.keySet());
        for (String key : keys)
        {
            if (!processed.containsKey(key) && hasPath(key, vname2, processed))
            {
                return true;
            }
        }
        return false;
    }

    public void display()
    {
        ArrayList<String> keys = new ArrayList<>(vertices.keySet());
        for (String key : keys)
        {
            Vertex vtx = vertices.get(key);
            System.out.println(key+ ":"+ vtx.neighbour);
        }
    }

    private class Pair
    {
        String vname;
        String path;
    }

    public boolean bfs(String vname1, String vname2)
    {
        HashMap<String, Boolean> processed = new HashMap<>();
        LinkedList<Pair> queue = new LinkedList<>();

        // create a new pair
        Pair pair = new Pair();
        pair.vname = vname1;
        pair.path = vname1;

        // put the pair in a queue
        queue.addLast(pair);

        // while queue is not empty keep doing work
        while (!queue.isEmpty())
        {
            // remove a pair from the queue
            Pair rp = queue.removeFirst();

            if (processed.containsKey(rp.vname))
            {
                continue;
            }

            // put that removed pair in processed
            processed.put(rp.vname, true);

            if (containsEdge(rp.vname, vname2))
            {
                System.out.println(rp.path+vname2);
                return true;
            }

            Vertex vtx = vertices.get(rp.vname);
            ArrayList<String> nbrs = new ArrayList<>(vtx.neighbour.keySet());

            // loop on neighbours
            for (String nbr : nbrs)
            {
                // check in processed
                if (!processed.containsKey(nbr))
                {
                    // make a new pair of nbr and put in queue
                    Pair np = new Pair();
                    np.vname = nbr;
                    np.path = rp.path+ nbr;

                    queue.addLast(np);
                }
            }
        }
        return false;
    }

    public boolean dfs(String vname1, String vname2)
    {
        HashMap<String, Boolean> processed = new HashMap<>();
        LinkedList<Pair> stack = new LinkedList<>();

        // create a new pair
        Pair pair = new Pair();
        pair.vname = vname1;
        pair.path = vname1;

        // put the pair in a queue
        stack.addFirst(pair);

        // while queue is not empty keep doing work
        while (!stack.isEmpty())
        {
            // remove a pair from the queue
            Pair rp = stack.removeFirst();

            if (processed.containsKey(rp.vname))
            {
                continue;
            }

            // put that removed pair in processed
            processed.put(rp.vname, true);

            if (containsEdge(rp.vname, vname2))
            {
                System.out.println(rp.path+vname2);
                return true;
            }

            Vertex vtx = vertices.get(rp.vname);
            ArrayList<String> nbrs = new ArrayList<>(vtx.neighbour.keySet());

            // loop on neighbours
            for (String nbr : nbrs)
            {
                // check in processed
                if (!processed.containsKey(nbr))
                {
                    // make a new pair of nbr and put in queue
                    Pair np = new Pair();
                    np.vname = nbr;
                    np.path = rp.path+ nbr;

                    stack.addFirst(np);
                }
            }
        }
        return false;
    }

    public void bft()
    {
        HashMap<String, Boolean> processed = new HashMap<>();
        LinkedList<Pair> queue = new LinkedList<>();
        ArrayList<String>  keys = new ArrayList<>(vertices.keySet());

        for (String key : keys)
        {
            Pair pair = new Pair();
            pair.vname = key;
            pair.path = key;

            if (processed.containsKey(key))
            {
                continue;
            }

            queue.addLast(pair);
            while (!queue.isEmpty())
            {
                Pair rp = queue.removeFirst();

                if (processed.containsKey(rp.vname))
                {
                    continue;
                }

                processed.put(rp.vname, true);

                System.out.println(rp.vname+ " : "+ rp.path);

                Vertex vtx = vertices.get(rp.vname);
                ArrayList<String> nbrs = new ArrayList<>(vtx.neighbour.keySet());
                for (String nbr : nbrs)
                {
                    Pair np = new Pair();
                    np.vname = nbr;
                    np.path = rp.path+nbr;

                    queue.addLast(np);
                }
            }
        }
    }

    public void dft()
    {
        HashMap<String, Boolean> processed = new HashMap<>();
        LinkedList<Pair> stack = new LinkedList<>();
        ArrayList<String>  keys = new ArrayList<>(vertices.keySet());

        for (String key : keys)
        {
            Pair pair = new Pair();
            pair.vname = key;
            pair.path = key;

            if (processed.containsKey(key))
            {
                continue;
            }

            stack.addFirst(pair);
            while (!stack.isEmpty())
            {
                Pair rp = stack.removeFirst();

                if (processed.containsKey(rp.vname))
                {
                    continue;
                }

                processed.put(rp.vname, true);

                System.out.println(rp.vname+ " : "+ rp.path);

                Vertex vtx = vertices.get(rp.vname);
                ArrayList<String> nbrs = new ArrayList<>(vtx.neighbour.keySet());
                for (String nbr : nbrs)
                {
                    Pair np = new Pair();
                    np.vname = nbr;
                    np.path = rp.path+nbr;

                    stack.addFirst(np);
                }
            }
        }
    }

    public Boolean isCyclic()
    {
        HashMap<String, Boolean> processed = new HashMap<>();
        LinkedList<Pair> queue = new LinkedList<>();
        ArrayList<String>  keys = new ArrayList<>(vertices.keySet());

        for (String key : keys)
        {
            Pair pair = new Pair();
            pair.vname = key;
            pair.path = key;

            if (processed.containsKey(key))
            {
                return true;
            }

            queue.addLast(pair);
            while (!queue.isEmpty())
            {
                Pair rp = queue.removeFirst();

                if (processed.containsKey(rp.vname))
                {
                    return true;
                }

                processed.put(rp.vname, true);

                Vertex vtx = vertices.get(rp.vname);
                ArrayList<String> nbrs = new ArrayList<>(vtx.neighbour.keySet());
                for (String nbr : nbrs)
                {
                    Pair np = new Pair();
                    np.vname = nbr;
                    np.path = rp.path+nbr;

                    queue.addLast(np);
                }
            }
        }
        return false;
    }
}
