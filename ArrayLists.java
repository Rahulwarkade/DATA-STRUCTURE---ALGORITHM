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
	public static void main(String args[])
	{
		multidimensional();
		// ArrayList<Integer> list = new ArrayList<>();
		// list.add(3);
		// list.add(2);
		// list.add(8);
		// list.add(7);
		// System.out.println(list);
		// Collections.sort(list);
		// System.out.println(list);
		// Collections.sort(list,Collections.reverseOrder());
		// System.out.println(list);
	}
}