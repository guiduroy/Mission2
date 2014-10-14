package Operators;
import Code.FormalExpressionTree;

public class AdditionOperator extends FormalExpressionTree {
	
	public AdditionOperator() {
		root = "+";
	}
	
	public FormalExpressionTree derive () {
		AdditionOperator add = new AdditionOperator ();
		add.setLeft(((FormalExpressionTree)this.getLeft()).derive());
		add.setRight(((FormalExpressionTree)this.getLeft()).derive());
		return add;
	}
}