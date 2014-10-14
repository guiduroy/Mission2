package Operators;
import Code.FormalExpressionTree;

public class PowerOperator extends FormalExpressionTree {
	
	public FormalExpressionTree derive () {
		SubtractionOperator one = new SubtractionOperator ();
		one.setLeft(this.getRight());
		one.setRight(new NumberOperator ("1"));
		
		PowerOperator two = new PowerOperator ();
		two.setLeft(this.getLeft());
		two.setRight(one);
		
		MultiplicationOperator three = new MultiplicationOperator ();
		three.setLeft(this.getRight());
		three.setRight(two);
		
		MultiplicationOperator four = new MultiplicationOperator ();
		four.setLeft(three);
		four.setRight(((FormalExpressionTree)this.getLeft()).derive());
		
		return four;
	}
	
	public String getOperator () {
		return "^";
	}
}
