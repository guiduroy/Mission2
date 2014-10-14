package Operators;
import Code.FormalExpressionTree;

public class AdditionOperator extends FormalExpressionTree {
	
	public FormalExpressionTree derive () {
		AdditionOperator add = new AdditionOperator ();
		add.setLeft(((FormalExpressionTree)this.getLeft()).derive());
		add.setRight(((FormalExpressionTree)this.getLeft()).derive());
		return add;
	}
	
	public String getOperator () {
		return "+";
	}
}

