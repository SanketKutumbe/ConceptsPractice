package Java8.Exceptions;

public class MyExceptions {
    public static void main(String args[]) {
        throw_multiple_exceptions();
        nested_try_catch();

    }

    private static void nested_try_catch() {
        int a = 5;
        int b = 0;

        try{
            try{
                a = a / b;
            }catch(ArithmeticException e){
                System.out.print("B");
            }
        }catch(ArithmeticException e){
            System.out.print("A");
        }
    }

    public static void throw_multiple_exceptions()
    {
        try {
            throw new NullPointerException(); // exception 1
            throw new ArithmeticException();  // exception 2
        } catch(ArithmeticException | NullPointerException e){
            // exception caught here
            System.out.print("A");
        }catch (Exception e) {
            System.out.print(e);
        }
    }
}
