package Java8.Exceptions;

import java.io.IOException;

class Parent {

    public void readFile(String path) throws IOException{
        //reads file
    }
}

class Child extends Parent{

    public void readFile(String path) { //does not throw exception
        // method overrriden
        System.out.println(path);
    }

}

public class ExceptionThrower {

    public static void main( String args[] ) {
        throws_unchecked_exception("filename.text");
//        throws_checked_exception("filename.text");

        //Parent-Child relationship
        over_riding_methods_with_exceptions();
    }

    private static Object over_riding_methods_with_exceptions() {

        Child c = new Child();
        c.readFile("Parent-child method over-riding with exceptions");
        return c;
    }

    private static void throws_checked_exception(String s) throws IOException { //Checked Exception
        //code here
        System.out.println("Reading File");
    }

    public static void throws_unchecked_exception(String path) throws RuntimeException{ //UncheckedException
        //code here
        System.out.println("Reading File");
    }
}


