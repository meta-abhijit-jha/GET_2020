package assignment5.question1;

public class Node<T> { 
    int key; 
    T value;
    Node<T> left, right; 

    public Node(int key , T value) { 
        this.key = key; 
        this.value = value;
        this.left = this.right = null; 
    }

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public Node<T> getLeft() {
		return left;
	}

	public void setLeft(Node<T> left) {
		this.left = left;
	}

	public Node<T> getRight() {
		return right;
	}

	public void setRight(Node<T> right) {
		this.right = right;
	} 
    
    
} 
