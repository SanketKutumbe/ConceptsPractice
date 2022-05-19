package Arrays;

import java.util.ArrayList;

class first
{
    int i;
    void display()
    {
        System.out.println(i);
    }
}
class second extends first
{
    int j;
    void display()
    {
        System.out.println(this.i + j);
    }
}

public class SetMatrixZeroes {



    private int value;
    public void setValue(int i){
        this.value =  i;
    }

    SetMatrixZeroes(){
        System.out.println("hi");
    }

    public static <T extends Comparable<T>> T minimum (T a, T b)
    {
        if(a.compareTo(b) < 0)
            return a;
        else
            return b;
    }


    public static void main(String[] args) {


        ArrayList arr = new ArrayList();
        arr.add("A");
        arr.add(1);
        arr.add(3);
        arr.add(2, "C");
        System.out.println(arr);

        System.out.println(minimum(1, 2));
        System.out.println(minimum(2.9, 11.1));
        System.out.println(minimum('a', 'b'));

        int matrix[][]= {{1,1,1,1},{1,0,1,1},{1,1,1,1}};
        int row = matrix[0].length;
        System.out.println(row);

        System.out.println("\"\\Hello World\\\"");

        String str = "Hello" + "\" " + "/World\"";

        System.out.println(str);

        if(true && false && true || false)
            System.out.println("True");
        else if(false && false && true)
            System.out.println("False");
        else
            System.out.println("Nothing");

        int var = (false) ? 7 : 8;
        System.out.println(var);

        int n = 1234;
        while(n > 10){
            int val = n / 10;
            n = n % 10;
            System.out.println(val);
        }

        int[] arr2 = new int[2];
        System.out.println(arr2[1]);

        int[][] arr2d = {{1,2,3,4,5}, {5,4,3,2,1}};
        System.out.print(arr2d.length + " " + arr2d[1][3]);

        second obj = new second();
        obj.i = 1;
        obj.j = 2;
        obj.display();
    }
}


