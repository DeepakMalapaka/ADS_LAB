import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
public class DFSAdjMatrix {
    int v;
    int adj[][];
    DFSAdjMatrix(int v)
    {
        this.v=v;
        adj=new int[v][v];
        
    }
    public void DFS(int start)
    {
        boolean visited[]=new boolean[v];
        Arrays.fill(visited,false);
        Stack<Integer> s=new Stack<>();
        s.push(start);
        visited[start]=true;
        while (!s.isEmpty()) {
            int vis=s.pop();
            System.out.print(vis+"->");
            for(int i=0;i<v;i++)
            {
                if(!visited[i] && adj[vis][i]==1)
                {
                    s.push(i);
                    visited[i]=true;
                }
            }
        }
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of vertices in the graph:");
        int v=sc.nextInt();
        DFSAdjMatrix graph=new DFSAdjMatrix(v);
        System.out.println("Enter the "+v+"*"+v+" elements adjacency matrix:");
        for(int i=0;i<v;i++)
        {
            for(int j=0;j<v;j++)
            {
                graph.adj[i][j]=sc.nextInt();
            }
        }
        System.out.println("Enter the starting vertex:");
        int start=sc.nextInt();
        graph.DFS(start);
        sc.close();
    }
}
