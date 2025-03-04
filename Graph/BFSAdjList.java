import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BFSAdjList {
    int v;
    LinkedList<Integer> adj[];
    public BFSAdjList(int v)
    {
        this.v=v;
        adj=new LinkedList[v];
        for(int i=0;i<v;i++)
            adj[i]=new LinkedList<>();
    }
    public void AddEdge(int src,int dest)
    {
        adj[src].add(dest);
        adj[dest].add(src);
    }
    public void  BFS(int start)
    {
        boolean visited[]=new boolean[v];
        Arrays.fill(visited,false);
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        visited[start]=true;
        while(!q.isEmpty())
        {
            int vis=q.poll();
            System.out.print(vis+"->");
            for(int neighbour:adj[vis])
            {
                if(!visited[neighbour])
                {
                    q.add(neighbour);
                    visited[neighbour]=true;
                }

            }
        }
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Number of vertices present in the Graph:");
        int v=sc.nextInt();
        BFSAdjList graph=new BFSAdjList(v);
        System.out.println("Enter the number of edges to be added:");
        int e=sc.nextInt();
        System.out.println("Enter the source and destination for "+e+" number of edges:");
        for(int i=0;i<e;i++)
        {
            int src=sc.nextInt();
            int dest=sc.nextInt();
            graph.AddEdge(src, dest);
        }
        System.out.println("Enter the starting vertex:");
        int start=sc.nextInt();
        graph.BFS(start);
        sc.close();
        System.out.println("This is your graph traversal using the BFS Adjacency List!");
    }
}
