package Problems.dp;

/*
    @author : Sanket Kutumbe
 */
public class KnightMovesInChess {

    public static void main(String[] args) {

        int n = 5;
        int startRow = 5, endRow = 0;
        int startCol = 2, endCol = 5;

        System.out.println(minMoves(n, startRow, startCol, endRow, endCol));
    }

    private static int minMoves(int n, int startRow, int startCol, int endRow, int endCol) {

        if (n < startRow || n < startCol || n < endRow || n < endCol) {
            return -1;
        }
        return 0;
    }
}
