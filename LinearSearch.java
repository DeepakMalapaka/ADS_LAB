import java.util.Scanner;

public class LinearSearch {
    public static int Linear_search(int a[],int n,int key)
    {
        for(int i=0;i<n;i++)
        {
            if(key==a[i])
            {
                return i;
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
        int pos=Linear_search(a, n, key);
        System.out.println("The position of key is found at:"+(pos+1));
    }
}
