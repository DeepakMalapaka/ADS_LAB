import java.util.*;
public class Insertion_sort {
    public static void InsertionSort(int a[],int n)
    {
        int key;
        for(int i=1;i<n;i++)
        {
            key=a[i];
            int j=i-1;
            while(j>=0 && a[j]>key)
            {
                a[j+1]=a[j];
                j--;
            }
            a[j+1]=key;
        }
    }
    public static void display(int a[],int n)
    {
        for(int i=0;i<n;i++)
        {
            System.out.printf("%d ",a[i]);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int n=sc.nextInt();
        System.out.printf("Enter the %d number of elements for array:",n);
        int a[]=new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
        }
        InsertionSort(a, n);
        System.out.println("The sorted array using insertion sort technique is:");
        display(a,n);
    }
}
