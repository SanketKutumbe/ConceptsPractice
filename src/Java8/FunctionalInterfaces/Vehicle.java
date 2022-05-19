package Java8.FunctionalInterfaces;

@FunctionalInterface
public interface Vehicle {

    public default void engine()
    {
        System.out.println("Printing interface engine");
    }
    public void fuel_type();
}
