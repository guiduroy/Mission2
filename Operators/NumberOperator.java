package Operators;
import Lib.RecursiveBinaryTree;


public class NumberOperator extends RecursiveBinaryTree {

	public NumberOperator (int number) {
		super ();
		this.setElement((Integer) number);
	}
	
	public RecursiveBinaryTree derive () {
		return new NumberOperator (0);
	}
	
	public String getOperator () {
		return this.root().toString();
	}
}
