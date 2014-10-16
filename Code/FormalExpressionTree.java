 

import Lib.RecursiveBinaryTree;
import Lib.NodeStack;
import Operators.NumberOperator;


public class FormalExpressionTree extends RecursiveBinaryTree<String> {

    protected String par1 = "(";
    protected String par2 = ")";
    protected String expression;

    public FormalExpressionTree(String expression) {
        this.expression = expression;
    }

    public FormalExpressionTree() {
        this.expression = "";
    }
    public FormalExpressionTree derive () {
        return null;
    } 
    
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
            expression = expression.concat(tree.root());
        }
        
        else { //add the variable of the leaf
            expression = expression.concat((tree.root()).toString());
        }
        
        if (tree.hasRight()) { //apply the Euler tour on the right subtree
            eulerTour((FormalExpressionTree)tree.getRight());
        }
        
        if (!(tree.isLeaf())) { //add a closed parenthesis
            expression = expression.concat(par2);
        }
        
    }

    public String toString(FormalExpressionTree tree) {
        expression = "";
        eulerTour(tree);
        return expression;
    }
    
    
    public FormalExpressionTree buildFromString(String st) throws EmptyStackException {
        char c;
        int num, j;
        Stack s = new NodeStack();

        for(int i=0; i<st.length(); i++){
            c = st.charAt(i);
            
            if(Character.isDigit(c)){
                num = Character.getNumericValue(c);
                for(j=1; st.charAt(i+j) >= '0' && st.charAt(i+j) <= '9'; j++){
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
                RecursiveBinaryTree t2 = (RecursiveBinaryTree) s.pop();
                RecursiveBinaryTree t = (RecursiveBinaryTree) s.pop();
                RecursiveBinaryTree t1 = (RecursiveBinaryTree) s.pop();
                t.setLeft(t1);
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
            RecursiveBinaryTree t2 = (RecursiveBinaryTree) s.pop();
            RecursiveBinaryTree t = (RecursiveBinaryTree) s.pop();
            RecursiveBinaryTree t1 = (RecursiveBinaryTree) s.pop();
            t.setLeft(t2);
            t.setRight(t1);
            s.push(t);
        }

        return (FormalExpressionTree) s.pop();
    }    
}