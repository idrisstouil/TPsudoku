package sudokuPPC;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.variables.IntVar;
import static org.chocosolver.solver.search.strategy.Search.minDomLBSearch;
import static org.chocosolver.util.tools.ArrayUtils.append;

public class SudokuPPC {

	static int n;
	static int s;
	private static int instance;
	private static long timeout = 3600000; // one hour

	IntVar[][] rows, cols, shapes;

	Model model;
	
    Data data ;


	public SudokuPPC(int dim,Data grid) {
		n = dim;
		s = (int) Math.sqrt(n);
		data=grid;
	}

	public void solve() {

		buildModel();

		model.getSolver().solve();

		System.out.println("Solution trouvé :");

		printGrid();

		model.getSolver().printStatistics();

	}

	public void printGrid() {

		String a;
		a = "┌───";
		String b;
		b = "├───";
		String c;
		c = "─┬────┐";
		String d;
		d = "─┼────┤";
		String e;
		e = "─┬───";
		String f;
		f = "─┼───";
		String g;
		g = "└────┴─";
		String h;
		h = "───┘";
		String k;
		k = "───┴─";
		String esp = " ";
		
		

		for (int i = 0; i < n; i++) {

			for (int line = 0; line < n; line++) {
				if (line == 0) {
					System.out.print(i == 0 ? a : b);
				} else if (line == n - 1) {
					System.out.print(i == 0 ? c : d);
				} else {
					System.out.print(i == 0 ? e : f);
				}
			}
			System.out.println("");
			System.out.print("│ ");
			for (int j = 0; j < n; j++) {
				if (rows[i][j].getValue() > 9)
					System.out.print(rows[i][j].getValue() + " │ ");
				else
					System.out.print(esp + rows[i][j].getValue() + " │ ");

			}

			if (i == n - 1) {
				System.out.println("");
				for (int line = 0; line < n; line++) {
					System.out.print(line == 0 ? g : (line == n - 1 ? h : k));
				}
			}
			System.out.println("");

		}
	}

	public void buildModel() {
		model = new Model();

		rows = new IntVar[n][n];
		cols = new IntVar[n][n];
		shapes = new IntVar[n][n];
		
		//test init var
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				
				if (data.grid(i, j) > 0) {
                    rows[i][j] = model.intVar(data.grid(i, j));
                } else {
                	rows[i][j] = model.intVar("c_" + i + "_" + j, 1, n, false);
                }
				
				cols[j][i] = rows[i][j];
			}
		}

		for (int i = 0; i < s; i++) {
			for (int j = 0; j < s; j++) {
				for (int k = 0; k < s; k++) {
					for (int l = 0; l < s; l++) {
						shapes[j + k * s][i + (l * s)] = rows[l + k * s][i + j * s];
					}
				}
			}
		}

		for (int i = 0; i < n; i++) {

			model.allDifferent(rows[i]).post();
			model.allDifferent(cols[i]).post();
			model.allDifferent(shapes[i]).post();
			
			

		}


	}

	// Check all parameters values
	public static void checkOption(CommandLine line, String option) {

		switch (option) {
		case "inst":
			instance = Integer.parseInt(line.getOptionValue(option));
			break;
		case "timeout":
			timeout = Long.parseLong(line.getOptionValue(option));
			break;
		default: {
			System.err.println("Bad parameter: " + option);
			System.exit(2);
		}

		}

	}

	

	public void configureSearch() {
		model.getSolver().setSearch(minDomLBSearch(append(rows)));

	}

     

}


