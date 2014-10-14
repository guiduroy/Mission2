package Operators;
import Code.FormalExpressionTree;

public class CosinusOperator extends FormalExpressionTree {

	public CosinusOperator() {
		this.setElement("Cos");
	}
	
	public FormalExpressionTree derive () {
		SinusOperator sin = new SinusOperator ();
		sin.setLeft(this.getLeft());
		
		MultiplicationOperator mul = new MultiplicationOperator ();
		mul.setLeft(((FormalExpressionTree)this.getLeft()).derive());
		mul.setRight(sin);
		
		SubtractionOperator res = new SubtractionOperator ();
		res.setLeft(new NumberOperator("0"));
		res.setRight(mul);
		return res;
	}
}