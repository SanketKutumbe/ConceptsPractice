package Java8;

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

    }
}
