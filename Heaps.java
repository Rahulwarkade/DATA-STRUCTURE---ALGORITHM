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

	public static void heapify(int arr[],int idx,int sz)
	{
		int left = (idx*2)+1;
		int right = (idx*2)+2;
		int maxIdx = idx;

		if(left<sz && arr[maxIdx]<arr[left])
		{
			maxIdx = left;
		}
		if(right<sz && arr[maxIdx]<arr[right])
		{
			maxIdx = right;
		}

		if(maxIdx!=idx)
		{
			int temp = arr[idx];
			arr[idx] = arr[maxIdx];
			arr[maxIdx] = temp;

			heapify(arr,maxIdx,sz);
		}
	}

	public static void heapify2(int arr[],int idx,int sz)
	{
		int left = (idx*2)+1;
		int right = (idx*2)+2;
		int minIdx = idx;

		if(left<sz && arr[minIdx]>arr[left])
		{
			minIdx = left;
		}
		if(right<sz && arr[minIdx]>arr[right])
		{
			minIdx = right;
		}

		if(minIdx!=idx)
		{
			int temp = arr[idx];
			arr[idx] = arr[minIdx];
			arr[minIdx] = temp;

			heapify(arr,minIdx,sz);
		}
	}

	public static void heapSort(int arr[])
	{
		int n = arr.length;

		//making Max heap
		for(int i=n/2; i>=0; i--)
		{
			heapify2(arr,i,n);
		}

		for(int i = n-1; i>=0; i--)
		{
			int temp = arr[i];
			arr[i] = arr[0];
			arr[0] = temp;

			heapify2(arr,0,i);
		}

	}

	public static class Points implements Comparable<Points>
	{
		int minDist;
		int idx;
		Points(int minDist,int idx)
		{
			this.minDist = minDist;
			this.idx = idx;
		}

		@Override
		public int compareTo(Points obj2)
		{
			return this.minDist - obj2.minDist;
		}
	}

	public static class Soldier implements Comparable<Soldier>
	{
		int solcount;
		int idx;

		Soldier(int solcount,int idx)
		{
			this.solcount = solcount;
			this.idx = idx;
		}

		@Override
		public int compareTo(Soldier row2)
		{
			if(this.solcount==row2.solcount)
			{
				return this.idx-row2.idx;
			}
			return this.solcount - row2.solcount;
		}
	}

	public static class Pair implements Comparable<Pair>
	{
		int value;
		int idx;

		Pair(int value,int idx)
		{
			this.value = value;
			this.idx = idx;
		}

		@Override
		public int compareTo(Pair to)
		{
			return to.value - this.value;
		}
	}
	public static void main(String args[])
	{
		PriorityQueue<Integer> pq = new PriorityQueue<>();

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

		// int[] arr = {1,2,4,5,3};

		// heapSort(arr);

		// for(int i=0; i<arr.length; i++)
		// {
		// 	System.out.print(arr[i]+" ");
		// }
		// System.out.println();

		// int cordinates[][] = {{3,3},{5,-1},{-2,4}};
		// int k = 2;
		// PriorityQueue<Points> p = new PriorityQueue<>();
		// for(int i=0; i<cordinates.length; i++)
		// {
		// 	int dist = cordinates[i][0]*cordinates[i][0] +cordinates[i][1]*cordinates[i][1];
		// 	p.add(new Points(dist,i));
		// }

		// for(int i=0; i<k; i++)
		// {
		// 	System.out.println("C"+p.remove().idx);
		// }

		// int ropes[] = {4,3,3,2,6};
		// PriorityQueue<Integer> rop = new PriorityQueue<>();

		// for(int i=0; i<ropes.length; i++)
		// {
		// 	rop.add(ropes[i]);
		// }

		// int ans = 0;

		// for(int i=0; i<ropes.length-1; i++)
		// {
		// 	int num1 = rop.remove();
		// 	int num2 = rop.remove();
		// 	ans += num1+num2;
		// 	rop.add(num1+num2);
		// }
		// System.out.println(ans);

		// int soldier[][] = {{1,0,0,0},{1,1,1,1},{1,0,0,0},{1,0,0,0}};
		// PriorityQueue<Soldier> so = new PriorityQueue<>();
		// int k2 = 2;
		// for(int i=0; i<soldier.length; i++)
		// {
		// 	int solcount = 0;
		// 	for(int j=0; j<soldier[i].length; j++)
		// 	{
		// 		solcount += soldier[i][j]==1 ? 1 : 0;
		// 	}

		// 	so.add(new Soldier(solcount,i));
		// }

		// for(int i=0; i<k2; i++)
		// {
		// 	System.out.println("row"+so.remove().idx);
		// }

		int arrWindow[] = {1,3,-1,-3,5,3,6,7};
		int k = 3;
		int n = arrWindow.length;
		PriorityQueue<Pair> p = new PriorityQueue<>();

		for(int i=0; i<k; i++)
		{
			p.add(new Pair(arrWindow[i],i));
		}

		int res[] = new int[n-k+1];

		res[0] = p.peek().value;

		for(int i=k; i<n; i++)
		{
			while(p.size()>0 && p.peek().idx<=(i-k))
			{
				p.remove();
			}
			p.add(new Pair(arrWindow[i],i));
			res[i-k+1] = p.peek().value;
		}

		for(int i=0; i<res.length; i++)
		{
			System.out.print(res[i]+" ");
		}
		System.out.println();
	}
}