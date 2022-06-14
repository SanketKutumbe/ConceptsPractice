package Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/*
    @author : Sanket Kutumbe

    Calculate the maximum number by concatenating all the numbers in array, with rotation
    E.g

    {1,3,4,2} Possible numbers with rotations are 1342, 3421, 4213, 2134

 */
public class FormMaxNumberWithRotation implements Comparator<Integer>{

    public static void main(String[] args) {

        Integer[] arr =  {546, 548, 60, 54, 123, 999};
//        solvedUsingStringBuilder(arr);
        solvedUsingComparator(arr);

    }

    private static void solvedUsingStringBuilder(int[] arr) {
        int index = -1, max = -1;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < arr.length; i++)
        {
            sb.insert(0, arr[i]);
            if( max < sb.charAt(0) )
            {
                max = sb.charAt(0);
                index = i;
            }
        }

        sb.replace(0, sb.capacity(), "");
        sb.insert(0, arr[index]);

        for(int i = index + 1; i < arr.length; i++)
            sb.append(arr[i]);

        for(int i = 0; i < index; i++)
            sb.append(arr[i]);

        System.out.println(sb);
    }

    private static void solvedUsingComparator(Integer[] arr) {
        Arrays.sort(arr, new FormMaxNumberWithRotation() );
        System.out.println(new ArrayList<Integer>(Arrays.asList(arr)));
    }

    public int compare(Integer o1, Integer o2) {
        String sa = o1.toString();
        String sb = o2.toString();
        return (sb+sa).compareTo(sa+sb);
    }
}
