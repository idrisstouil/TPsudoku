package sudokuBT;

import utils.Utils;

public class Main {
	public static void main(String args[]) {

		int[][] grid = { { 0, 0, 3, 0 }, { 2, 3, 0, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 } };

		int dim = 4;

		SudokuBT sudoku = new SudokuBT(dim, grid);

		Utils.validSudokuFormat(grid);

		sudoku.findSolution(0, 0);

		//sudoku.findSolutionAll(0, 0);

	}
}
