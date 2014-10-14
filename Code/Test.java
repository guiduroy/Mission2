package Code;
import java.lang.*;
/**
 * Test de TreeInterpretation
 * Author : Anne-Sophie Branders
 * Date : 14/10/2014
 */
public class Test
{
    public static void main(String[] args) {

        AdditionOperator addition = new AdditionOperator();
        
        RecursiveBinaryTree leftTree = new RecursiveBinaryTree();
        leftTree.setElement(2);
        addition.setLeft(leftTree);
        
        MultiplicationOperator multiplication = new MultiplicationOperator();
        addition.setRight(multiplication);
        
        RecursiveBinaryTree leftmult = new RecursiveBinaryTree();
        leftmult.setElement(4);
        multiplication.setLeft(leftmult);
        
        RecursiveBinaryTree rightmult = new RecursiveBinaryTree();
        rightmult.setElement(3);
        multiplication.setRight(rightmult);
        
        TreeInterpretor newexpression = new TreeInterpretor();
        newexpression.eulerTour(addition);
        System.out.println(newexpression.printExpression());
    }
}
