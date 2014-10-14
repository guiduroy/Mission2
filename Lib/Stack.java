package Lib;

class EmptyStackException extends Exception {
	private static final long serialVersionUID = 1L;

	public EmptyStackException(String message) {
        super(message);
    }
}

public interface Stack<E> {
	/**
	 * Remove the top value of the stack
	 * @return the top value of the stack
	 */
	public E pop() throws EmptyStackException;

	/**
	 * Add a new Node at the top of the stack
	 * @param s : the new value in the Node at the top of the stack
	 */
	public void push(E n);
	
	/**
	 * Returns the Node at the top of the stack
	 * @return the Node at the top of the stack
	 */
	public E top() throws EmptyStackException;
	
	/**
	 * Returns size of the stack
	 * @return size of the stack
	 */
	public int size();
	
	/**
	 * Returns whether the stack is empty or not
	 * @return true if the stack is empty, otherwise false.
	 */
	public boolean isEmpty();
}