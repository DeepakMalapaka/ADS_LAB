import java.util.*;
public class Merge_sort
{
    public static void MergeSort(int a[],int low,int high)
    {
        int mid;
        if(low<high)
        {
            mid=(low+high)/2;
            MergeSort(a,low,mid);
            MergeSort(a,mid+1,high);
            Merge(a,low,mid,high);
        }
    }
    public static void Merge(int a[],int low,int mid,int high)
    {
        int []b=new int[a.length];
        int i=low;
        int j=mid+1;
        int k=low;
        while(i<=mid && j<=high)
        {
            if(a[i]<=a[j])
            {
                b[k]=a[i++];
            }
            else
            {
                b[k]=a[j++];
            }
            k++;
        }
        while(i<=mid)
        {
            b[k++]=a[i++];
        }
        while(j<=high)
        {
            b[k++]=a[j++];
        }

        for(i=low;i<=high;i++)
        {

            a[i]=b[i];
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
        MergeSort(a,0,n-1);
        System.out.print("The sorted array is:");
        for(int i=0;i<n;i++)
        {
            System.out.print(a[i]+" ");
        }
    }
}
