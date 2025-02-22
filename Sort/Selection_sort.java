import java.util.*;
public class Selection_sort {
    public static void SelectionSort(int a[],int n)
    {
        for(int i=0;i<n-1;i++)
        {
            int min=i;
            for(int j=i+1;j<n;j++)
            {
                if(a[min]>a[j])
                {
                    min=j;
                }
            }
            if(min!=i)
            {
                int temp=a[min];
                a[min]=a[i];
                a[i]=temp;
            }

        }
        System.out.println("The sorted array using selection sort technique is:");
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
        SelectionSort(a, n);
    }
}
