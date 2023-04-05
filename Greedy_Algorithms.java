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
	public static void main(String args[])
	{
		int startTime[] = {1,3,0,5,8,5};
		int endTime[] = {2,4,6,7,9,9};

		activitySelection(startTime,endTime);
	}
}