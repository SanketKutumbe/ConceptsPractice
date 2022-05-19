package Arrays;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListRotate {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{ 22, 12, 99, 33, 11, -98, 100};
        ArrayList<Integer> myList = new ArrayList<>(7);

        for (int i : arr)
        {
            myList.add(i);
        }
//[2, 4, 6, 10, 3, 1, 7]
//[-98, 100, 22, 12, 99, 33, 11]
//[12, 76, 84, 55, 43, 23, 37]
//[12, -23, 23, -13, 43, -99]
//[-100, 2, 6, 8, 77, 5, 7, 9, 223]
//        myList.add(43);
//        myList.add(9);
//        myList.add(6);
//        myList.add(10);
//        myList.add(1);
//        myList.add(3);
//        myList.add(7);

        int cap = myList.size();


        for(int i = 0; i < cap; )
        {
            if( myList.get(i) % 2 != 0 )
            {
                myList.add(myList.get(i));
                myList.remove(i);
                cap--;            }
            else
                i++;
        }

        System.out.println(myList);

        float let = -123.424f;
    }
}
