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

	public static void buildST2(int[] arr,int i,int si,int sj)
	{
		if(si==sj)
		{
			st[i] = arr[si];
			return;
		}

		int mid = si+(sj-si)/2;
		buildST2(arr,2*i+1,si,mid);
		buildST2(arr,2*i+2,mid+1,sj);

		st[i] = Math.max(st[2*i+1],st[2*i+2]);
	}
	public static void buildST3(int[] arr,int i,int si,int sj)
	{
		if(si==sj)
		{
			st[i] = arr[si];
			return;
		}

		int mid = si+(sj-si)/2;
		buildST2(arr,2*i+1,si,mid);
		buildST2(arr,2*i+2,mid+1,sj);

		st[i] = Math.min(st[2*i+1],st[2*i+2]);
	}

	public static int getMaxUtil(int i,int si,int sj,int qi,int qj)
	{
		if(qi>sj || qj<si)
		{
			return Integer.MIN_VALUE;
		}
		else if(qi<=si && sj<=qj)
		{
			return st[i];
		}
		else 
		{
			int mid = si + (sj-si)/2;

			int leftmax = getMaxUtil(2*i+1,si,mid,qi,qj);
			int rightmax = getMaxUtil(2*i+2,mid+1,sj,qi,qj);

			return Math.max(leftmax,rightmax);
		}
	}
	public static void getMax(int[] arr,int qi,int qj)
	{
		int n = arr.length;

		System.out.println(getMaxUtil(0,0,n-1,qi,qj));
	}

	public static int getMinUtil(int i,int si,int sj,int qi,int qj)
	{
		if(qi>sj || qj<si)
		{
			return Integer.MAX_VALUE;
		}
		else if(qi<=si && sj<=qj)
		{
			return st[i];
		}
		else 
		{
			int mid = si + (sj-si)/2;

			int leftmax = getMinUtil(2*i+1,si,mid,qi,qj);
			int rightmax = getMinUtil(2*i+2,mid+1,sj,qi,qj);

			return Math.min(leftmax,rightmax);
		}
	}
	public static void getMin(int[] arr,int qi,int qj)
	{
		int n = arr.length;

		System.out.println(getMinUtil(0,0,n-1,qi,qj));
	}

	public static void updateMaxUtil(int i,int si,int sj,int idx,int newValue)
	{
		if(idx<si || idx>sj)
		{
			return;
		}
		else if(si==sj)
		{
			st[i] = newValue;
		}
		else if(si!=sj)
		{	
			st[i] = Math.max(st[i],newValue);
			int mid = si+(sj-si)/2;
			updateMaxUtil(2*i+1,si,mid,idx,newValue);
			updateMaxUtil(2*i+2,mid+1,sj,idx,newValue);
		}
	}
	public static void updateMax(int[] arr,int idx,int value)
	{
		int n = arr.length;
		arr[idx] = value;

		updateMaxUtil(0,0,n-1,idx,value);
	}
	public static void updateMinUtil(int i,int si,int sj,int idx,int newValue)
	{
		if(idx<si || idx>sj)
		{
			return;
		}
		else if(si==sj)
		{
			st[i] = newValue;
		}
		else if(si!=sj)
		{	
			st[i] = Math.min(st[i],newValue);
			int mid = si+(sj-si)/2;
			updateMinUtil(2*i+1,si,mid,idx,newValue);
			updateMinUtil(2*i+2,mid+1,sj,idx,newValue);
		}
	}
	public static void updateMin(int[] arr,int idx,int value)
	{
		int n = arr.length;
		arr[idx] = value;

		updateMinUtil(0,0,n-1,idx,value);
	}
	public static void segmentTree(int[] arr,int n)
	{
		init(n);
		// buildST(arr,st,0,0,n-1);

		buildST3(arr,0,0,n-1);

		// getMax(arr,2,5);
		// updateMax(arr,2,20);
		// getMax(arr,2,5);	

		getMin(arr,2,5);
		updateMin(arr,2,20);
		getMin(arr,2,5);

		// System.out.println(getSum(arr,2,5));
		// update(arr,2,2);
		// System.out.println(getSum(arr,2,5));
	}
	public static void main(String agrs[])
	{
		// int arr[] = {1,2,3,4,5,6,7,8};
		int arr[] = {6,8,-1,2,17,1,3,2,4};
		int n = arr.length;

		segmentTree(arr,n);
	}
}