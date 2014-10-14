package Lib;

public class NodeStack<E> implements Stack<E> {
	protected int size;
	protected Node<E> top;
	
	public NodeStack() {
		top = null;
		size = 0;
	}
	
	public E pop() throws EmptyStackException {
		if (isEmpty()) throw new EmptyStackException("Stack is empty.");		
		Node<E> t = top;
		top = t.getNext();
		size--;
		return t.getValue();
	}

	public void push(E o) {
		Node<E> n = new Node<E>(o, top);
		top = n;
		size++;
	}

	public E top() throws EmptyStackException {
		if (isEmpty()) throw new EmptyStackException("Stack is empty.");
		return top.getValue();
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size==0;
	}
	
	class Node<T> {
		private T o;
		private Node<T> next;
		
		public Node(T obj, Node<T> nxt) {
			o=obj;
			next=nxt;
		}
		
		public T getValue() {
			return o;
		}

		public Node<T> getNext() {
			return next;
		}
	}
}
