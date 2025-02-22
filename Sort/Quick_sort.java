import java.util.*;
public class Quick_sort
{
	public static void swap(int []a,int i,int j)
	{
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	public static int partition(int a[],int low,int high)
	{
		int pivot=a[low];
		int i=low+1;
		int j=high;
		while(i<j)
		{
			while(a[i]<=pivot && i<=j)
				i=i+1;
			while(a[j]>=pivot && i<=j)
				j=j-1;
			if(i<j)
				swap(a,i,j);
		}
		swap(a,j,low);
		return j;
	}
	public static void QuickSort(int a[],int low,int high)
	{
		if(low<high)
		{
			int j=partition(a,low,high);
			QuickSort(a,low,j-1);
			QuickSort(a,j+1,high);
		}
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
        System.out.print("Enter the value of array size:");
        int n=sc.nextInt();
        int a[]=new int[n];
        System.out.print("Enter the "+n+" elements to the array a:");
        for(int i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
        }
        QuickSort(a,0,n-1);
        System.out.print("The sorted array is:");
        for(int i=0;i<n;i++)
        {
            System.out.print(a[i]+" ");
        }
	}
}
