package Code;
import java.lang.*;
/**
 * Test de TreeInterpretation
 * Author : Anne-Sophie Branders
 * Date : 14/10/2014
 */
public class Test
{
    public void main() throws EmptyStackException {

        String s = "((10*2)/(4-x))";
        System.out.println(s);
        FormalExpressionTree tree = buildFromString(s);
        String s2 = toString(tree);
        System.out.println(s2);
        
        FormalExpressionTree derivedtree = tree.derive();
        String s3 = toString((derivedtree));
        System.out.println(s3);
    }
}
