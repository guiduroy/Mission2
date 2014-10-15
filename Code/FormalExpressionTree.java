 

import Lib.RecursiveBinaryTree;
import Lib.NodeStack;
import Operators.NumberOperator;

public class FormalExpressionTree extends RecursiveBinaryTree<String> {

    public FormalExpressionTree derive () {
    	return null;
    } 
    
    public String toString() {
    	return null;
    }
    
    
    public void buildFromString(String st) {
		char c;
		int num;
		Stack s = new Stack();

		for(int i=0; i<st.length; i++){
			c = st.charAt(i);
			
			if(c.isInt()){
				num = (int) c;
				for(int j=1; st.charAt(i+j).isInt(); j++){
					num = (10*num) + (int)(st.charAt(i+j));
					i++;
				}
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
				RecursiveBinaryTree t2 = s.pop();
				RecursiveBinaryTree t = s.pop();
				RecursiveBinaryTree t1 = s.pop();
				t.setLeft(t2);
				t.setRight(t1);
				s.push(t);
			}

			else {
				if (c=='s' && st.charAt(i+1)=='i' && st.charAt(i+2)=='n') {
					SinusOperator node = new SinusOperator();
					node.setElement(num);
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
}