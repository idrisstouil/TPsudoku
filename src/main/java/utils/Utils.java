package utils;


public class Utils {


	public static void printGrid(int[][] rows) {
		
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
		
		
		int n=rows.length;
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
				if (rows[i][j] > 9)
					System.out.print(rows[i][j] + " │ ");
				else
					System.out.print(esp + rows[i][j] + " │ ");

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
	
	public static boolean validSudokuFormat(int[][] testGrid){
		System.out.println("Verification du sudoku avant traitement");
		System.out.println("vous avez inserer ca :");

		Utils.printGrid(testGrid);
		return true;
	}
	
	

	
}
