public class MinHeap {
    int MaxSize,HeapSize;
    int arr[];
    MinHeap(int MaxSize)
    {
        this.MaxSize=MaxSize;
        HeapSize=0;
        arr=new int[MaxSize];
    }
    int parent(int i)
    {
        return i-1/2;
    }
    int Lchild(int i)
    {
        return 2*i+1;
    }
    int Rchild(int i)
    {
        return 2*i+2;
    }
    int curSize()
    {
        return HeapSize;
    }
    int getMin()
    {
        return arr[0];
    }
    void insert(int key)
    {
        if(HeapSize==MaxSize)
            System.out.println("The heap is over flowed!");
        int i=HeapSize;
        arr[i]=key;
        HeapSize++;
        while (i!=0 && arr[i]<arr[parent(i)]) {
            int temp=arr[parent(i)];
            arr[parent(i)]=arr[i];
            arr[i]=temp;
            i=parent(i);
        }
    }
    void MinHeapify(int i)
    {
        int l=Lchild(i);
        int r=Rchild(i);
        int Smallest=i;
        if(l<HeapSize && arr[l]<arr[Smallest])
            Smallest=l;
        if(r<HeapSize && arr[r]<arr[Smallest])
            Smallest=r;
        if(i!=Smallest)
        {
            int temp=arr[i];
            arr[i]=arr[Smallest];
            arr[Smallest]=temp;
            MinHeapify(Smallest);
        }
    }
    void removeMin()
    {
        if(HeapSize==0)
            System.out.println("The Heap is empty!");
        else if(HeapSize==1)
            HeapSize--;
        else {
            arr[0]=arr[HeapSize-1];
            HeapSize--;
            MinHeapify(0);
        }
    }
    public static void main(String[] args) {
        MinHeap h=new MinHeap(20);
        int a[]={3,10,12,8,2,14};
        for(int i:a)
        {
            h.insert(i);
        }
        System.out.println("The current size of MaxHeap is:"+h.curSize());
        System.out.println("The Maximum of MaxHeap is:"+h.getMin());
        h.removeMin();
        h.insert(15);
        h.insert(18);
        System.out.println("The current size of MaxHeap is:"+h.curSize());
        System.out.println("The Maximum of MaxHeap is:"+h.getMin());    
    }
}
