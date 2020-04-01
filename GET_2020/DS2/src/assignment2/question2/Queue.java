package assignment2.question2;

public interface Queue<T> {
	
	public boolean isFull();
	
	public void enqueue(T t);

	public T dequeue();
	
	public boolean isEmpty();

	public void display();

}
