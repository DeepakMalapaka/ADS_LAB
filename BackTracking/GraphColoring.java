import java.util.*;
public class GraphColoring
{
    static int adj[][];
    static int []x;
    static int v;
    GraphColoring(int v)
    {
    	this.v=v;
    	adj=new int[v][v];
    	x=new int[v];
  
    }
    public static boolean isSafe(int k,int i)
    {
    	for(int j=0;j<v;j++)
    	{
    		if(adj[k][j]==1 && x[j]==i)
    			return false;
    	}
    	return true;
    }
    public static void coloring(int k,int v)
    {
    	if(k==v)
    	{
    		for(int j=0;j<v;j++)
    			System.out.print(x[j]+" ");
    		System.out.println();
    	}
    	else
    	{
			for(int i=1;i<=v;i++)
			{
				if(isSafe(k,i))
				{
					x[k]=i;
					coloring(k+1,v);
				}
			}	
    	}
    }
    public static void main(String args[])
    {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of vertices in graph:");
		int v=sc.nextInt();
		GraphColoring GC=new GraphColoring(v);
		System.out.println("Enter the "+v+"x"+v+" adjacency matrix:");
		for(int i=0;i<v;i++)
		{
			for(int j=0;j<v;j++)
			{
				GC.adj[i][j]=sc.nextInt();
			}
		}
		coloring(0,v);
		sc.close();
    }
} 
