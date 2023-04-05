import java.util.*;
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

		// Arrays.sort(activities,Comparator.comparingDouble(o -> o[2]));

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
		int value[] = {60,100,20};
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
		for(int i=0; i<sack.length; i++)
		{
			int cap = sack[i][1];

			if(cap<=capcity)
			{
				ans += cap*sack[i][2];
				capcity -= cap;
			}
			else 
			{
				ans += capcity*sack[i][2];
			}

			System.out.println(ans);
		}

	}
	public static void main(String args[])
	{
		// int startTime[] = {1,3,0,5,8,5};
		// int endTime[] = {2,4,6,7,9,9};

		// activitySelection(startTime,endTime);

		knapsack();

	}
}