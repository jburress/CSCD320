import java.util.*;
public class Tester <E extends Comparable<? super E>>{
	
	public static <E> void main(String[] args)
	{
		Comparable[] A = new Comparable[7];
		A[0] = "zoo";
		A[1] = "big";
		A[2] = "bike";
		A[3] = "good";
		A[4] = "apple";
		A[5] = "moon";
		A[6] = "mud";
		MinHeap myHeap = new MinHeap(A,7,7);
		myHeap.buildHeap();
		myHeap.minHeapSort(myHeap);
		System.out.println("Analysis for Time Complexity is: ");
	}//end of main
}//end of Tester
