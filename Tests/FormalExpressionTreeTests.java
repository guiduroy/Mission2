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
		System.out.println("----------------------------------");
		testDerive("10", "0");
		testDerive("(0-4)", "(0-0)");
		testDerive("sin(x)","(1*cos(x))");
		testDerive("((10*2)+(4-x))", "(((0*2)+(10*0))+(0-1))");
	    testDerive("(x/12)","(((1*12)-(x*0))/(12^2))");
	    testDerive("cos(x)","(0-(1*sin(x)))");
	    testDerive("((10/x)+(2*x))","((((0*x)-(10*1))/(x^2))+((0*x)+(2*1)))");
	    testDerive("(x*(1-sin(x)))","((1*(1-sin(x)))+(x*(0-(1*cos(x)))))");
	    testDerive("(x^4+sin((x+(2/x))))","((x*((4+sin((x+(2/x))))^(x-1)))*(0+((1+(((0*x)-(2*1))/(x^2)))*cos((x+(2/x))))))");
	    testDerive("((x^(0-1))/6)","((((((0-1)*(x^((0-1)-1)))*1)*6)-((x^(0-1))*0))/(6^2))");
	    testDerive("((x*(sin(((x/10)+x))^3))-cos(x))","(((1*(sin(((x/10)+x))^3))+(x*((3*(sin(((x/10)+x))^(3-1)))*(((((1*10)-(x*0))/(10^2))+1)*cos(((x/10)+x))))))-(0-(1*sin(x))))");
	    testDerive("(y*cos(x))","((1*cos(x))+(y*(0-(1*sin(x)))))");
	    testDerive("(10^(x+20))","(((x+20)*(10^((x+20)-1)))*0)");
	}

	public static void testTreeFromString(String string) {
		assertOutput(FormalExpressionTree.TreeFromString(string).toString(), string);
	}	

	public static void testDerive(String originalExpression, String derivedExpression) {
		FormalExpressionTree builtTree = FormalExpressionTree.TreeFromString(originalExpression);
		assertOutput(derivedExpression, builtTree.derive().toString());
	}	
}