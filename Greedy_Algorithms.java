import java.util.*;
import java.util.Arrays;
public class Greedy_Algorithms
{
	static void activitySelection(int startTime[],int endTime[])
	{
		// ArrayList<Integer> ans = new ArrayList<>();
		// ans.add(0);
		// int maxActivity = 1;
		// int end = endTime[0];

		int activities[][] = new int[startTime.length][3];

		for(int i=0; i<activities.length; i++)
		{
				activities[i][0] = i;
				activities[i][1] = startTime[i];
				activities[i][2] = endTime[i];
		}

		Arrays.sort(activities,Comparator.comparingDouble(o -> o[2]));

		ArrayList<Integer> ans = new ArrayList<>();

		ans.add(activities[0][0]);
		int maxActivity = 1;
		int end = activities[0][2];
		for(int i=1; i<startTime.length; ++i)
		{
			if(end<=activities[i][1])
			{
				maxActivity++;
				end =activities[i][2];
				ans.add(activities[i][0]);
			}
		}

		System.out.println("Max activities  = "+maxActivity);
		System.out.println("Selected Acitivies are ");
		for(int i=0; i<ans.size(); ++i)
		{
			System.out.print("A"+ans.get(i)+" ");
		}
	}

	static void knapsack()
	{
		int weight[] = {10,20,30};
		int value[] = {60,100,120};
		int capcity = 50;
		int ratio[] = new int[weight.length];

		for(int i=0; i<ratio.length; i++)
		{
			ratio[i] = value[i]/weight[i];
		}

		int sack[][] = new int[weight.length][4];

		for(int i=0; i<weight.length; i++)
		{
			sack[i][0] = i;
			sack[i][1] = weight[i];
			sack[i][2] = value[i];
			sack[i][3] = ratio[i];
		}

		Arrays.sort(sack,Comparator.comparingDouble(o -> o[3]));
		int ans = 0;
		int W = capcity;
		for(int i=sack.length-1; i>=0; --i)
		{
			int cap = sack[i][1];

			if(cap<=W)
			{
				ans += sack[i][2];
				W -= cap;
			}
			else 
			{
				ans += W*sack[i][3];
				W = 0;
				break;
			}
		}
		System.out.println("max value = "+ans);
	}

	static void minAbsoluteDiffPairs()
	{
		int arr1[] = {4,1,8,7};
		int  arr2[] = {2,3,6,5};

		Arrays.sort(arr1);
		Arrays.sort(arr2);
		int minDiff = 0;
		for(int i=0; i<arr1.length; i++)
		{
			minDiff += Math.abs(arr1[i]-arr2[i]);
		}
		System.out.println("Min absolute diff = "+minDiff);
	}
	static void chainOfPairs()
	{
		int pairs[][] = {{5,24},{39,60},{5,28},{27,40},{50,90}};
		Arrays.sort(pairs,Comparator.comparingDouble(o->o[1]));

		int maxLength = 1;
		int chainEnd = pairs[0][1];
		for(int i=1; i<pairs.length; i++)
		{
			int chainStart = pairs[i][0];
			if(chainStart>=chainEnd)
			{
				chainEnd = pairs[i][1];
				maxLength++;
			}
		}

		System.out.println("Maximum length of the chain = "+maxLength);
	}

	static void indianCoins()
	{
		Integer coins[] = {2000,500,100,50,20,10,5,2,1};
		int amount = 590;
		// Arrays.sort(coins);

		Arrays.sort(coins,Comparator.reverseOrder());
		int maxCoins = 0;

		ArrayList<Integer> ans = new ArrayList<>();
		for(int i=0; i<coins.length; i++)
		{
			int coin = coins[i];
			if(coin<=amount)
			{
				while(coin<=amount)
				{
					amount -= coin;
					maxCoins++;
					ans.add(coin);
				}
			}
		}

		System.out.println("Max coins = "+maxCoins);

		System.out.println(ans);

	}

	static class Job
	{
		int id;
		int deadline;
		int profit;

		public Job(int id,int deadline,int profit)
		{
			this.id = id;
			this.deadline = deadline;
			this.profit = profit;
		}
	}
	static void jobSequencing()
	{
		int jobInfo[][] = {{4,20},{1,10},{1,40},{1,30}};

		ArrayList<Job> jobs = new ArrayList<>();

		for(int i=0; i<jobInfo.length; i++)
		{
			Job data = new Job(i,jobInfo[i][0],jobInfo[i][1]);
			jobs.add(data);
		}

		Collections.sort(jobs,(obj1,obj2) -> obj2.profit-obj1.profit);

		int time = 0;
		int mxJob = 0;
		ArrayList<Integer> seq = new ArrayList<>();
		for(int i=0; i<jobs.size(); i++)
		{
			Job data = jobs.get(i);

			if(data.deadline>time)
			{
				time++;
				mxJob++;
				seq.add(data.id);
			}
		}

		System.out.println("Max jobs = "+mxJob);
		System.out.println(seq);
	}

	static void chocolaProb()
	{
		int n =4,m = 3;
		Integer verCost[] = {2,1,3,1,4};
		Integer horCost[] = {4,1,2};

		int v = 0,h = 0,vp=1,hp = 1;

		Arrays.sort(verCost,Comparator.reverseOrder());
		Arrays.sort(horCost,Comparator.reverseOrder());
		int cost = 0;
		while(v<verCost.length && h<horCost.length)
		{
			if(verCost[v]>horCost[h])
			{
				cost += hp*verCost[v++];
				vp++;
			}
			else
			{
				cost +=  vp*horCost[h++];
				hp++;
			}
		}

		while(v<verCost.length)
		{
			cost += hp*verCost[v++];
			vp++;
		}
		while(h<horCost.length)
		{
			cost += vp*horCost[h++];
			hp++;
		}

		System.out.println("Minimum cost is = "+cost);
	}
	public static void main(String args[])
	{
		int startTime[] = {1,3,0,5,8,5};
		int endTime[] = {2,4,6,7,9,9};

		// activitySelection(startTime,endTime);

		// knapsack();
		// minAbsoluteDiffPairs();
		// chainOfPairs();
		// indianCoins();
		// jobSequencing();
		chocolaProb();
	}
}