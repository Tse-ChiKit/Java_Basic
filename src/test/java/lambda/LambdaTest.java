package lambda;

import lambda.basic.LambdaBasic;
import lambda.basic.LambdaBasic.MathOperation;
import org.junit.Assert;
import org.junit.Test;

public class LambdaTest {

    @Test
    public void TestMathOperationWithAdd(){

        LambdaBasic lambdaBasicTester = new LambdaBasic();

        MathOperation addOperation = (int a, int b) -> a + b;

        Assert.assertEquals(lambdaBasicTester.operate(2,3, addOperation),5);


    }

    @Test
    public void TestMathOperationWithSub(){

        LambdaBasic lambdaBasicTester = new LambdaBasic();

        MathOperation subOperation = (a, b) -> a - b;

        Assert.assertEquals(lambdaBasicTester.operate(6,2, subOperation),4);


    }

    @Test
    public void TestMathOperationWithMulti(){

        LambdaBasic lambdaBasicTester = new LambdaBasic();

        MathOperation multiOperation = (a, b) -> a * b;

        Assert.assertEquals(lambdaBasicTester.operate(4,3, multiOperation),12);


    }

    @Test
    public void TestMathOperationWithDiv(){

        LambdaBasic lambdaBasicTester = new LambdaBasic();

        MathOperation divOperation = (a, b) -> {return a / b; };

        Assert.assertEquals(lambdaBasicTester.operate(10,2, divOperation),5);


    }
}
