package SDEChallenge.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/*
    @author : Sanket Kutumbe

    https://takeuforward.org/data-structure/set-list-zero/

    Examples 1:

    Input: list=[[1,1,1],[1,0,1],[1,1,1]]

    Output: [[1,0,1],[0,0,0],[1,0,1]]

    Explanation: Since list[2][2]=0. Therefore the 2nd column and 2nd row wil be set to 0.

    Input: list=[[0,1,2,0],[3,4,5,2],[1,3,1,5]]

    Output:[[0,0,0,0],[0,4,5,0],[0,3,1,0]]

    Explanation:Since list[0][0]=0 and list[0][3]=0. Therefore 1st row, 1st column and 4th column will be set to 0

 */
public class SetMatrixZeroes {

    public static void main(String[] args) {


        int[][] list = {{1,1,1}, {1,0,1}, {1,1,1}, {1,1,0}};
        int rowSize = list.length;
        int colSize = list[0].length;
//        usingExtraSpace(list, rowSize, colSize);
        withoutUsingExtraSpace(list, rowSize, colSize);

    }

    private static void withoutUsingExtraSpace(int[][] list, int rowSize, int colSize) {

       int col0 = 1, row0 = 1;

       for(int a: list[0])
       {
           if(a == 0) {
               row0 = 0;
               break;
           }

       }

       for(int j = 0 ; j < rowSize; j++)
       {
           if( list[j][0] == 0 ) {
               col0 = 0;
               break;
           }
       }

        for (int i = 1; i < rowSize; i++) {
            for (int j = 1; j < colSize; j++)
                if (list[i][j] == 0)
                    list[i][0] = list[0][j] = 0;
        }

        for (int i = rowSize - 1; i >= 1; i--) {
            for (int j = colSize - 1; j >= 1; j--)
                if (list[i][0] == 0 || list[0][j] == 0)
                    list[i][j] = 0;
        }

        if( col0 == 0 )
        {
            for(int j = 0 ; j < rowSize; j++)
                list[j][0] = 0;
        }

        if( row0 == 0 )
        {
            for(int j = 0 ; j < rowSize; j++)
                list[0][j] = 0;
        }
        

        System.out.println(Arrays.deepToString(list));

    }

    private static void usingExtraSpace(int[][] list, int rowSize, int colSize) {


        int[] rows = new int[rowSize];
        int[] cols = new int[colSize];

        Arrays.fill(rows, -1);
        Arrays.fill(cols, -1);

        for(int i = 0; i < rowSize; i++)
        {
            for(int j = 0; j < colSize; j++)
            {
                if( list[i][j] == 0 )
                {
                    rows[i] = 0;
                    cols[j] = 0;
                }
            }
        }

        for(int i = 0; i < rowSize; i++)
        {
            if( rows[i] == 0 )
            {
//
                for(int j = 0; j < colSize; j++)
                    list[i][j] = 0;
            }
        }

        for(int i = 0; i < colSize; i++)
        {
            if( cols[i] == 0 )
            {
//
                for(int j = 0; j < colSize; j++)
                    list[j][i] = 0;
            }
        }

        System.out.println(Arrays.deepToString(list));
    }
}
