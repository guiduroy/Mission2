/**
 * Author : Gregory Vander Schueren
 * Date : 16/10/2014
 */

package Tests;
public class Tests {
	
	public static void assertOutput(String input, String expectedOutput) {
		 if (input.equals(expectedOutput)) {
			 System.out.println("OK!");
		 } else {
			System.out.println("ERROR: '" + expectedOutput + "' was expected but got '"+ input + "' as output.");
		 }
	}
}
