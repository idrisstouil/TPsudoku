package sudokuPPC;
import org.apache.commons.cli.ParseException;
import utils.Utils;

public class Main {
	public static void main(String[] args) throws ParseException {

		// Ici vous pouvez initialiser la sudoku
		Data sudokuGrid = Data.dim9;
		int dim = 9;
		
		Utils.validSudokuFormat(sudokuGrid.grid);
		new SudokuPPC(dim, sudokuGrid).solve();
	}

}
