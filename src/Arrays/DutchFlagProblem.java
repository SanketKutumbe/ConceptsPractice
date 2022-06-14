package Arrays;

import java.util.Arrays;

/*
    @author Sanket Kutumbe

    input: 0, 1, 2, 1, 2, 0, 0, 0, 1
    output: 0, 0, 0, 0, 1, 1, 1, 2, 2

 */
public class DutchFlagProblem {

    public static void main(String[] args) {

        int[] arr = {0, 1, 2, 1, 2, 0, 0, 0, 1};
        int IteratorIndex;
        int low = IteratorIndex = 0;
        int n = arr.length;
        int high = n-1;

        while(IteratorIndex <= high) {

            int temp;

            if(arr[IteratorIndex] == 0)
            {
                temp = arr[low];
                arr[low] = arr[IteratorIndex];
                arr[IteratorIndex] = temp;
                low++;
                IteratorIndex++;
            }
            else if(arr[IteratorIndex] == 1)
            {
                IteratorIndex++;
            }
            else if(arr[IteratorIndex] == 2)
            {
                temp = arr[high];
                arr[high] = arr[IteratorIndex];
                arr[IteratorIndex] = temp;
                high--;
            }
        }

        Arrays.stream(arr).forEach(System.out::print);
    }

}
