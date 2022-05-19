package Problems;

import java.util.*;

class Node
{
    int first;
    int previous;
    Node(){}
    Node(int first, int previous)
    {
        this.first = first;
        this.previous = previous;
    }
}

public class CycleDetection {


    static boolean checkCycle(ArrayList<ArrayList<Integer>> adjList, boolean[] visited, int start, int parent)
    {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start, parent));
        visited[start] = true;

        while( !q.isEmpty() )
        {
            start = q.peek().first;
            parent = q.peek().previous;
            q.remove();
            for( Integer temp: adjList.get(start)  )
            {
                if( !visited[temp] ) // check whether it is end node or not
                {
                    visited[temp] = true;
                    q.add(new Node(temp, start));
                }
                else if( temp != parent )
                {
                    return true;
                }
            }
        }

        return false;
    }

    public static String cycleDetection(int[][] edges, int n, int m)
    {
        // Write your code here.
        boolean[] visited = new boolean[n+1];
        Arrays.fill(visited, false);

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>(n);

        for (int i = 0; i < n ; i++) {
            adjList.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < m ; i++)
        {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }

        // visited[], adjList

        for(int i=0; i<n; i++)
        {
            if( !visited[i] )
            {
                visited[i] = true;
                if (checkCycle(adjList, visited, i, -1))
                    return "Yes";
            }
        }

        return "No";
    }


}
