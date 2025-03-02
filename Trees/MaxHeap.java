import java.util.*;
public class MaxHeap {
    int []arr;
    int HeapSize,MaxSize;
    MaxHeap(int MaxSize)
    {
        this.MaxSize=MaxSize;
        HeapSize=0;
        arr=new int[MaxSize];
    }
    int parent(int i)
    {
        return (i-1)/2;
    }
    int Lchild(int i)
    {
        return 2*i+1;
    }
    int Rchild(int i)
    {
        return 2*i+2;
    }
    void MaxHeapify(int i)
    {
        int l=Lchild(i);
        int r=Rchild(i);
        int largest=i;
        if(l<HeapSize && arr[l]>arr[largest])
            largest=l;
        if(r<HeapSize && arr[r]>arr[largest])
            largest=r;
        if(largest!=i)
        {
            int temp=arr[largest];
            arr[largest]=arr[i];
            arr[i]=temp;
            MaxHeapify(largest);
        }       
    }
    void removeMax()
    {
        if(HeapSize==0)
            System.out.println("The Heap is empty");
        else if(HeapSize==1)
            HeapSize--;
        else 
        {
            arr[0]=arr[HeapSize-1];
            HeapSize--;
            MaxHeapify(0);
        }
    }
    int getMax()
    {
        return arr[0];
    }
    int curSize()
    {
        return HeapSize;
    }
    void insert(int key)
    {
        if(HeapSize==MaxSize)
        {
            System.out.println("The array is over flowed");
            return;
        }
        int i=HeapSize;
        arr[i]=key;
        HeapSize++;
        while(i!=0 && arr[parent(i)]<arr[i])
        {
            int temp=arr[parent(i)];
            arr[parent(i)]=arr[i];
            arr[i]=temp;
            i=parent(i);
        }
    }
    public static void main(String args[])
    {
        MaxHeap h=new MaxHeap(20);
        int a[]={3, 10, 12, 8, 2, 14};
        for(int x:a)
        {
            h.insert(x);
        }
        System.out.println("The current size of MaxHeap is:"+h.curSize());
        System.out.println("The Maximum of MaxHeap is:"+h.getMax());
        h.removeMax();
        h.insert(15);
        h.insert(18);
        System.out.println("The current size of MaxHeap is:"+h.curSize());
        System.out.println("The Maximum of MaxHeap is:"+h.getMax());
    }
}
