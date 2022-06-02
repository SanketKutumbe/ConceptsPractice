package Java8.Exceptions;

public class MyNewExceptions{

    public static void main(String[] args) {
//        returning_primitive_values();
        returning_referential_values();
    }

    private static void returning_referential_values() {
        MyNewExceptions c  =  new MyNewExceptions();
        System.out.print("Returned Value is "+c.method2()[0]);

    }

    public int[] method2() {
        int value = 10;
        int[] arr = {1};
        try{
            System.out.println(arr[4]);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Exception caught value is "+ arr[0]);
            return arr; // value is being returned from inside catch
        }finally{
            arr[0] += 2;
            System.out.println("Finally value is "+ arr[0]);
        }
        return arr; //returning a referential type variable
    }

    private static void returning_primitive_values() {
        System.out.print("Returned Value is: "+method1());
    }

    public static int method1() {
        int value = 1;
        try{
            throw new ArrayIndexOutOfBoundsException();
        }catch(ArrayIndexOutOfBoundsException e){
            value = 2;
            System.out.println("Exception caught value is "+ value);
            return value; // value is being returned inside catch
        }finally{
            value = 3;
            System.out.println("Finally value is now "+ value);
            return value; // value is being returned inside finally
        }

    }
}
