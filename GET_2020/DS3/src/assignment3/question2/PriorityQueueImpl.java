package assignment3.question2;

/**
 * 
 * @author Abhijit
 *
 */
public class PriorityQueueImpl implements PriorityQueue {
	private int size;
	private int[] heap;
	private int maxSize;

	public PriorityQueueImpl(int maxSize) {
		this.maxSize = maxSize;
		this.size = 0;
		this.heap = new int[maxSize + 1];
	}

	
	
	@Override
	public int parent(int current) {
		return current / 2;
	}
	
	@Override
	public void swap(int current, int parent) {
		int temp;
		temp = heap[current];
		heap[current] = heap[parent];
		heap[parent] = temp;
	}

	/**
	 * 
	 * @param bowler
	 *            Insert a bowler into heap
	 */
	@Override
	public void enqueue(int t) {
		if( this.isFull() ) {
			System.out.println("Queue is full.");
			return;
		}
		heap[++size] = t;
		int current = size;
		while (current > 1 && heap[current] > heap[parent(current)]) {
			swap( current, parent(current) );
			current = parent(current);
		}
	}

	/**
	 * Extract a bowler from heap
	 */
	@Override
	public int dequeue() {
		if(this.isEmpty()) {
			System.out.println("Queue is empty");
			return -1;
		}
		int extracted = heap[1];
		heap[1] = heap[size--];
		heapify(1);
		return extracted;
	}

	/**
	 * It Resets the Heap again.
	 * 
	 * @param pos
	 */
	@Override
	public void heapify(int pos) {
		if ( isLeaf(pos) )
			return;
		if (heap[pos] < heap[leftChild(pos)] || heap[pos]  < heap[rightChild(pos)] ) {
			if ( heap[ leftChild(pos) ]  > heap[ rightChild(pos) ] ) {
				swap( pos, leftChild(pos) );
				heapify( leftChild(pos) );
			} else {
				swap( pos, rightChild(pos) );
				heapify( rightChild(pos) );
			}
		}
	}

	/**
	 * 
	 * @param pos
	 * @return Returns right child of a node
	 */
	@Override
	public int rightChild(int pos) {
		return (pos * 2) + 1;
	}

	/**
	 * 
	 * @param pos
	 * @return Returns Left child of a node
	 */
	@Override
	public int leftChild(int pos) {
		return pos * 2;
	}

	/**
	 * 
	 * @param pos
	 * @return If pos node is leaf return True otherwise False
	 */
	@Override
	public boolean isLeaf(int pos) {
		if (pos > size / 2 && (pos <= size || size==0))
			return true;
		return false;
	}

	@Override
	public boolean isMaxFromItsChild(int pos) {
		if ( this.heap[pos]  >= heap[ leftChild(pos) ] && this.heap[pos]  >= heap[ rightChild(pos) ] )
			return true;
		return false;
	}
	
	@Override
	public boolean isFull() {
		if(size == maxSize)
			return true;
		return false;
	}

	@Override
	public boolean isEmpty() {
		if(size == 0)
			return true;
		return false;
	}

	@Override
	public void display() {
		int[] elements = new int[size];
		int ind = 0;
		while(!this.isEmpty()) {
			elements[ind] = this.dequeue();
			System.out.print(elements[ind]+"<-");
			ind += 1;
		}
		for(int element : elements) {
			this.enqueue(element);
		}
	}
}
