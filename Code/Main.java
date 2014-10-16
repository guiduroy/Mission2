package Code;
import Lib.FormalExpressionTree;

public class Main {
	
	public static void main(String[] args) {

		FormalExpressionTree testTree = FormalExpressionTree.TreeFromString("((10*2)+(4-x))");
		System.out.println(testTree);		
	}
}