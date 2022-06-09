package Java8.FunctionalInterfaces;

import java.util.function.Function;

public class FuncInterfaceTest implements Test {

    // Default Method - Optional to Override
    @Override
    public String HelloWorld() {
        return "Hello Java 8";
    }

    // Method Override
    @Override
    public void bar() {
        System.out.println("Hello World");
    }

    public static void main(String[] args) {

        FuncInterfaceTest fi = new FuncInterfaceTest();
        System.out.println(fi.HelloWorld());
        System.out.println(Test.CustomMessage("Hi"));
        fi.bar();
        Child.main(1);
        Test test = new FuncInterfaceTest();
        Function<String, String> customMessage = Test::CustomMessage;
        System.out.println();

    }
}

class Child extends FuncInterfaceTest
{
    public static void main(int a)
    {
        System.out.println("Anything");
//        FuncInterfaceTest.main(new String[0]);
    }
}