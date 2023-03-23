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
		for(int i= row,j= colm; i>=0 && j<arr.length; i--,j++)
		{
			if(arr[i][j]=='Q')
				return false;

		}
		for(int i = row,j= colm; i>=0; i--)
		{
			if(arr[i][j]=='Q')
				return false;
		}

		return true;
	}
	static void nQueen(char arr[][],int row)
	{
		if(row==arr[0].length)
		{
			print(arr);
			System.out.println();
			return;
		}

		for(int i=0; i<arr[0].length; i++)
		{
			arr[row][i] = 'Q';
			if(isSafe(arr,row,i))
			{
				nQueen(arr,row+1);
			}
			// arr[row][i] = '.';
		}
	}
	public static void main(String ars[])
	{
		int n = 4;

		char arr[][] = new char[n][n];

		for(int i=0; i<n; i++)
		{
			for(int j=0; j<n; j++)
				arr[i][j] = '.';
		}

		nQueen(arr,0);
	}
}