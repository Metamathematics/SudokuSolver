package gdp.aufgabe22;

public class Helper {
	
	public static void testprint (int[][] gL){
		   
		   printRow (gL);
		   printCol (gL);
		   
		   printDiagonal (gL);
		   printBlock (gL);
		   
		   printMatrix (gL);
		   printValid (gL);
		   
	}
	
	//Print tests---------------------------------
	
	public static void printRow (int[][] gL){
		System.out.println( "Row: " );
	       for (int i=0; i<9;++i) System.out.print(i + 1 + "" +  XSudoku.isPermutationRow(gL,i) + " " );
	       System.out.println( "" );
	}
	
	public static void printCol (int[][] gL){
	       System.out.println( "Col: " );
	       for (int i=0; i<9;++i) System.out.print(i + 1 + "" +  XSudoku.isPermutationCol(gL,i) + " " );
	       System.out.println( "" );
	}
	
	public static void printDiagonal (int[][] gL){
		System.out.println( "Diagonal: " );
	       System.out.print( XSudoku.isPermutationDiagonal(gL) );
	       System.out.println( "" );
	}
	
	public static void printBlock (int[][] gL){
		System.out.println( "Block: " );
	    for (int i=1; i<=9;++i) System.out.print(i + "" +  XSudoku.isPermutationBlock(gL,i) + " " );
	    System.out.println( "" );
	}
	
	public static void printMatrix (int[][] gL){
		System.out.println( "Matrix: " );
	    System.out.print( XSudoku.isPermutationMatrix(gL) );
	    System.out.println( "" );
	}
	
	public static void printValid (int[][] gL){
	       System.out.println( "Valid: " );
	       System.out.print( XSudoku.isValid(gL) );
	       System.out.println( "" );
	}

	//Print whole Sudoku field or elements of it------------------------------------------
	
	public static void printSudoku (int[][] a){
		
		for (int i = 0; i<a.length; ++i){
			for (int j = 0; j < a[i].length; ++j){
				System.out.print(a[i][j] + ", ");
				if ( j == 2 || j == 5) System.out.print(" ");
			}
			System.out.println();
			if ( i == 2 || i == 5) System.out.println();
		}
	}
	
	public static void returnElements (int[] a){
		
		for (int i = 0; i<a.length; ++i) System.out.print( a[i] + " " );
	}
	
	
	
	public static void returnBlock (int[][] a, int minRow, int maxRow, int minCol, int maxCol) {
		
		int[] ablock = new int[(maxRow-minRow) * (maxCol - minCol)];
		int x = 0;

		for (int row = minRow; row < maxRow; ++row) {
			for (int col = minCol; col < maxCol; ++col) {
				
				ablock[x] = a[col][row];
				++x;
				
			}
		}
		returnElements(ablock);
	}
	
	public static void returnBlock (int[][] a,int i){
		
		switch (i) {
		case 1:
			returnBlock(a, 0, 3, 0, 3); break;
		case 2:
			returnBlock(a, 0, 3, 3, 6);break;
		case 3:
			returnBlock(a, 0, 3, 6, 9);break;

		case 4:
			returnBlock(a, 3, 6, 0, 3);break;
		case 5:
			returnBlock(a, 3, 6, 3, 6);break;
		case 6:
			 returnBlock(a, 3, 6, 6, 9);break;

		case 7:
			 returnBlock(a, 6, 9, 0, 3);break;
		case 8:
			 returnBlock(a, 6, 9, 3, 6);break;
		case 9:
			 returnBlock(a, 6, 9, 6, 9);break;
		}
	    
	}
	
	
	//Sudokus-------------------------------------------------------------
	
	public static int[][] gueltigesSudoku = new int[][] {
        {0, 8, 7,  0, 0, 0,  0, 0, 0},
        {5, 0, 4,  0, 0, 0,  0, 0, 0},
        {0, 0, 1,  0, 7, 0,  2, 0, 0},

        {0, 0, 9,  0, 0, 0,  1, 3, 0},
        {2, 0, 0,  0, 0, 1,  0, 9, 0},
        {1, 0, 0,  0, 0, 0,  0, 0, 4},

        {0, 0, 0,  0, 1, 9,  0, 0, 0},
        {0, 0, 2,  7, 0, 0,  0, 6, 0},
        {8, 9, 0,  0, 0, 3,  0, 0, 0}
    };
        
       public static int[][] gueltigeLoesung = new int[][] {
            {9, 8, 7,  1, 5, 2,  3, 4, 6},
            {5, 2, 4,  3, 9, 6,  8, 7, 1},
            {6, 3, 1,  4, 7, 8,  2, 5, 9},

            {7, 5, 9,  8, 6, 4,  1, 3, 2},
            {2, 4, 8,  5, 3, 1,  6, 9, 7},
            {1, 6, 3,  9, 2, 7,  5, 8, 4},

            {3, 7, 5,  6, 1, 9,  4, 2, 8},
            {4, 1, 2,  7, 8, 5,  9, 6, 3},
            {8, 9, 6,  2, 4, 3,  7, 1, 5}
        };
        
        public int[][] fSudoku = new int[][] {
            {0, 0, 0,  0, 0, 0,  6, 8, 0},
            {0, 0, 0,  0, 7, 3,  0, 0, 9},
            {3, 0, 9,  0, 0, 0,  0, 4, 5},

            {4, 9, 0,  0, 5, 0,  0, 0, 0},
            {8, 0, 3,  0, 5, 0,  9, 8, 2},
            {0, 8, 0,  0, 0, 0,  0, 3, 6},

            {9, 6, 0,  0, 0, 0,  3, 0, 8},
            {7, 0, 0,  6, 8, 0,  0, 9, 0},
            {0, 2, 8,  0, 0, 0,  0, 0, 0}
        };
        
}
