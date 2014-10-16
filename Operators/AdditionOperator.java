package Operators;
import Lib.FormalExpressionTree;

public class AdditionOperator extends FormalExpressionTree {
	
	public AdditionOperator () {
		super ();
		this.setElement("+");
	}
	
	public FormalExpressionTree derive () {
		AdditionOperator add = new AdditionOperator ();
		add.setLeft(((FormalExpressionTree)this.getLeft()).derive());
		add.setRight(((FormalExpressionTree)this.getRight()).derive());
		return add;
	}
}
