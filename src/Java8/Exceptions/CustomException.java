package Java8.Exceptions;

public class CustomException extends Throwable {

    CustomException()
    {

    }
    CustomException(int a)
    {
        super();
        if(a==1)
            System.out.println("Throw custom exception to test");
    }
}
