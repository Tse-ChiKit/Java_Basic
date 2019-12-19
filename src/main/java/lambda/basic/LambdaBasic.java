package lambda.basic;

public class LambdaBasic {

    @FunctionalInterface
    public interface MathOperation {
        int operation (int a, int b);
    }

    public int operate (int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a,b);
    }

}
