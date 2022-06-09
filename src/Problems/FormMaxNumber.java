package Problems;

import java.util.Arrays;

public class FormMaxNumber {

    public static void main(String[] args) {

        int[] arr =  {546, 548, 60, 54};
        boolean[] visited = new boolean[arr.length];
        Arrays.fill(visited, false);

        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
            System.out.println(visited[i]);
        }

    }
}
