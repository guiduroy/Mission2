package Code;
import Lib.FormalExpressionTree;

public class Main {
	
	public static void main(String[] args) {

		FormalExpressionTree tree = FormalExpressionTree.TreeFromString("(x^4+sin((x+(2/x))))");
		
		System.out.println("Tree built from string: " + tree);
		System.out.println("Derived tee: " + tree.derive());		
	}
}