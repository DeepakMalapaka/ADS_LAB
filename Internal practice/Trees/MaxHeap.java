public class MaxHeap {
    int MaxSize,HeapSize;
    int []arr;
    MaxHeap(int MaxSize)
    {
        this.MaxSize=MaxSize;
        arr=new int[MaxSize];
        HeapSize=0;
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
            System.out.println("The heap is over flowed!");
        int i=HeapSize;
        arr[i]=key;
        HeapSize++;
        while (i!=0 && arr[i]>arr[parent(i)]) {
            int temp=arr[i];
            arr[i]=arr[parent(i)];
            arr[parent(i)]=temp;
            i=parent(i);
        }
    }
    void MaxHeapify(int i)
    {
        int l=Lchild(i);
        int r=Rchild(i);
        int Largest=i;
        if(l<HeapSize && arr[l]>arr[Largest])
            Largest=l;
        if(r<HeapSize && arr[r]>arr[Largest])
            Largest=r;
        if(i!=Largest)
        {
            int temp=arr[i];
            arr[i]=arr[Largest];
            arr[Largest]=temp;
            MaxHeapify(Largest);

        }
    }
    void removeMax()
    {
        if(HeapSize==0)
            System.out.println("The heap is empty!");
        else if(HeapSize==1)
            HeapSize--;
        else 
        {
            arr[0]=arr[HeapSize-1];
            HeapSize--;
            MaxHeapify(0);
        }
    }
    public static void main(String[] args) {
        MaxHeap h=new MaxHeap(20);
        int a[]={3,10,12,8,2,14};
        for(int i:a)
        {
            h.insert(i);
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
