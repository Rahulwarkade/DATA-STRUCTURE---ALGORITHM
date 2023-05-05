import java.util.*;
import java.util.Arrays;

public class DynamicProgramming
{

	public static int fib(int n,int[] dp)
	{
		if(n==1 || n== 0) return n;
		if(dp[n]!=-1)
			return dp[n];
		dp[n] = fib(n-1,dp) + fib(n-2,dp);
		return dp[n];
	}
	public static void printDp(int[] dp)
	{
		for(int i=0; i<dp.length; ++i)
			System.out.print(dp[i]+" ");
		System.out.println();
	}

	public static int countWays(int n,int[] dp)
	{
		if(n==1 || n==0) return 1;
		if(dp[n]!=-1) return dp[n];
		dp[n] = countWays(n-1,dp) + countWays(n-2,dp);
		return dp[n];
	}
	public static int fibTabulation(int n,int[] dp)
	{
		dp[0] = 0;
		dp[1] = 1;

		for(int i=2; i<=n; i++)
		{
			dp[i] = dp[i-1] + dp[i-2];
		}

		return dp[n];
	}
	public static void main(String args[])
	{
		int n;
		Scanner jin = new Scanner(System.in);
		n = jin.nextInt();
		int dpfib[] = new int[n+1];
		Arrays.fill(dpfib,-1);
		dpfib[0] = 0;
		dpfib[1] = 1;
		System.out.println(fibTabulation(n,dpfib));
		printDp(dpfib);

		Arrays.fill(dpfib,-1);
		dpfib[0] = 1;
		dpfib[1] = 1;
		// System.out.println(countWays(2)); //RECURSION
		System.out.println(countWays(5,dpfib)); //MEMOIZATION
		printDp(dpfib);
	}
}