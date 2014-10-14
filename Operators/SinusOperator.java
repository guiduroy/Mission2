package Operators;
import Code.FormalExpressionTree;

public class SinusOperator extends FormalExpressionTree {

	public SinusOperator() {
		this.setElement("Sin");
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