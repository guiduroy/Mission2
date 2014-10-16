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
		testTreeFromString("-4");
		testTreeFromString("(x/12)");
		testTreeFromString("cos(x)");
		testTreeFromString("((10/x)+(2*x))");
		testTreeFromString("(x*(1-sin(x)))");
		testTreeFromString("(x^4+sin((x+(2/x))))");
		testTreeFromString("((x^(-1))/6)");
		testTreeFromString("((x*(sin(((x/10)+x))^3))-cos(x))");
		testTreeFromString("(x+)3+x))");
		testTreeFromString("(y*cos(x))");
		testTreeFromString("(10^(x+20))");
		
		
		testDerive("10", "0");
		testDerive("-4", "0");
		testDerive("sin(x)", "Ecrire derivée attendue ici...");
		testDerive("((10*2)+(4-x))", "Ecrire derivée attendue ici...");
	    testDerive("-4","Ecrire derivée attendue ici...");
	    testDerive("(x/12)","Ecrire derivée attendue ici...");
	    testDerive("cos(x)","Ecrire derivée attendue ici...");
	    testDerive("((10/x)+(2*x))","Ecrire derivée attendue ici...");
	    testDerive("(x*(1-sin(x)))","Ecrire derivée attendue ici...");
	    testDerive("(x^4+sin((x+(2/x))))","Ecrire derivée attendue ici...");
	    testDerive("((x^(-1))/6)","Ecrire derivée attendue ici...");
	    testDerive("((x*(sin(((x/10)+x))^3))-cos(x))","Ecrire derivée attendue ici...");
	    testDerive("(x+)3+x))","Ecrire derivée attendue ici...");
	    testDerive("(y*cos(x))","Ecrire derivée attendue ici...");
	    testDerive("(10^(x+20))","Ecrire derivée attendue ici...");
	}

	public static void testTreeFromString(String string) {
		assertOutput(FormalExpressionTree.TreeFromString(string).toString(), string);
	}	

	public static void testDerive(String originalExpression, String derivedExpression) {
		FormalExpressionTree builtTree = FormalExpressionTree.TreeFromString(originalExpression);
		assertOutput(builtTree.toString(), builtTree.derive().toString());
	}	
}
