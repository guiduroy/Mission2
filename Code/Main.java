package Code;
import Lib.FormalExpressionTree;

public class Main {
	
	public static void main(String[] args) {
		if (args.length == 0)
			System.out.println("Il faut entrer une expression analytique en argument.");
		else {
			System.out.println(FormalExpressionTree.TreeFromString(args[0]).derive().toString());
		}
	}
}