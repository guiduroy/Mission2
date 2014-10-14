package Operators;
import Code.FormalExpressionTree;

public class DivisionOperator extends FormalExpressionTree {

	public DivisionOperator () {
		super ();
		this.setElement("/");
	}
	
	public FormalExpressionTree derive () {
		MultiplicationOperator left = new MultiplicationOperator ();
		left.setLeft(((FormalExpressionTree)this.getLeft()).derive());
		left.setRight(this.getRight());
		
		MultiplicationOperator right = new MultiplicationOperator ();
		right.setLeft(this.getLeft());
		right.setRight(((FormalExpressionTree)this.getRight()).derive());
		
		SubtractionOperator numer = new SubtractionOperator ();
		numer.setLeft(left);
		numer.setRight(right);
		
		PowerOperator denom = new PowerOperator ();
		denom.setLeft(this.getRight());
		denom.setRight(new NumberOperator("2"));
		
		DivisionOperator res = new DivisionOperator ();
		res.setLeft(numer);
		res.setRight(denom);
		return res;
	}
}
