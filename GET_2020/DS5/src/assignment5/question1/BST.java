package assignment5.question1;

import java.util.List;

public interface BST<T> {
	
	public boolean insert(int key , T t);
	public Node<T> delete(int key);
	public Node<T> deletingNode(Node<T> root,int key);
	public List<Node<T>> inorder(Node<T> root);
	public List<Node<T>> preorder(Node<T> root);
	public List<Node<T>> postorder(Node<T> root);
	public Node<T> find(int key);
	public List<Node<T>> sortedSubList(Node<T> root, int key1, int key2);
	public Node<T> minNode(Node<T> root);

}
