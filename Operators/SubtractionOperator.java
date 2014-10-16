package Operators;
import Lib.FormalExpressionTree;

public class SubtractionOperator extends FormalExpressionTree {

	public SubtractionOperator () {
		super ();
		this.setElement("-");
	}
	
	public FormalExpressionTree derive () {
		SubtractionOperator sub = new SubtractionOperator ();
		sub.setLeft(((FormalExpressionTree)this.getLeft()).derive());
		sub.setRight(((FormalExpressionTree)this.getRight()).derive());
		return sub;
	}
}
