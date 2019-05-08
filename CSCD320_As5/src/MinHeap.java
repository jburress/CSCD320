import java.util.*;
//MinHeap implementation based upon the MaxHeap given in class and demo code
public class MinHeap<E extends Comparable<? super E>>{
	private E[] Heap;
	private int size;
	private int i;
	
	public MinHeap(E[] H, int num, int max)
	{
		Heap = H;
		i = num;
		size = max;
	}//end of public Constructor
	
	public int getSize()
	{
		return i;
	}//end of getSize

	public boolean isLeaf(int Pos)
	{
		return (Pos >= i/2)&&(Pos < i);
	}//end of isLeaf
	
	public int leftChild(int Pos)
	{
		assert Pos < i/2: "No left child at position";
		return 2*Pos + 1;
	}
	
	public int rightChild(int Pos)
	{
		assert Pos < (i-1)/2: "No right child at position";
		return 2*Pos + 2;
	}
	
	public int Parent(int Pos)
	{
		assert Pos > 0: "No Parent at position";
		return (Pos-1)/2;
	}
	
	public void buildHeap()
	{
		System.out.println("Building Heap...");
		for(int n = i/2-1; n >= 0; n--)
		{
			siftDown(n);
		}
	}//end of buildHeap
	
	private void siftDown(int Pos)
	{
		assert(Pos >= 0) && (Pos < i): " Illegal Heap position";
		while(!isLeaf(Pos))
		{
			int a = leftChild(Pos);
			if(( a<(i-1)) && (Heap[a].compareTo(Heap[a+1]) > 0))
				a++;
			if(Heap[Pos].compareTo(Heap[a]) < 0)
				return;
			Swap(Heap, Pos, a);
			Pos = a;
		}//end of while
	}//end of siftDown
	
	public static <E> void Swap(E[] heap, int pos, int x)
	{
		E temp = heap[pos];
		heap[pos] = heap[x];
		heap[x] = temp;
	}//end swap
	
	public E removeMin()
	{
		assert i > 0: "Removing from an empty Heap";
		Swap(Heap,0, --i);
		if(i != 0)
			siftDown(0);
		//this.size--;
		return Heap[i];
	}//end of removeMin
	
	public static void minHeapSort(MinHeap myHeap)
	{
		ArrayList temp = new ArrayList();
		while(myHeap.getSize() > 0)
		{
			String cur = (String) myHeap.removeMin();
			temp.add(cur);
		}
		System.out.println(temp.toString());
	}//end of minHeapSort
	
	
	
	
	

}
