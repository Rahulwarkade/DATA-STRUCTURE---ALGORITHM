import java.util.*;

public class Heaps
{
	public static class Students implements Comparable<Students>
	{
		String name;
		int rank;

		Students(String name,int rank)
		{
			this.name = name;
			this.rank = rank;
		}

		@Override
		public int compareTo(Students s2)
		{
			return this.rank -s2.rank;
		}
	}
	public static void main(String args[])
	{
		// PriorityQueue<Integer> pq = new PriorityQueue<>();

		PriorityQueue<Students> pq1 = new PriorityQueue<>(Comparator.reverseOrder());
		pq1.add(new Students("A",12));
		pq1.add(new Students("B",1));
		pq1.add(new Students("C",9));
		pq1.add(new Students("D",2));

		while(!pq1.isEmpty())
		{
			System.out.println(pq1.peek().name+" rank = "+pq1.peek().rank);
			pq1.remove();
		}
	}
}