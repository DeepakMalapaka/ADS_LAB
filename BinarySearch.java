import java.util.*;
public class BinarySearch {
    public static void BubbleSort(int a[],int n)
    {
        for(int i=0;i<n-1;i++)
        {
            for(int j=0;j<n-i-1;j++)
            {
                if(a[j]>a[j+1])
                {
                    int temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
    }
    public static int Binary_search(int a[],int n,int key)
    {
        int start=0,end=n-1,mid;
        BubbleSort(a, n);
        while(start<=end)
        {
            mid=(start+end)/2;
            if(a[mid]<key)
            {
                start=mid+1;
            }
            if(a[mid]>key)
            {
                end=mid-1;
            }
            if(a[mid]==key)
            {
                return mid;
            }
        }
        return -1;
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
        System.out.println("Enter a key to search in array:");
        int key=sc.nextInt();
        int pos=Binary_search(a, n, key);
        System.out.println("The position of key is found at:"+(pos+1));
    }
}
