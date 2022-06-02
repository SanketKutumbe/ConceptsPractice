package Java8.Exceptions;

public class MyExceptions {
    public static void main(String args[]) {
        throw_multiple_exceptions();
        nested_try_catch();
        exception_is_thrown_but_not_handled();

        System.out.println("Value returned: "+returning_from_catch(5));

    }

    private static int returning_from_catch(int value) {
        Integer[] arr = null;

        try{
            System.out.println(arr[0]);
        }catch(NullPointerException e){
            // exception caught here
            return value;
        }finally{ // this is an optional block
            // will always be executed
            System.out.println("Finally executed");
        }
        return value;
    }

    private static void exception_is_thrown_but_not_handled() {
        int months = 5;
        int salary = 0;

        try{
            System.out.print(months/salary); // 5/0 will throw a Arithmetic Exception
        }catch(NullPointerException e){
            System.out.println("Exception caught");
        }finally{ // this is an optional block
            // will always be executed
            System.out.println("Finally executed");
        }
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
//            throw new ArithmeticException();  // exception 2
        } catch(ArithmeticException | NullPointerException e){
            // exception caught here
            System.out.print("A");
        }catch (Exception e) {
            System.out.print(e);
        }
    }
}
