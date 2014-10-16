package Tests;
import Lib.FormalExpressionTree;

/**
 * Author : Gregory Vander Schueren
 * Date : 16/10/2014
 */

public class FormalExpressionTreeTests extends Tests {
	
	public static void main(String[] args) {
		testTreeFromString("10");
		testTreeFromString("(10+x)");
		testTreeFromString("sin(x)");
		testTreeFromString("((10*2)+(4-x))");
		testTreeFromString("(10*(x+sin(x)))");
		testTreeFromString("(x+cos((x+2)))");
		testTreeFromString("((x^3)/5)");
		
		testDerive("10", "0");
		testDerive("(10+x)", "0+1");
		testDerive("sin(x)", "1+cos(x)");
		testDerive("((10*2)+(4-x))", "....");
    }

	public static void testTreeFromString(String string) {
		assertOutput(FormalExpressionTree.TreeFromString(string).toString(), string);
	}	

	public static void testDerive(String originalExpression, String derivedExpression) {
		FormalExpressionTree builtTree = FormalExpressionTree.TreeFromString(originalExpression);
		assertOutput(builtTree.toString(), builtTree.derive().toString());
	}	
}