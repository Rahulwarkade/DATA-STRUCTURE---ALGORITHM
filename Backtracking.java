public class Backtracking
{
	void printArr(int arr[])
	{
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
	void backTrackOnArr(int arr[],int idx,int val)
	{
		if(idx == arr.length)
		{
			printArr(arr);
			return;
		}
		arr[idx] = val;
		backTrackOnArr(arr,idx+1,val+1);
		arr[idx] -= 2;
	}

	void subSets(String str,int idx,String subset)
	{
		if(str.length() == idx)
		{
			if(subset!="")
				System.out.println(subset);
			else
				System.out.println("null");
			return;
		}
		subSets(str,idx+1,subset+str.charAt(idx));
		// subSets(str,idx+1,subset.append(str.charAt(idx)));
		// subset.deleteCharAt(idx);
		subSets(str,idx+1,subset);
	}

	void permutation(String str,String permu)
	{
		if(0==str.length())
		{
			System.out.println(permu);
			return;
		}
		for(int i=0; i<str.length(); i++)
		{
			char curr = str.charAt(i);
			String newStr = str.substring(0,i) + str.substring(i+1);
			permutation(newStr,permu+curr);
		}
	}

	static void print(char arr[][])
	{
		for(int i=0; i<arr[0].length; i++)
		{
			for(int j=0; j<arr[0].length; j++)
				System.out.print(arr[i][j]+" ");
			System.out.println();
		}
	}

	static boolean isSafe(char arr[][],int row,int colm)
	{
		//left diagonal
		for(int i = row,j= colm; i>=0 && j>=0; i--,j--)
		{
			if(arr[i][j]=='Q')
				return false;
		}
		//right diagonal
		for(int i= row,j= colm; i>=0 && j<arr.length; i--,j++)
		{
			if(arr[i][j]=='Q')
				return false;

		}
		//top column 
		for(int i = row,j= colm; i>=0; i--)
		{
			if(arr[i][j]=='Q')
				return false;
		}

		return true;
	}
	static int count = 0;
	static boolean nQueen(char arr[][],int row)
	{
		if(row==arr.length)
		{
			// print(arr);
			// System.out.println();
			count++;

			// return;
			return true;
		}

		for(int i=0; i<arr[0].length; i++)
		{
			if(isSafe(arr,row,i))
			{
				arr[row][i] = 'Q';
				if(nQueen(arr,row+1))
				{
					return true;
				}
				arr[row][i] = '.';
			}
		}
		return false;
	}

	public static int gridWays(int grid[][],int x,int y)
	{
		if((x==grid.length-1) && (y==grid[0].length-1)) return 1;
		if(x>=grid.length || y>=grid[0].length) return 0;

		return gridWays(grid,x+1,y) + gridWays(grid,x,y+1);
	}

	public static void printSudoku(int arr[][])
	{
		for(int i=0; i<arr.length; i++)
		{
			for(int j=0; j<arr[0].length; j++)
			{
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}

	public static boolean isSafeCell(int sudoku[][],int row,int col,int digit)
	{
		//row wise
		for(int i=0; i<9; i++)
		{
			if(sudoku[i][col]==digit)
				return false;
		}
		//colmun wise		
		for(int i=0; i<9; i++)
		{
			if(sudoku[row][i]==digit)
				return false;
		}
		//is Grid safe

		int firstR = (row/3)*3;
		int firstC = (col/3)*3;

		for(int i=firstR; i<(firstR+3); i++)
		{
			for(int j=firstC; j<(firstC+3); j++)
				if(sudoku[i][j]==digit)
					return false;
		}

		return true;
	}
	public static boolean sudokuSolver(int sudoku[][],int row,int col)
	{
		if(row==sudoku.length)
			return true;
		int nextR,nextC;
		nextC = col+1;
		nextR = row;
		if(col+1==sudoku[0].length)
		{
			nextR = row+1;
			nextC = 0;
		}
		if(sudoku[row][col]!=0)
		{
			return sudokuSolver(sudoku,nextR,nextC);
		}
		for(int digit = 1; digit<=9; digit++)
		{
			if(isSafeCell(sudoku,row,col,digit))
			{
				sudoku[row][col] = digit;
				if(sudokuSolver(sudoku,nextR,nextC))
				{
					return true;
				}
				sudoku[row][col] = 0;
			}
		}

		return false;
	}

	public static void main(String ars[])
	{

		int sudoku[][] = {
			{0,0,8,0,0,0,0,0,0},
			{4,9,0,1,5,7,0,0,2},
			{0,0,3,0,0,4,1,9,0},
			{1,8,5,0,6,0,0,2,0},
			{0,0,0,0,2,0,0,6,0},
			{9,6,0,4,0,5,3,0,0},
			{0,3,0,0,7,2,0,0,4},
			{0,4,9,0,3,0,0,5,7},
			{8,2,7,0,0,9,0,1,3}
		};


		System.out.println(sudokuSolver(sudoku,0,0));
		printSudoku(sudoku);
	}
}