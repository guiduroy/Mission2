package Operators;
import Code.FormalExpressionTree;

public class NumberOperator extends FormalExpressionTree {

	public NumberOperator (String number) {
		super();
		this.setElement(number);
	}
	
	public FormalExpressionTree derive () {
		return new NumberOperator("0");
	}
}