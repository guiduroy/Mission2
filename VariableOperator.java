
public class VariableOperator extends RecursiveBinaryTree {
	
	public VariableOperator (String variable) {
		super ();
		this.setElement(variable);
	}
	
	public RecursiveBinaryTree derive () {
		return new NumberOperator (1);
	}
	
	public String getOperator () {
		return this.root().toString();
	}
}
