package Tests;
import Lib.FormalExpressionTree;

/**
 * Author : Gregory Vander Schueren
 * Date : 16/10/2014
 */

public class FormalExpressionTreeTests extends Tests {
	// Les cas en commentaire sont les cas qui ne fonctionne pas encore
	public static void main(String[] args) {
		testTreeFromString("10"); 
		testTreeFromString("(10+x)");
		testTreeFromString("sin(x)");
		testTreeFromString("((10*2)+(4-x))");
		testTreeFromString("(10*(x+sin(x)))");
		testTreeFromString("(x+cos((x+2)))");
		testTreeFromString("((x^3)/5)");
		System.out.println("----------------------------------");
		testDerive("10", "0");
		testDerive("(0-4)", "(0-0)");
		testDerive("sin(x)","(1*cos(x))");
		testDerive("((10*2)+(4-x))", "(((0*2)+(10*0))+(0-1))");
	    testDerive("(x/12)","(((1*12)-(x*0))/(12^2))");
	    testDerive("cos(x)","(0-(1*sin(x)))");
	    testDerive("((10/x)+(2*x))","((((0*x)-(10*1))/(x^2))+((0*x)+(2*1)))");
	    testDerive("(x*(1-sin(x)))","((1*(1-sin(x)))+(x*(0-(1*cos(x)))))");
//	    testDerive("(x^4+sin((x+(2/x))))","Ecrire derivée attendue ici...");
//	    testDerive("((x^(-1))/6)","Ecrire derivée attendue ici...");
//	    testDerive("((x*(sin(((x/10)+x))^3))-cos(x))","Ecrire derivée attendue ici...");
//	    testDerive("(x+)3+x))","Ecrire derivée attendue ici...");
//	    testDerive("(y*cos(x))","Ecrire derivée attendue ici...");
//	    testDerive("(10^(x+20))","Ecrire derivée attendue ici...");
	}

	public static void testTreeFromString(String string) {
		assertOutput(FormalExpressionTree.TreeFromString(string).toString(), string);
	}	

	public static void testDerive(String originalExpression, String derivedExpression) {
		FormalExpressionTree builtTree = FormalExpressionTree.TreeFromString(originalExpression);
		assertOutput(derivedExpression, builtTree.derive().toString());
	}	
}