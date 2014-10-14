package Code;
import Lib.FormalExpressionTree;

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
	
	public TreeInterpretor(){
	}
	
	/**
	 * Euler tour traversal of a binary tree
	 * Returns a String with the fully parenthesized arithmetic expression
	 */
	public void eulerTour (FormalExpressionTree tree){
		/* algorithme : 
		 if !(tree.isLeaf()) then print "("
		 if tree.hasLeft() then eulerTour(getLeft(tree))
		 if !(tree.isLeaf() then print the operator
		 else print the value
		 if tree.hasRight() then eulerTour(getLeft(tree))
		 if !(tree.isLeaf()) then print ")"
		 */
		
		if (!(tree.isLeaf())) { //add an open parenthesis
			expression = expression.concat(par1);
		}
		
		if (tree.hasLeft()) { //apply the Euler tour on the left subtree
			eulerTour((FormalExpressionTree)tree.getLeft());
		}
		
		if (!(tree.isLeaf())) { //add the operator of the root
			expression = expression.concat(printOperator(tree));
		}
		
		else { //add the variable of the leaf
			expression = expression.concat(printVariable(tree));
		}
		
		if (tree.hasRight()) { //apply the Euler tour on the right subtree
			eulerTour((FormalExpressionTree)tree.getRight());
		}
		
		if (!(tree.isLeaf())) { //add a closed parenthesis
			expression = expression.concat(par2);
		}
		
	}
	
	/**
	 * Print an operator
	 */
	public String printOperator (FormalExpressionTree tree){
	    return tree.root();
	}
	
	/**
	 * Print a variable
	 */
	public String printVariable (FormalExpressionTree tree){
		return (tree.root()).toString();
	}
	
	/*
	 * Print the expression
	 */
	public String printExpression (){
		return expression;
	}
	
}