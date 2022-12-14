package sudokuPPC;

public enum Data {
    dim9(
            new int[][]{
                    {8, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 3, 6, 0, 0, 0, 0, 0},
                    {0, 7, 0, 0, 9, 0, 2, 0, 0},
                    {0, 5, 0, 0, 0, 7, 0, 0, 0},
                    {0, 0, 0, 0, 4, 5, 7, 0, 0},
                    {0, 0, 0, 1, 0, 0, 0, 3, 0},
                    {0, 0, 1, 0, 0, 0, 0, 6, 8},
                    {0, 0, 8, 5, 0, 0, 0, 1, 0},
                    {0, 9, 0, 0, 0, 0, 4, 0, 0}
            }
    ),
    dim4(
            new int[][]{
            	{ 0, 0, 3, 0 },
            	{ 2, 3, 0, 0 },
            	{ 0, 0, 1, 0 },
            	{ 0, 0, 0, 0 }}
    )
    ;
    final int[][] grid;

    Data(int[][] grid) {
        this.grid = grid;
    }

    int grid(int i, int j) {
        return grid[i][j];
    }
}
