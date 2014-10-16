package Lib;

import Operators.AdditionOperator;
import Operators.DivisionOperator;
import Operators.MultiplicationOperator;
import Operators.PowerOperator;
import Operators.SubtractionOperator;
import Operators.SinusOperator;
import Operators.CosinusOperator;
import Operators.VariableOperator;
import Operators.NumberOperator;


public class FormalExpressionTree extends RecursiveBinaryTree<String> {

    public FormalExpressionTree derive () {
    	return null;
    } 
    
    public String toString (){
        /* algorithm : 
         if !(tree.isLeaf()) then print "("
         if tree.hasLeft() then eulerTour(getLeft(tree))
         if !(tree.isLeaf() then print the operator
         else print the value
         if tree.hasRight() then eulerTour(getLeft(tree))
         if !(tree.isLeaf()) then print ")"
         */
    	String expression = "";
        String par1 = "(";
        String par2 = ")";
                
        if (!(this.isLeaf())) { //add an open parenthesis
            expression = expression.concat(par1);
        }
        
        if (this.hasLeft()) { //apply the Euler tour on the left subtree
        	expression = expression.concat(this.getLeft().toString());
        }
       
        expression = expression.concat(this.root());
        
        if (this.hasRight()) { //apply the Euler tour on the right subtree
        	expression = expression.concat(this.getRight().toString());
        }
        
        if (!(this.isLeaf())) { //add a closed parenthesis
            expression = expression.concat(par2);
        }
        
        return expression;
    }

    public static FormalExpressionTree TreeFromString(String st) {
    	
		try {
	        char c;
	        int num, j;
	        NodeStack<FormalExpressionTree> s = new NodeStack<FormalExpressionTree>();
	
	        for(int i=0; i<st.length(); i++){
	        	c = st.charAt(i);
	  
	            if(Character.isDigit(c)){
	                num = Character.getNumericValue(c);
	               
	                for(j=1; (i+j)<st.length() && st.charAt(i+j) >= '0' && st.charAt(i+j) <= '9' ; j++){
	                    num = (10*num) + Character.getNumericValue(st.charAt(i+j));
	                }
	                
	                i = i+j-1;
	               
	                NumberOperator node = new NumberOperator(Integer.toString(num));
	                s.push(node);
	            }
	            
	            else if(c=='+'||c=='-'||c=='*'||c=='/'||c=='^'){
	                if (c=='+') {
	                    AdditionOperator node = new AdditionOperator();
	                    s.push(node);
	                }
	                else if (c=='-') {
	                    SubtractionOperator node = new SubtractionOperator();
	                    s.push(node);
	                }
	                else if (c=='*') {
	                    MultiplicationOperator node = new MultiplicationOperator();
	                    s.push(node);
	                }
	                else if (c=='/') {
	                    DivisionOperator node = new DivisionOperator();
	                    s.push(node);
	                }
	                else if (c=='^') {
	                    PowerOperator node = new PowerOperator();
	                    s.push(node);
	                }
	            }
	
	            else if(c == ' ' || c == '(') { }
	
	            else if(c == ')'){
	            	
	            	FormalExpressionTree t2 = s.pop();
	            	FormalExpressionTree t  = s.pop();
	            	if(t.toString().equals("sin")||t.toString().equals("cos")){
	            		
	            	}else{
	            		FormalExpressionTree t1 = s.pop();
	            		t.setLeft(t1);
	            	}
	            	
	               
	                t.setRight(t2);
	                s.push(t);
	            }
	
	            else {
	                if (c=='s' && st.charAt(i+1)=='i' && st.charAt(i+2)=='n') {
	                    SinusOperator node = new SinusOperator();
	                    s.push(node);
	                    i=i+2;
	                }
	
	                else if (c=='c' && st.charAt(i+1)=='o' && st.charAt(i+2)=='s') {
	                    CosinusOperator node = new CosinusOperator();
	                    s.push(node);
	                    i=i+2;
	                }
	                
	                else {
	                    VariableOperator node = new VariableOperator(Character.toString(c));
	                    s.push(node);   
	                }
	            }
	        }
	
	        while (s.size() > 1)
	        {
	        	FormalExpressionTree t2 = s.pop();
	        	FormalExpressionTree t  = s.pop();
	        	FormalExpressionTree t1 = s.pop();
	            t.setLeft(t2);
	            t.setRight(t1);
	            s.push(t);
	        }
	        return s.pop();
		} 
		catch (EmptyStackException e) {
			System.out.println("Error building tree. Return empty tree.");
			return new FormalExpressionTree();
		}
    }    
}