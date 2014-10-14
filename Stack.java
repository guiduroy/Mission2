public interface Stack {
	/**
	 * Remove the top value of the stack
	 * @return the top value of the stack
	 */
	public Node pop();
	
	/**
	 * Add a new Node at the top of the stack
	 * @param s : the new value in the Node at the top of the stack
	 */
	public void push(String s);
	
	/**
	 * Returns the Node at the top of the stack
	 * @return the Node at the top of the stack
	 */
	public Node top();
	
	/**
	 * Returns size of the stack
	 * @return size of the stack
	 */
	public int size();
	
	/**
	 * Returns whether the stack is empty or not
	 * @return true if the stack is empty, otherwise false.
	 */
	public boolean empty();
}
