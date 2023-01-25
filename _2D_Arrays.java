// import java.util.*;

public class _2D_Arrays
{
    static void creation(int arr[][])
    {
        // Scanner jin = new Scanner(System.in);
        for(int i=0; i<arr.length; i++)
        {
            for(int j=0; j<arr[0].length; j++)
            {
                // arr[i][j] = jin.nextInt();
            }
        }

        for(int i=0; i<arr.length; i++)
        {
            for(int j=0; j<arr[0].length; j++)
            {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    static boolean searching(int arr[][], int key)
    {
        for(int i=0; i<arr.length; i++)
        {
            for(int j=0; j<arr[0].length; j++)
            {
                if(arr[i][j]==key)
                {
                    System.out.println("key is found at cell = ["+i+","+j+"]");
                    return true;
                }
            }
        }
        return false;
    }
    static void spiralMatrix(int arr[][])
    {
        int startingRow,startingCol,endingRow,endingCol;
        startingRow = startingCol = 0;
        endingRow = arr.length-1;
        endingCol = arr[0].length-1;

        while(startingRow<=endingRow && startingCol<=endingCol)
        {
            for(int i=startingRow; i<=endingCol; i++)
            {
                System.out.print(arr[startingRow][i]+",");
            }
            for(int j=startingRow+1; j<=endingRow; j++)
            {
                System.out.print(arr[j][endingCol]+",");
            }
            for(int k=endingCol-1; k>=startingCol; k--)
            {
                if(startingRow == endingRow) break;
                System.out.print(arr[endingRow][k]+",");
            }
            for(int l=endingRow-1; l>=startingRow+1; l--)
            {
                if(startingCol == endingCol) break;
                System.out.print(arr[l][startingCol]+",");
            }
            startingRow++;
            startingCol++;
            endingRow--;
            endingCol--;
        }
    }
    static void diagonalSum(int arr[][])
    {
        int sum = 0;
        for(int i=0; i<arr.length; i++)
        {
            for(int j=0; j<arr[0].length; j++)
            {
                if(i==j)
                sum+=arr[i][j];
                else if(i+j==arr.length-1)
                sum+= arr[i][j];
            }
        }
        System.out.println(sum);
    }
    static boolean staircaseSearch(int arr[][],int key)
    {
        int row = 0;
        int n = arr.length;
        int m = arr[0].length-1;

        while(row<n && m>=0)
        {
            if(arr[row][m]==key)
            {
                System.out.println("found at cell ("+row+","+m+")");
                return true;
            }
            else if(key<arr[row][m])
            {
                m--;
            }
            else
            {
                row++;
            }
        }
        System.out.println("Not found");
        return false;
    }
    public static void main(String args[])
    {
    //     int arr[][] = {
    //         {10,20,30,40},
    //         {15,25,35,45},
    //         {27,29,37,48},
    //         {32,33,39,50},
    //     };
    }
}