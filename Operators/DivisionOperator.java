package Operators;
import Lib.RecursiveBinaryTree;


public class DivisionOperator extends RecursiveBinaryTree {
	
	public RecursiveBinaryTree derive () {
		MultiplicationOperator left = new MultiplicationOperator ();
		left.setLeft(this.getLeft().derive());
		left.setRight(this.getRight());
		
		MultiplicationOperator right = new MultiplicationOperator ();
		right.setLeft(this.getLeft());
		right.setRight(this.getRight().derive());
		
		SubtractionOperator numer = new SubtractionOperator ();
		numer.setLeft(left);
		numer.setRight(right);
		
		PowerOperator denom = new PowerOperator ();
		denom.setLeft(this.getRight());
		denom.setRight(new NumberOperator (2));
		
		DivisionOperator res = new DivisionOperator ();
		res.setLeft(numer);
		res.setRight(denom);
		return res;
	}
	
	public String getOperator () {
		return "/";
	}
}
