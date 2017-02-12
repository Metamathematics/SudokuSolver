package gdp.aufgabe22;

import static java.util.Arrays.sort;
import static java.util.Arrays.copyOf;

public class XSudoku {

	public static void main(String[] args) {
		
		
		
		
		
		
	        solve (Helper.gueltigesSudoku);
	        //Helper.testprint (Helper.gueltigesSudoku);
	        Helper.printSudoku (Helper.gueltigesSudoku);
	       
	        //Helper.returnBlock(Helper.gueltigesSudoku, 0, 2, 0, 3);
	        
	        //isPermutationBlock (Helper.gueltigeLoesung,0,2,0,4);
	        
	        
	        
	        
	}
	

	public static boolean isPermutation(int[] a) {

		int[] b = copyOf(a, a.length);

		sort(b);

		for (int i = 0; i < b.length - 1; ++i) {

			if (b[i] != 0)
				if (b[i] == b[i + 1])
					return false;

		}
		return true;
	}

	public static boolean isPermutationCol(int[][] a, int row) {

		int[] arow = new int[a.length];

		for (int i = 0; i < a.length; ++i) {
			arow[i] = a[i][row];
		}

		return isPermutation(arow);
	}

	public static boolean isPermutationRow(int[][] a, int col) {

		int[] acol = new int[a[col].length];

		for (int i = 0; i < a[col].length; ++i) {
			acol[i] = a[col][i];
		}

		return isPermutation(acol);
	}

	public static boolean isPermutationDiagonal(int[][] a) {

		int[] adig = new int[a.length];
		int[] adig2 = new int[a.length];

		for (int i = 0; i < a.length; ++i) {
			adig[i] = a[i][i];
			adig2[i] = a[i][a.length - i - 1];
		}

		return (isPermutation(adig) && isPermutation(adig2));
	}

	public static boolean isPermutationBlock(int[][] a, int minRow, int maxRow, int minCol, int maxCol) {

		int[] ablock = new int[(maxRow-minRow) * (maxCol - minCol)];
		int x = 0;

		for (int row = minRow; row < maxRow; ++row) {
			for (int col = minCol; col < maxCol; ++col) {
				
				ablock[x] = a[row][col];
				++x;
				
			}
		}

		return isPermutation(ablock);
	}

	public static boolean isPermutationBlock(int[][] a, int num) {

		switch (num) {
		case 1:
			return isPermutationBlock(a, 0, 3, 0, 3);
		case 2:
			return isPermutationBlock(a, 0, 3, 3, 6);
		case 3:
			return isPermutationBlock(a, 0, 3, 6, 9);

		case 4:
			return isPermutationBlock(a, 3, 6, 0, 3);
		case 5:
			return isPermutationBlock(a, 3, 6, 3, 6);
		case 6:
			return isPermutationBlock(a, 3, 6, 6, 9);

		case 7:
			return isPermutationBlock(a, 6, 9, 0, 3);
		case 8:
			return isPermutationBlock(a, 6, 9, 3, 6);
		case 9:
			return isPermutationBlock(a, 6, 9, 6, 9);
		}
		return false;
	}

	public static boolean isPermutationMatrix(int[][] a) {

		boolean testmatr = true;

		for (int col = 0; (col < a.length) && (testmatr == true); ++col) {

			testmatr = testmatr && isPermutationCol(a, col);
		}

		for (int row = 0; (row < a[0].length) && (testmatr == true); ++row) {

			testmatr = testmatr && isPermutationRow(a, row);
		}

		return testmatr;
	}

	public static boolean isValid(int[][] a) {

		boolean blocks = true;
		for (int i = 1; (i <= a.length) && (blocks == true); ++i)
			blocks = blocks && isPermutationBlock(a, i);

		boolean matr =  isPermutationMatrix(a);
		boolean diagonal =  isPermutationDiagonal(a);
		
		return blocks && matr && diagonal;
	}
	
	public static int[][] solve (int[][] a) {
		
		if ( solving (a) ) return a;
		return null;
		
	}

	public static boolean solving (int[][] a) {
		
		for (int i = 0; i<a.length; ++i){
			for (int j = 0; j <a[i].length; ++j){
				
				if (a[i][j] == 0){
					for (int  k = 1; k <= a.length && a[i][j] == 0; ++k){
						a[i][j] = k;
						if ( isValid(a) ){ 
							if (!solving (a)) a[i][j] = 0;
							}
						else a[i][j] = 0;
					}
					if (a[i][j] == 0) return false;
					return true;
				}
				
			}
		}
		if ( isValid(a) ) return true;
		return false;
	}
}
