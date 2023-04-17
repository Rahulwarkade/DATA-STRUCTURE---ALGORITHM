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

	public static class Heap
	{
		ArrayList<Integer> arr = new ArrayList<>();
		void add(int data)
		{
			arr.add(data);

			int child = arr.size()-1;
			int parent = (child-1)/2;

			while(arr.get(parent)>arr.get(child))
			{
				int temp = arr.get(parent);
				arr.set(parent,arr.get(child));
				arr.set(child,temp);

				child = parent;
				parent = (child-1)/2;
			}
		}

		boolean isEmpty()
		{
			return arr.size() == 0;
		}

		int peek()
		{
			if(isEmpty()) return -1;
			return arr.get(0);
		}

		private void heapify(int idx)
		{
			int left = 2*idx+1;
			int right = 2*idx+2;
			int minIdx = idx;

			if(left<arr.size() && arr.get(minIdx)>arr.get(left))
			{
				minIdx = left;
			}
			if(right<arr.size() && arr.get(minIdx)>arr.get(right))
			{
				minIdx = right;
			}

			if(minIdx!=idx)
			{
				int temp = arr.get(idx);
				arr.set(idx,arr.get(minIdx));
				arr.set(minIdx,temp);

				heapify(minIdx);
			}
		}

		int remove()
		{
			int data = arr.get(0);

			//swaping 
			int temp = arr.get(0);
			arr.set(0,arr.get(arr.size()-1));
			arr.set(arr.size()-1,temp);

			//remove last element
			arr.remove(arr.size()-1);

			heapify(0);

			return data;
		}
	}
	public static void main(String args[])
	{
		// PriorityQueue<Integer> pq = new PriorityQueue<>();

		// PriorityQueue<Students> pq1 = new PriorityQueue<>(Comparator.reverseOrder());
	// 	pq1.add(new Students("A",12));
	// 	pq1.add(new Students("B",1));
	// 	pq1.add(new Students("C",9));
	// 	pq1.add(new Students("D",2));

	// 	while(!pq1.isEmpty())
	// 	{
	// 		System.out.println(pq1.peek().name+" rank = "+pq1.peek().rank);
	// 		pq1.remove();
	// 	}

		Heap hp = new Heap();

		hp.add(3);
		hp.add(4);
		hp.add(1);
		hp.add(5);

		while(!hp.isEmpty())
		{
			System.out.println(hp.peek());
			hp.remove();
		}
	}
}