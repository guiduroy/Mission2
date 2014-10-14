
public class SinusOperator extends RecursiveBinaryTree {
	
	public RecursiveBinaryTree derive () {
		CosinusOperator cos = new CosinusOperator ();
		cos.setLeft(this.getLeft());
		
		MultiplicationOperator res = new MultiplicationOperator ();
		res.setLeft(this.getLeft().derive());
		res.setRight(cos);
		return res;
	}
	
	public String getOperator () {
		return "sin";
	}
}
