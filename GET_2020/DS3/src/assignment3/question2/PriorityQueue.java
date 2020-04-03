package assignment3.question2;

/**
 * 
 * @author Abhijit
 *
 */
public interface PriorityQueue {
	
	public boolean isFull();
	
	public void enqueue(int t);

	public int dequeue();
	
	public boolean isEmpty();

	public void display();

	int parent(int current);

	void swap(int current, int parent);

	void heapify(int pos);

	int rightChild(int pos);

	int leftChild(int pos);

	boolean isLeaf(int pos);

	boolean isMaxFromItsChild(int pos);
	
}
