import Lib.RecursiveBinaryTree;
import Lib.Stack;
import Operators.AdditionOperator;
import Operators.DivisionOperator;
import Operators.MultiplicationOperator;
import Operators.PowerOperator;
import Operators.SubtractionOperator;

/**
*Classe ExpressionInterpretor 
*Authors: Christophe Deleval, Guillaume du Roy
*Date : 14/10/2014
*/
public class ExpressionInterpretor() {
	
	public RecursiveBinaryTree<E> Interpretor(string st){

		char c;
		int num;
		char var;
		Stack s = new Stack();

		for(int i=0; i<st.length; i++){
			c = st.charAt(i);
			
			if(c.isInt()){
				num = (int) c;
				for(int j=1; st.charAt(i+j).isInt(); j++){
					num = (10*num) + (int)(st.charAt(i+j));
					i++;
				}
				RecursiveBinaryTree node = new RecursiveBinaryTree();
				node.setElement(num);
			}

			else if(isOperator(c)){
				if (c=='+') {
					AdditionOperator node = new AdditionOperator();
					node.setElement(num);
					s.push(node);
				}
				else if (c=='-') {
					SubtractionOperator node = new SubtractionOperator();
					node.setElement(num);
					s.push(node);
				}
				else if (c=='*') {
					MultiplicationOperator node = new MultiplicationOperator();
					node.setElement(num);
					s.push(node);
				}
				else if (c=='/') {
					DivisionOperator node = new DivisionOperator();
					node.setElement(num);
					s.push(node);
				}
				else if (c=='^') {
					PowerOperator node = new PowerOperator();
					node.setElement(num);
					s.push(node);
				}
			}

			else if(c == ' ' || c == '(') { }

			else if(c == ')'){
				RecursiveBinaryTree t2 = s.pop();
				RecursiveBinaryTree t = s.pop();
				RecursiveBinaryTree t1 = s.pop();
				t.setLeft(t2);
				t.setRight(t1);
				s.push(t);
			}

			else {
				var = c;
				RecursiveBinaryTree node = new RecursiveBinaryTree();
				node.setElement(var);
				current.setRight(node);
			}
		}

		while (s.size > 1)
		{
			RecursiveBinaryTree t2 = s.pop();
			RecursiveBinaryTree t = s.pop();
			RecursiveBinaryTree t1 = s.pop();
			t.setLeft(t2);
			t.setRight(t1);
			s.push(t);
		}

		return s.pop();
	}

	public boolean isOperator(char c){
		return(c=='+'||c=='-'||c=='*'||c=='/'||c=='^');
	}
	
	public boolean 		

	

}