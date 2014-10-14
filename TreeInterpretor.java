/**
 * Classe TreeInterpretor transforming a binary tree in a parenthesized expression using the Eurle tour
 * Author : Anne-Sophie Branders
 * Date 14/10/2014
 * Version 1
 */

public class TreeInterpretor {
	
	protected String par1 = "(";
	protected String par2 = ")";
	protected String expression = "";
	/**
	 * Euler tour traversal of a binary tree
	 * Returns a String with the fully parenthesized arithmetic expression
	 */
	public void eulerTour (RecursiveBinaryTree tree){
		/* algorithme : 
		 if !(tree.isLeaf()) then print "("
		 if tree.hasLeft() then eulerTour(getLeft(tree))
		 if !(tree.isLeaf() then print the operator
		 else print the value
		 if tree.hasRight() then eulerTour(getLeft(tree))
		 if !(tree.isLeaf()) then print ")"
		 */
		
		if !(tree.isLeaf()) { //
			expression = expression.concat(par1);
		}
		
		if (tree.hasLeft()) {
			eulerTour(getLeft(tree));
		}
		
		if !(tree.isLeaf()) {
			expression = expression.concat(printOperator(tree));
		}
		
		else {
			expression = expression.concat(printVariable);
		}
		
		if (tree.hasRight()) {
			eulerTour(getLeft(tree));
		}
		
		if !(tree.isLeaf()) {
			expression = expression.concat(par2);
		}
		
	}
	
	/**
	 * Print an operator
	 */
	public String printOperator (RecursiveBinaryTree tree){
		return tree.root().getOperator();
	}
	
	/**
	 * Print an variable
	 */
	public String printVariable (RecursiveBinaryTree tree){
		return tree.root().getVariable();
	}
	
	/*
	 * Print the expression
	 */
	public String printExpression (){
		return expression;
	}
	
}