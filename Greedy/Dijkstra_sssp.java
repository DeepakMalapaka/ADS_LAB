import java.util.Scanner;

public class Dijkstra_sssp {
    public static final int INF=9999;
    public static int chooseMinIndex(int dist[],boolean []S,int n)
    {
        int minIndex=-1,min=INF;
        for(int i=0;i<n;i++)
        {
            if(!S[i] && dist[i]<min)
            {
                min=dist[i];
                minIndex=i;
            }
        }
        return minIndex; 
    }
    public static  void ShortestPath(int v,int [][]cost,int []dist,int n)
    {
        boolean []S=new boolean[n];
        for(int i=0;i<n;i++)
            dist[i]=cost[v][i];
        S[v]=true;
        for(int i=1;i<n;i++)
        {
            int u=chooseMinIndex(dist, S, n);
            if(u==-1)
                break;
            S[u]=true;
            for(int j=0;j<n;j++)
            {
                if(!S[j] && dist[u]+cost[u][j]<dist[u])
                    dist[u]=dist[u]+cost[u][j];
            }
        }
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of vertices in the graph:");
        int n=sc.nextInt();
        System.out.println("Enter the "+n+" x "+n+" cost matrix of the graph:");
        int cost[][]=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                cost[i][j]=sc.nextInt();
            }
        }
        int dist[]=new int[n];
        System.out.println("Enter the source for the graph:");
        int v=sc.nextInt();
        ShortestPath(v, cost, dist, n);
        System.out.println("The shortest path using Dijkstra's single source is:");
        for(int i=0;i<n;i++)
        {
            System.out.println("Vertex "+i+" : "+(dist[i]==INF?"INF":dist[i]));
        } 
        sc.close();
    }
}
