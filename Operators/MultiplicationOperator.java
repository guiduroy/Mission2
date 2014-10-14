package Operators;
import Code.FormalExpressionTree;

public class MultiplicationOperator extends FormalExpressionTree {

	public MultiplicationOperator () {
		super ();
		this.setElement("*");
	}
	
	public FormalExpressionTree derive () {
		MultiplicationOperator left = new MultiplicationOperator ();
		left.setLeft(((FormalExpressionTree)this.getLeft()).derive());
		left.setRight(this.getRight());
		
		MultiplicationOperator right = new MultiplicationOperator ();
		right.setLeft(this.getLeft());
		right.setRight(((FormalExpressionTree)this.getRight()).derive());
		
		AdditionOperator res = new AdditionOperator ();
		res.setLeft(left);
		res.setRight(right);
		return res;
	}
}
