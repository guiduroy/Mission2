package Operators;
import Lib.FormalExpressionTree;

/**
 * @author Alexander Gerniers
 */

public class SinusOperator extends FormalExpressionTree {

	public SinusOperator () {
		super ();
		this.setElement("sin");
	}
	
	public FormalExpressionTree derive () {
		CosinusOperator cos = new CosinusOperator ();
		cos.setRight(this.getRight());
		
		MultiplicationOperator res = new MultiplicationOperator ();
		res.setLeft(((FormalExpressionTree)this.getRight()).derive());
		res.setRight(cos);
		return res;
	}
}
