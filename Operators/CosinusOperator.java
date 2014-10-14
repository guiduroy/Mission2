package Operators;
import Lib.RecursiveBinaryTree;


public class CosinusOperator extends RecursiveBinaryTree {
	
	public RecursiveBinaryTree derive () {
		SinusOperator sin = new SinusOperator ();
		sin.setLeft(this.getLeft());
		
		MultiplicationOperator mul = new MultiplicationOperator ();
		mul.setLeft(this.getLeft().derive());
		mul.setRight(sin);
		
		SubtractionOperator res = new SubtractionOperator ();
		res.setLeft(new NumberOperator (0));
		res.setRight(mul);
		return res;
	}
	
	public String getOperator () {
		return "cos";
	}
}
