
public class AdditionOperator extends RecursiveBinaryTree {
	
	public RecursiveBinaryTree derive () {
		AdditionOperator add = new AdditionOperator ();
		add.setLeft(this.getLeft().derive());
		add.setRight(this.getRight().derive());
		return add;
	}
	
	public String getOperator () {
		return "+";
	}
}

