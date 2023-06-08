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

	public static void printTable(int [][] tab)
	{
		for(int i=0; i<tab.length; i++)
		{
			for (int j=0; j<tab[0].length; j++) {
				System.out.print(tab[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void printTable(boolean [][] tab)
	{
		for(int i=0; i<tab.length; i++)
		{
			for (int j=0; j<tab[0].length; j++) {
				System.out.print(tab[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static int zeroOneKnapsackTab(int[] val,int[] wt,int W)
	{
		int n = val.length+1, m = W+1;
		int tb[][] = new int[n][m];

		for(int i=0; i<n; i++)
			for(int j=0; j<m; j++)
				tb[i][j] = (i==0 || j==0) ? 0 : 0;


		for(int item = 1; item<n; item++)
		{
			for(int weight = 1; weight<m; weight++)
			{
				if(wt[item-1]<=weight)
				{
					int ans1 = val[item-1] + tb[item-1][weight-wt[item-1]];
					int ans2 = tb[item-1][weight];

					tb[item][weight] = Math.max(ans1,ans2);
				}
				else 
				{
					tb[item][weight] = tb[item-1][weight];
				}
			}
		}
		printTable(tb);
		return tb[n-1][m-1];
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

		// System.out.println("maximum profit = "+zeroOneKnapsackRec(val,wt,W,0,val.length));// RECURSION
		// System.out.println("maximum profit = "+zeroOneKnapsackMem(val,wt,W,0,val.length,dp));// MEMOIZATION
		System.out.println("maximum profit = "+zeroOneKnapsackTab(val,wt,W));
	}

	public static boolean targetSum(int[] numbers,int target)
	{
		int n = numbers.length+1, m = target+1;

		boolean tb[][] = new boolean[n][m];

		for(int i=0; i<tb.length; i++)
		{
			tb[i][0] = true;
		}

		for(int item = 1; item<n; item++)
		{
			for(int tget = 1; tget<m; tget++)
			{
				if(numbers[item-1]<=tget && tb[item-1][tget-numbers[item-1]])
				{
					tb[item][tget] = true;
				}
				else if(tb[item-1][tget])
				{
					tb[item][tget] = true;
				}
			}
		}

		printTable(tb);
		return tb[n-1][m-1];
	}

	public static int unboundedKnapsackRec(int[] val,int[] wt,int W,int n)
	{
		if(n<0 || W==0) return 0;

		if(wt[n]<=W)//include
		{
			int included = val[n] + unboundedKnapsackRec(val,wt,W-wt[n],n);
			int unincluded = unboundedKnapsackRec(val,wt,W,n-1);
			return Math.max(included,unincluded);
		}
		else 
		{
			return unboundedKnapsackRec(val,wt,W,n-1);
		}

	}

	public static int unboundedKnapsackMem(int[] val,int[] wt,int W,int n,int[][] dp)
	{
		if(n<0 || W == 0) return 0;
		if(dp[n][W]!=-1) return dp[n][W];

		if(wt[n]<=W)
		{
			int included = val[n] + unboundedKnapsackMem(val,wt,W-wt[n],n,dp);
			int unincluded = unboundedKnapsackMem(val,wt,W,n-1,dp);
			dp[n][W] = Math.max(included,unincluded);
		}
		else
		{
			 dp[n][W] = unboundedKnapsackMem(val,wt,W,n-1,dp);
		}

		return dp[n][W];
	}


	public static int unboundedKnapsackTab(int[] val,int[] wt,int w,int n)
	{
		int[][] dp = new int[n+1][w+1];

		for(int i=1; i<=n; i++)
		{
			for(int j=1; j<=w; j++)
			{
				if(wt[i-1]<=j)
				{
					dp[i][j] = Math.max(dp[i-1][j],val[i-1] + dp[i][j-wt[i-1]]);
				}
				else 
				{
					dp[i][j] = dp[i-1][j];
				}
			}
		}

		return dp[n][w];
	}

	public static void unboundedKnapsack()
	{
		int[] val = {15,14,10,45,30};
		int[] wt = {2,5,1,3,4};
		int W = 7;
		int n = wt.length;
		int[][] dp = new int[n+1][W+1];

		for(int i=0; i<dp.length; i++)
		{
			Arrays.fill(dp[i],-1);
		}
		System.out.println(unboundedKnapsackRec(val,wt,W,wt.length-1));
		System.out.println(unboundedKnapsackMem(val,wt,W,n-1,dp));
		System.out.println("maximum profit = "+unboundedKnapsackTab(val,wt,W,n));
	}
	public static int coinChangeTab(int[] coins,int sum,int n,int[][] dp)
	{
		for(int i=1; i<=n; i++)
		{
			for(int j=1; j<=sum; j++)
			{
				if(coins[i-1]<=j)
				{
					dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j];
				}
				else 
				{
					dp[i][j] = dp[i-1][j];
				}
			}
		}

		return dp[n][sum];
	}
	public static void coinChange()
	{
		int coins[] = {2,5,3,6};
		int sum = 10;
		int n = coins.length;
		int dp[][] = new int[n+1][sum+1];
		for(int i=0; i<=n; i++)
		{
			dp[i][0] = 1;
		}
		System.out.println(coinChangeTab(coins,sum,n,dp));
	}

	public static int rodCuttingTab(int[] price,int[] length,int rodlegth,int n)
	{
		int[][] dp = new int[n+1][rodlegth+1];

		for(int i=1; i<=n; i++)
		{
			for(int j=1; j<=rodlegth; j++)
			{
				if(length[i-1]<=j)
				{
					dp[i][j] = Math.max(dp[i-1][j],price[i-1] + dp[i][j-length[i-1]]);
				}
				else 
				{
					dp[i][j] = dp[i-1][j];
				}
			}
		}

		return dp[n][rodlegth];
	}

	public static void rodCutting()
	{
		int[] price = {1,5,8,9,10,17,17,20};
		int[] length = {1,2,3,4,5,6,7,8};
		int rodlegth = 8;

		System.out.println(rodCuttingTab(price,length,rodlegth,price.length));
	}

	public static int lcsRec(String str1,String str2,int n,int m)
	{
		if(n<0||m<0) return 0;

		if(str1.charAt(n)==str2.charAt(m))
		{
			return lcsRec(str1,str2,n-1,m-1) + 1;
		}
		else 
		{
			int lcs1 = lcsRec(str1,str2,n-1,m);
			int lcs2 = lcsRec(str1,str2,n,m-1);
			return Math.max(lcs1,lcs2);
		}
	}

	public static int lcsMem(String str1,String str2,int n,int m,int[][] dp)
	{
		if(n<0||m<0) return 0;

		if(dp[n][m] != -1) return dp[n][m];
		if(str1.charAt(n)==str2.charAt(m))
		{
			dp[n][m] = lcsMem(str1,str2,n-1,m-1,dp) + 1;
		}
		else 
		{
			int lcs1 = lcsMem(str1,str2,n-1,m,dp);
			int lcs2 = lcsMem(str1,str2,n,m-1,dp);
			dp[n][m] = Math.max(lcs1,lcs2);
		}

		return dp[n][m];
	}

	public static int lcsTab(String str1,String str2,int n,int m)
	{
		int [][] dp = new int[n+1][m+1];

		for(int i=1; i<=n; i++)
		{
			for(int j=1; j<=m; j++)
			{
				if(str1.charAt(i-1)==str2.charAt(j-1))
				{
					dp[i][j] = dp[i-1][j-1] + 1;
				}
				else 
				{
					int lcs1 = dp[i-1][j];
					int lcs2 = dp[i][j-1];
					dp[i][j] = Math.max(lcs1,lcs2);
				}
			}
		}

		return dp[n][m];
	}
	public static void longestCommonSubsequence()
	{
		String str1 = "abcde", str2 = "ace";
		int n = str1.length();
		int m = str2.length();
		int[][] dp = new int[n][m];
		for(int i=0; i<n; i++)
		{
			Arrays.fill(dp[i],-1);
		}
		// System.out.println("lcs = "+lcsRec(str1,str2,n-1,m-1));
		// System.out.println("lcs = "+lcsMem(str1,str2,n-1,m-1,dp));
		System.out.println("lcs = "+lcsTab(str1,str2,n,m));
	}
	public static void main(String args[])
	{
		// int n;
		// Scanner jin = new Scanner(System.in);
		// n = jin.nextInt();
		// int dpfib[] = new int[n+1];
		// Arrays.fill(dpfib,-1);
		// dpfib[0] = 0;
		// dpfib[1] = 1;
		// // System.out.println(fibTabulation(n,dpfib));
		// // printDp(dpfib);

		// Arrays.fill(dpfib,-1);
		// dpfib[0] = 1;
		// dpfib[1] = 1;
		// System.out.println(countWays(2)); //RECURSION
		// System.out.println(countWays(5,dpfib)); //MEMOIZATION
		// printDp(dpfib);
		// countWaysTab(n);// TABULATION

		// zeroOneKnapsack();

		// int[] numbers = {4,2,7,1,3};
		// int target = 10;

		// System.out.println(targetSum(numbers,target));

		// unboundedKnapsack();
		// coinChange();
		// rodCutting();
		longestCommonSubsequence();
	}
}