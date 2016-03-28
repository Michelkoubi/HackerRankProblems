import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
* Given an undirected graph consisting of N nodes (labelled 1 to N)
* where a specific given node S represents the start position and an edge
* between any two nodes is of length 6 units in the graph.
* It is required to calculate the shortest distance 
* from start position (Node S) to all of the other nodes in the graph.
* Note: If a node is unreachable , the distance is assumed as −1. 
*/
public class ModifiedBFS {
    
    private static class Graph{
        public Node[] nodes;
        
        public Graph(int numNodes)
        {
            nodes= new Node[numNodes];
        }
    }
    
    private static class Node{
        public LinkedList<Integer> children;
        
        public Node(){
            children= new LinkedList();
        }
    }
    
    private static int[] distances;
    private static boolean[] marked;
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numTest=sc.nextInt();
        
        //For the test cases
        for(int j=0;j<numTest;j++){
            
            //create the adjacency list
            int nodes=sc.nextInt();
            Graph graph = new Graph(nodes);
            
            //create array of distances and of the visited nodes
            distances = new int[nodes];
            marked = new boolean[nodes];
            
            //Init the linked lists
            for(int i=0;i<nodes;i++){
                graph.nodes[i]= new Node();
            }
            
            Node[] adj = graph.nodes;

            int edges=sc.nextInt();

            //add the edges
            for(int i=0;i<edges;i++){
                int start=sc.nextInt()-1;
                int end=sc.nextInt()-1;
                
                //it is an undirected graph
                adj[start].children.add(end);
                adj[end].children.add(start);
            }
        
            int startVertex=sc.nextInt()-1;
            
            //To see all the adj list, debugging purposes
            /*for(int i=0;i<adj.length;i++){
                LinkedList<Integer> iterate=adj[i].children;
                Iterator iterator= iterate.listIterator();
                String temp=" ";
                while(iterator.hasNext()){
                    temp+=iterator.next()+" ";
                }
                System.out.println("element"+i+" "+temp);
            }*/
            
            bfs(adj,startVertex);
            
            String answer="";
            for(int i=0;i<distances.length;i++){
                if(distances[i]==0 && i!=startVertex)
                    distances[i]=-1;
                    
                if(distances[i]!=0)
                   answer+=distances[i]+" ";
            }
            System.out.println(answer);
        }
 
    }
    /**
    * Performs a Breadth First Search where all the edges have a value of distance 6
    * @param adj is the adjacency list representing the graph
    * @param startVertex is the vertex where the bfs starts
    */
    public static void bfs(Node[] adj, int startVertex){
        
        LinkedList<Integer> queue= new LinkedList<Integer>();
        int FIX_DISTANCE=6;
        
        //init for the start vertex
        queue.add(startVertex);
        distances[startVertex]=0;
        marked[startVertex]=true;
        
        while(!queue.isEmpty()){
            int node = queue.remove();

            LinkedList<Integer> iterate=adj[node].children;
            Iterator iterator= iterate.listIterator();
            while(iterator.hasNext()){

                int next=(int)iterator.next();

                if(marked[next]!=true){
                    queue.add(next);
                    marked[next]=true;
                    distances[next]=distances[node]+FIX_DISTANCE;
                }
            }
        }
    }
}
