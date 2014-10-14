
public class SubtractionOperator extends RecursiveBinaryTree {

	public RecursiveBinaryTree derive () {
		SubtractionOperator sub = new SubtractionOperator ();
		sub.setLeft(this.getLeft().derive());
		sub.setRight(this.getRight().derive());
		return sub;
	}
}

