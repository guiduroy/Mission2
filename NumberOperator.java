
public class NumberOperator extends RecursiveBinaryTree {

	public NumberOperator (int number) {
		super ();
		this.setElement((Integer) number);
	}
	
	public RecursiveBinaryTree derive () {
		return this;
	}
	
	public String getOperator () {
		return this.root().toString();
	}
}
