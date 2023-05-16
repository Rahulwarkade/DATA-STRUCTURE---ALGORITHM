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
	public static int countWaysTab(int n)
	{
		int[] dp = new int[n+1];
		dp[0] = 1;

		for(int i=1; i<=n; ++i)
		{
			if(i==1) dp[i] = dp[i-1];
			else dp[i] = dp[i-1]+dp[i-2];
		}
		printDp(dp);
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


	public static int zeroOneKnapsackRec(int[] val, int[] wt,int W,int idx,int n)
	{
		if(W==0 || idx == n) return 0;

		if(wt[idx]<=W)
		{
			int ans1 = val[idx] + zeroOneKnapsackRec(val,wt,W-wt[idx],idx+1,n);
			int ans2 = zeroOneKnapsackRec(val,wt,W,idx+1,n);

			return Math.max(ans1,ans2);
		}
		else 
		{
			return zeroOneKnapsackRec(val,wt,W,idx+1,n);
		}
	}

	public static int zeroOneKnapsackMem(int[] val,int[] wt,int W,int idx,int n,int[][] dp)
	{
		if(W==0 || idx== n) return 0;

		if(dp[idx][W]!=-1) return dp[idx][W];

		if(wt[idx]<=W)
		{
			int ans1 = val[idx] + zeroOneKnapsackMem(val,wt,W-wt[idx],idx+1,n,dp);
			int ans2 = zeroOneKnapsackMem(val,wt,W,idx+1,n,dp);
			dp[idx][W] = Math.max(ans1,ans2);

			return dp[idx][W];
		}

		else 
		{
			return dp[idx][W] = zeroOneKnapsackMem(val,wt,W,idx+1,n,dp);
		}
	}
	public static void zeroOneKnapsack()
	{
		int[] val = {15,14,10,45,30};
		int[] wt = {2,5,1,3,4};
		int W = 7;
		int[][] dp = new int[val.length+1][W+1];

		for(int i=0; i<val.length; i++)
		{
			Arrays.fill(dp[i],-1);
		}

		// System.out.println("maximum profit = "+zeroOneKnapsackRec(val,wt,W,0,val.length));
		System.out.println("maximum profit = "+zeroOneKnapsackMem(val,wt,W,0,val.length,dp));
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
		// printDp(dpfib);

		Arrays.fill(dpfib,-1);
		dpfib[0] = 1;
		dpfib[1] = 1;
		// System.out.println(countWays(2)); //RECURSION
		// System.out.println(countWays(5,dpfib)); //MEMOIZATION
		// printDp(dpfib);
		// countWaysTab(n);// TABULATION

		zeroOneKnapsack();
	}
}