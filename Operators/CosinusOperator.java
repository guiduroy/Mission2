package Operators;
import Lib.FormalExpressionTree;

/**
 * @author Alexander Gerniers
 */

public class CosinusOperator extends FormalExpressionTree {

	public CosinusOperator () {
		super ();
		this.setElement("cos");
	}
	
	public FormalExpressionTree derive () {
		SinusOperator sin = new SinusOperator ();
		sin.setRight(this.getRight());
		
		MultiplicationOperator mul = new MultiplicationOperator ();
		mul.setLeft(((FormalExpressionTree)this.getRight()).derive());
		mul.setRight(sin);
		
		SubtractionOperator res = new SubtractionOperator ();
		res.setLeft(new NumberOperator("0"));
		res.setRight(mul);
		return res;
	}
}
