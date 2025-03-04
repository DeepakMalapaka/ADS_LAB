import java.util.*;
public class BFSAdjMatrix {
    int adj[][];
    int v;
    public BFSAdjMatrix(int v)
    {
        this.v=v;
        adj=new int[v][v];
    }
    public void BFS(int start)
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
            for(int i=0;i<v;i++)
            {
                if(!visited[i] && adj[vis][i]==1)
                {
                    q.add(i);
                    visited[i]=true;

                }
            }
        }
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no of vertices:");
        int v=sc.nextInt();
        BFSAdjMatrix graph=new BFSAdjMatrix(v);
        System.out.println("Enter the adjacency matrix:");
        for(int i=0;i<v;i++)
        {
            for(int j=0;j<v;j++)
            {
                int x=sc.nextInt();
                graph.adj[i][j]=x;
            }
        }
        System.out.println("Enter the starting vertex of graph:");
        int start=sc.nextInt();
        graph.BFS(start);
        sc.close();
        System.out.println("This is your graph traversal using the BFS Adjacency Matrix!");
    }
}
