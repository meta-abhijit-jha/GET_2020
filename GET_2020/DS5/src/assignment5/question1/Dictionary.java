package assignment5.question1;

import java.util.ArrayList;
import java.util.List;

public class Dictionary<T> implements BST<T> {

	private Node<T> root;
	private List<Node<T>> inorderList;
	private List<Node<T>> preorderList;
	private List<Node<T>> postorderList;
	private List<Node<T>> subList;
	
	public Dictionary() {
		root = null;
		inorderList     = new ArrayList<Node<T>>();
		preorderList    = new ArrayList<Node<T>>();
		postorderList   = new ArrayList<Node<T>>();
		subList = new ArrayList<Node<T>>();
		
	}
	
	
	public Node<T> getRoot() {
		return root;
	}


	/**
	 * Insert a new key,value pair in the Dictionary.
	 * if key is already present Return False
	 * otherwise add the new pair and Return True
	 */

	@Override
	public boolean insert(int key , T value) {
		Node<T> newNode = new Node<T>(key , value); 
		if(root == null) {
			root = newNode;
			return true;
		}

		Node<T> temp = root;
		while(temp != null) {
			if(newNode.key > temp.key) {
				if(temp.right != null)
					temp = temp.right;
				else{
					temp.right = newNode;
					System.out.println("Inserted in right : "+temp.right.value.toString());
					return true;
				}
			} else if(newNode.key < temp.key){
				if(temp.left != null)
					temp = temp.left;
				else{
					temp.left = newNode;
					System.out.println("Inserted in left : "+temp.left.value.toString());
					return true;
				}
			}
			else
				break;
		}
		System.out.println("Given Key Already Inserted. Same Key can't Be inserted again.");
		return false;
	}

	/**
	 * If given key is present
	 * then return value of this key.
	 */
	@Override
	public Node<T> find(int key) {
		
		Node<T> temp = root;
		while(temp != null) {
			if(key == temp.key)
				return temp; 
			
			else if(temp.key > key )
				temp = temp.left;
			else
				temp = temp.right;
		}
		
		System.out.println("Key Not Found.");
		return null;
	}
	

	/**
	 * Delete the node with given key
	 */
	@Override
	public Node<T> delete(int key) {
		Node<T> deletedNode = find(key);
//		System.out.println(deletedNode.key + " - > "+deletedNode.value.toString());
		if(deletedNode != null) {
			root = deletingNode(root, key);		
			System.out.println("Deleted Node : "+deletedNode.value.toString());
			return deletedNode;
		}
		return null;
	}

	/**
	 * Internally Used by above Delete function
	 */
	@Override
	public Node<T> deletingNode(Node<T> root , int key) {
		
		if(root == null) 
			return root;
		
		if(key < root.key)
			root.left = deletingNode(root.left , key);
		else if(key > root.key )
			root.right = deletingNode(root.right , key);
		else{
			if(root.left == null) 
				return root.right;
			else if(root.right == null)
				return root.left;
			else {
				
				Node<T> preroot = root;
				root = minNode(root.right);
				root.right = deletingNode(preroot.right,root.key);
				root.left = preroot.left;
			}
			
		}
		return root;
	}

	/**
	 * Inorder Traversal
	 * Return List of Nodes
	 */
	
	@Override
	public List<Node<T>> inorder(Node<T> root) {
		if(root != null ) {
			inorder(root.left);
			inorderList.add(root);
//			System.out.println(root.getKey() + ", "+root.getValue().toString());
			inorder(root.right);
		}
		
		return inorderList;
	}

	/**
	 * Preorder Traversal
	 * Retrn List of Nodes
	 */
	@Override
	public List<Node<T>> preorder(Node<T> root) {
		if(root != null) {
			preorderList.add(root);
			preorder(root.left);
			preorder(root.right);
		}
		
		return preorderList;
	}
	
	@Override
	public List<Node<T>> sortedSubList(Node<T> root , int key1 , int key2) {
		if(root != null) {
//			System.out.println(root.key);
			sortedSubList(root.left , key1 , key2);
			if(root.key >= key1 && root.key <= key2 )
				subList.add(root);
			sortedSubList(root.right , key1 , key2);
		}
		
		return subList;
	}

       
	/**
	 * Postorder Traversal
	 * Return List of Nodes
	 */
	@Override
	public List<Node<T>> postorder(Node<T> root) {
		if(root != null) {
			postorder(root.left);
			postorder(root.right);
			postorderList.add(root);	
		}
		
		return postorderList;
	}
	
	/**
	 * 
	 * @param root
	 * @return Return minimum Node 
	 */
	@Override
	public Node<T> minNode(Node<T> root) {
		if(root.left == null) 
			return root;
		return minNode(root.left);
	}
	
	public void clearAll() {
		inorderList.clear();
		preorderList.clear();
		postorderList.clear();
		subList.clear();
	}


	

}
