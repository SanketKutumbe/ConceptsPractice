package Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalTraversal {

    public static void main(String[] args) {


        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        int v = 3, e=2;
        // Write your code here
        int[] in_degree = new int[v+1];
        Arrays.fill(in_degree, 0);

        ArrayList<Integer> result = new ArrayList<Integer>();

        for(int vertex=0; vertex<e; vertex++)
        {
            for(Integer it : edges.get(vertex) )
            {
                in_degree[it]++;
            }
        }

//          for(int i = 0;i<e;i++) {
//                     for(Integer it: edges.get(i)) {
//                         in_degree[it]++;
//                     }
//                 }

        Queue q = new LinkedList<Integer>();

        for(int vertex=0; vertex<=v; vertex++)
            if(in_degree[vertex]==0)
                q.add(in_degree[vertex]);

        Integer head = (Integer) q.peek();

        while(!q.isEmpty())
        {
            head = (Integer) q.peek();
            for(Integer index: edges.get(head))
            {
                if( in_degree[index] > 0 )
                    in_degree[index]--;
                else
                    q.add(index);
            }
            q.remove();
            result.add(head);
        }
        System.out.println(result.size());

    }
}
