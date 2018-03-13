package sort;

/**
 * @author CoderGang
 * 堆排序的实现
 */
public class HeapSort {

    /**
     * 根据数组对象构造最大堆
     * @param arry，数组对象
     */
    private void buildMaxHeap(int[] arry ){
        for(int i= (arry.length>>1)-1;i>=0;i--){
            //updateMaxHeapRecursive(arry,i,arry.length);
            updateMaxHeapLoop(arry,i,arry.length);
        }
    }
    /**
     * 更新堆的状态，非递归版本
     * @param heap 堆
     * @param parent 父亲结点
     * @param heapSize 堆的大小
     */
    private void updateMaxHeapLoop(int[] heap,int parent,int heapSize){
        int right = (parent << 1) + 2;
        int left = (parent << 1) + 1;
        int largest;

        while (true){
            if (left<heapSize && heap[left] > heap[parent]) {
                largest = left;
            } else {
                largest = parent;
            }

            if (right<heapSize && heap[right] > heap[largest]) {
                largest = right;
            }
            if (largest != parent) {
                int tmp = heap[largest];
                heap[largest] = heap[parent];
                heap[parent] = tmp;
            }else {
                break;
            }
            right=(largest<<1)+2;
            left=(largest<<1)+1;
            parent=largest;
            if(right>=heapSize && left>=heapSize) {
                break;
            }

        }
    }

    /**
     * 更新堆的状态，递归版本
     * @param heap 堆
     * @param parent 父亲结点
     * @param heapSize 堆的大小
     */
    private void updateMaxHeapRecursive(int[] heap,int parent,int heapSize) {
        int right = (parent << 1) + 2;
        int left = (parent << 1) + 1;
        int largest;

        if (left<heapSize && heap[left] > heap[parent]) {
            largest = left;
        } else {
            largest = parent;
        }

        if (right<heapSize && heap[right] > heap[largest]) {
            largest = right;
        }
        if (largest != parent) {
            int tmp = heap[largest];
            heap[largest] = heap[parent];
            heap[parent] = tmp;
            //updateMaxHeapRecursive(heap, largest,heapSize);
            updateMaxHeapRecursive(heap, largest,heapSize);
        }
    }

    /**
     * 对数组进行排序
     * @param arry，要排序的数组
     */
    public void sort(int[] arry) {
        buildMaxHeap(arry);
        int heapSize=arry.length;
        for(int i=arry.length-1;i>0;i--){
            int tmp=arry[i];
            arry[i]=arry[0];
            arry[0]=tmp;
            heapSize--;
            //updateMaxHeapRecursive(arry,0,heapSize);
            updateMaxHeapLoop(arry, 0,heapSize);
        }
        for (int i:arry) {
            System.out.print(i+" ");
        }
    }

    public static void main(String [] args) {
       int []a=/*{1,2,3,4,5};*/{1,5,8,3,4,14,9,86,54,1654,15,45,6,13,45,16,4,78,9,1,3,4,8,4,64,748915};
       new HeapSort().sort(a);
    }

}
