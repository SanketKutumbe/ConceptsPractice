package Java8.FunctionalInterfaces;

class MyException extends Exception {}

public class EV implements Vehicle{

    public void fuel_type()
    {
        System.out.println("Electric vehicle");
    }

    public static void main(String[] args) {
        EV f = new EV();
        try{
            f.readFile();
            Exception e = null;
            throw e;
        }
        catch (MyException e){
            f.readFile();
        }
        catch (Exception e){
//            f.readFile();
        }
        finally{
            f.deleteFile();
        }
    }
    public void readFile() throws MyException {
        throw new MyException();
    }
    public void deleteFile() throws RuntimeException{
        throw new NullPointerException();
    }
}
