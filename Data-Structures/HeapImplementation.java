/**
 * Implementation of max heap of ints
 * @author miguel
 *
 */
public class Heap{

	private int[] heap = new int[2];
	private int pos = 1;
	
	/**
	 * Add a value to the heap
	 * @param number
	 */
	public void add(int number){
		int size = heap.length;
		if(pos == size)	resize(size*2);
		
		heap[pos] = number;
		pos++;
		swim(pos-1);
	}
	
	/**
	 * After adding it you swim it up into the correct position
	 * @param i the position where the element starts (last position in the array)
	 */
	private void swim(int i) {
		if(i<=1) return;
		
		int parentPos = i/2;
		if(heap[i] > heap[parentPos]){
			int temp = heap[parentPos];
			heap[parentPos] = heap[i];
			heap[i] = temp;
			swim(parentPos);
		}	
	}

	/**
	 * Remove the biggest element from the heap, and correctly relocate the elements
	 * @return the biggest element
	 */
	public int removeMax(){
		
		int temp = heap[1];
		heap[1] = heap[pos-1];
		heap[pos-1]=0;
		pos--;
		sink(1);
		
		int size = heap.length;
		if(pos < size/4) resize(size/4);
		
		return temp;
	}

	/**
	 * Sink the element to its correct position
	 * @param i is the position of the element in the array
	 */
	private void sink(int i) {
		
		if(2*i>pos)
			return;
			
		int first=heap[2*i];
		int second=heap[2*i+1];
		int next = 0;
		
		if(first > second && heap[i] < first){
			heap[2*i] = heap[i];
			heap[i]= first;
			sink(2*i);
			return;
		}else if(first < second && heap[i] < second){
			heap[2*i+1] = heap[i];
			heap[i]= second;
			sink(2*i+1);
			return;
		}	
	}
	
	public void printHeap(){
		for(int i = 1; i<heap.length; i++)
		System.out.println(heap[i]);
	} 

	/**
	 * Reduce by half when the array is 1/4 full and increase by two when it is full
	 * @param size we increase o decrease to
	 */
	private void resize(int size) {
		
		int[] newHeap = new int [size];
		
		for(int i=0;i<pos; i++)
			newHeap[i] = heap[i];
		heap = newHeap;
	}
	
	//For testing purposes
	public static void main(String args[]){
		Heap h = new Heap();
		h.add(3);
		h.add(5);
		h.add(1);
		h.add(4);
		h.add(6);
		h.add(7);
		h.add(8);
		h.add(2);
		h.add(10);
		
		System.out.println("Before removing max:");
		h.printHeap();
		System.out.println("\nmax:"+h.removeMax());
		System.out.println("\nAfter removing max:");
		h.printHeap();
		System.out.println("\nmax:"+h.removeMax());
		System.out.println("\nAfter removing max:");
		h.printHeap();
		System.out.println("\nmax:"+h.removeMax());
		System.out.println("\nAfter removing max:");
		h.printHeap();
		System.out.println("\nmax:"+h.removeMax());
		System.out.println("\nAfter removing max:");
		h.printHeap();
		System.out.println("\nmax:"+h.removeMax());
		System.out.println("\nAfter removing max:");
		h.printHeap();
		System.out.println("\nmax:"+h.removeMax());
		System.out.println("\nAfter removing max:");
		h.printHeap();
		System.out.println("\nmax:"+h.removeMax());
		System.out.println("\nAfter removing max:");
		h.printHeap();
		
	}
}

