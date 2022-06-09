package Java8.FunctionalInterfaces;

@FunctionalInterface // Annotation is optional
public interface Test {
    // Default Method - Optional can be 0 or more
    default String HelloWorld() {
        return "Hello World";
    }
    // Static Method - Optional can be 0 or more
    static String CustomMessage(String msg) {
        return msg;
    }
    // Single Abstract Method
    void bar();
}