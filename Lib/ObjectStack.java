package Lib;

public class MyStack implements Stack {
	
	private int size;
	private Node top;

	/**
	* Remove a node from the stack and return it
	* @return - return the node that we juste remove
	* @post Size of the stack and the top of the stack are modified
	*/
	public Object pop() {
		if (size==0) return null;
		else {
			Node t = top;
			top = t.getNext();
			size--;
			return t.getValue();
		}
		
	}

	/**
	* Add a new node at the top of the stack
	* @param - The string which is contain in the node that we add
	* @post size of the stack and the top of the stack are modified
	*/
	public void push(Object o) {
		Node n = new Node(o, top);
		top = n;
		size++;
	}

	/**
	* @return Node at the top of the stack
	*/
	public Node top() {
		return top;
	}

	/**
	* @return Size of the stack
	*/
	public int size() {
		return size;
	}

	/**
	* @return true if the stack is empty, otherwise false
	*/
	public boolean empty() {
		return size==0;
	}

}
