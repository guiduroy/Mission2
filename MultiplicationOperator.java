
public class MultiplicationOperator extends RecursiveBinaryTree {
	
	public RecursiveBinaryTree derive () {
		MultiplicationOperator left = new MultiplicationOperator ();
		left.setLeft(this.getLeft().derive());
		left.setRight(this.getRight());
		
		MultiplicationOperator right = new MultiplicationOperator ();
		right.setLeft(this.getLeft());
		right.setRight(this.getRight().derive());
		
		AdditionOperator res = new AdditionOperator ();
		res.setLeft(left);
		res.setRight(right);
		return res;
	}
	
	public String getOperator () {
		return "*";
	}
}

