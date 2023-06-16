import java.util.*;

class Segment_Tree
{ 
	public static int st[];

	public static void init(int n)
	{
		st = new int[4*n];
	}
	public static void buildST(int[] arr,int[] st,int i,int start,int end)
	{
		if(start==end)
		{
			st[i] = arr[start];
			return;
		}
		int mid = (start+((end-start)>>1));
		buildST(arr,st,2*i+1,start,mid);
		buildST(arr,st,2*i+2,mid+1,end);

		st[i] = st[2*i+1] + st[2*i+2];
	}

	public static int getSumUtil(int[] arr,int i,int si,int sj,int qi,int qj)
	{
		if(qi>=sj || qj<=si)// non overlayping
		{
			return 0;
		}
		else if (si>=qi && qj>=sj)// completly overlayping
		{
			return st[i];
		}
		else // partially overlayping
		{
			int mid = (si+((sj-si)>>1));

			int left = getSumUtil(arr,2*i+1,si,mid,qi,qj);
			int right = getSumUtil(arr,2*i+2,mid+1,sj,qi,qj);

			return left + right;
		}
	}
	public static int getSum(int[] arr,int qi,int qj)
	{
		int n = arr.length;
		return getSumUtil(arr,0,0,n-1,qi,qj);
	}

	public static void updateUtil(int i,int si,int sj,int idx,int diff)
	{
		if(idx<si || idx>sj)
		{
			return;
		}

		st[i] += diff;

		if(si!=sj)
		{
			int mid = si+((sj-si)>>1);

			updateUtil(2*i+1,si,mid,idx,diff);
			updateUtil(2*i+2,mid+1,sj,idx,diff);
		}
	}
	public static void update(int[] arr,int idx , int newValue)
	{
		int diff = newValue - arr[idx];
		arr[idx] = newValue;
		int n = arr.length;
		updateUtil(0,0,n-1,idx,diff);
	}
	public static void segmentTree(int[] arr,int n)
	{
		init(n);
		buildST(arr,st,0,0,n-1);

		// for(int i=0; i<n*2; i++)
		// {
		// 	System.out.print(st[i]+" ");
		// }

		System.out.println(getSum(arr,2,5));
		update(arr,2,2);
		System.out.println(getSum(arr,2,5));
	}
	public static void main(String agrs[])
	{
		int arr[] = {1,2,3,4,5,6,7,8};
		int n = arr.length;

		segmentTree(arr,n);
	}
}