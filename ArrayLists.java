import java.util.ArrayList;
import java.util.Collections;

public class ArrayLists
{
	static void operations()
	{
		ArrayList<Integer> lis = new ArrayList<>();

		//Adding element to array list = O(1)
		lis.add(2);//O(1)
		lis.add(3);
		lis.add(54);
		lis.add(98);
		//Accessing element in array list = O(1)
		int elm = lis.get(2);
		System.out.println(lis);
		System.out.println(elm);

		//Removing element in array list = O(N)
		lis.remove(1);
		System.out.println(lis);

		//set element = O(n)
		lis.set(2,24);
		System.out.println(lis);

		//contains an element = O(n)
		System.out.println(lis.contains(2));
	}
	static void reverseList(ArrayList<Integer> list)
	{
		for(int i=list.size()-1; i>=0; i--)
			System.out.print(list.get(i)+" ");
	}
	static void findMax(ArrayList<Integer> list)
	{
		Integer max = Integer.MIN_VALUE;
		for(int i=0; i<list.size(); i++)
		{
			if(list.get(i)>max)
				max = list.get(i);
		}
		System.out.println(max);
	}
	static void swaping(ArrayList<Integer> list,int i,int j)
	{
		Integer temp = list.get(j);
		list.set(j,list.get(i));
		list.set(i,temp);
	}
	static void multidimensional()
	{
		ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();

		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();
		ArrayList<Integer> list3 = new ArrayList<>();

		for(int i=1; i<=5; i++)
		{
			list.add(i*1);
			list2.add(i*2);
			list3.add(i*3);
		}
		mainList.add(list);
		mainList.add(list2);
		mainList.add(list3);

		System.out.println(mainList);

		for(int i=0; i<mainList.size(); i++)
		{
			ArrayList<Integer> currList = mainList.get(i);
			for(int j=0; j<currList.size(); j++)
			{
				System.out.print(currList.get(j)+" ");
			}
			System.out.println();
		}
	}
//Brute Force Approach
	public static int maxStoreWater(ArrayList<Integer> height)
	{
		int maxWater = 0;

		for(int i=0; i<height.size(); i++)
		{
			for(int j=i+1; j<height.size(); j++)
			{
				int level = Math.min(height.get(i),height.get(j));
				int width = j-i;
				int water = level * width;
				maxWater = Math.max(maxWater,water);
			}
		}
		return maxWater;
	}

//Optimized Approach two pointer approach

	public static int storeWater(ArrayList<Integer> height)
	{
		int maxWater = 0;
		int lp = 0,rp = height.size()-1;
		while(lp<rp)
		{
			int level = Math.min(height.get(lp),height.get(rp));
			int width = rp-lp;
			int water = level * width;
			maxWater = Math.max(maxWater,water);
			if(height.get(lp)<height.get(rp)) lp++;
			else rp--;
		}

		return maxWater;
	}

	public static int pairSum(ArrayList<Integer> height,int target)
	{
		int lp = 0;
		int rp = 0;
		int n = height.size();
		for(int i=0; i<n-1; i++)
		{
			if(height.get(i)>height.get(i+1))
			{
				lp = i+1;
				rp = i;
				break;
			}
		}

		while(lp!=rp)
		{
			if(height.get(lp)+height.get(rp)==target)
				return target;
			else if(height.get(lp)+height.get(rp)<target)
				lp = (lp+1)%n;
			else rp = (n+rp-1)%n;
		}
		return -1;
	}
	public static void main(String args[])
	{
		ArrayList<Integer> height = new ArrayList<>();
		int target = 16;
		height.add(11);
		height.add(15);
		height.add(6);
		height.add(8);
		height.add(9);
		height.add(10);

		System.out.println(pairSum(height,target));
	}
}