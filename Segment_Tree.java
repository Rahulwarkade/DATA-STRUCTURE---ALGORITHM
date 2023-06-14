import java.util.*;

class Segment_Tree
{

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
	public static void segmentTree(int[] arr,int n)
	{
		int st[] = new int[4*n];

		buildST(arr,st,0,0,n-1);

		for(int i=0; i<n*2; i++)
		{
			System.out.print(st[i]+" ");
		}
	}
	public static void main(String agrs[])
	{
		int arr[] = {1,2,3,4,5,6,7,8};
		int n = arr.length;

		segmentTree(arr,n);
	}
}