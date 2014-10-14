package Operators;
import Code.FormalExpressionTree;

public class SubtractionOperator extends FormalExpressionTree {

	public FormalExpressionTree derive () {
		SubtractionOperator sub = new SubtractionOperator ();
		sub.setLeft(((FormalExpressionTree)this.getLeft()).derive());
		sub.setRight(((FormalExpressionTree)this.getRight()).derive());
		return sub;
	}
	
	public String getOperator () {
		return "-";
	}
}

