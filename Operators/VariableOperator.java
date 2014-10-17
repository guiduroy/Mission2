package Operators;
import Lib.FormalExpressionTree;

/**
 * @author Alexander Gerniers
 */

public class VariableOperator extends FormalExpressionTree {
	
	public VariableOperator (String variable) {
		super();
		this.setElement(variable);
	}
	
	public FormalExpressionTree derive () {
		return new NumberOperator("1");
	}
}
