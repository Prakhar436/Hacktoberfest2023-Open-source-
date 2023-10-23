import java.util.ArrayList;
import java.util.List;

public class HeapSort {

    public static void heapify(List<Integer> heap){
        int lastNonLeaf = ((heap.size()-1)-1)/2;
        for (int i = lastNonLeaf; i >=0; i--) {
            pushDown(heap, i, heap.size()-1);
        }
    }
    public static void swap(List<Integer> heap, int idx1, int idx2){
        int temp = heap.get(idx1);
        heap.set(idx1, heap.get(idx2));
        heap.set(idx2, temp);
    }
    private static void pushDown(List<Integer> heap, int idx, int n) {
        if(idx==n) return;
        int left = 2*idx + 1;
        int right = 2*idx + 2;
        int smallest = idx;
        if(left<=n && heap.get(left)<heap.get(smallest)) smallest = left;
        if(right<=n && heap.get(right)<heap.get(smallest)) smallest = right;
        if(smallest == idx) return;
        swap(heap,idx,smallest);
        pushDown(heap, smallest,n);
    }
    public static void main(String[] args) {
        List<Integer> heap = new ArrayList<>(); // creating a min heap
        heap.add(50);
        heap.add(560);
        heap.add(0);
        heap.add(90);
        heap.add(9);
        heap.add(67);
        heap.add(80);
        heap.add(60);        
        heap.add(05);
        heap.add(10);
        heap.add(800);
        heap.add(07);

        HeapSort(heap);
        System.out.println(heap);
    }
    private static void HeapSort(List<Integer> heap) {
        heapify(heap);
        System.out.println("heap is"+ heap);
        int n = heap.size()-1;
        for(int i=n;i>0;i--){
            swap(heap, 0,i);
            pushDown(heap,0,i-1);
        }
    }
}

