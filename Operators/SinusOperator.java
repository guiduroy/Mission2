package Operators;
import Lib.FormalExpressionTree;

public class SinusOperator extends FormalExpressionTree {

	public SinusOperator () {
		super ();
		this.setElement("sin");
	}
	
	public FormalExpressionTree derive () {
		CosinusOperator cos = new CosinusOperator ();
		cos.setLeft(this.getLeft());
		
		MultiplicationOperator res = new MultiplicationOperator ();
		res.setLeft(((FormalExpressionTree)this.getLeft()).derive());
		res.setRight(cos);
		return res;
	}
}
