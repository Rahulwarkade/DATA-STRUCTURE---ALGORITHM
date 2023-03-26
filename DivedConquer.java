import java.util.*;

class DivedConquer
{
	public static void printArr(int arr[])
	{
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
	void merge(int arr[],int si,int mid,int ei)
	{
		int temp[] = new int[ei-si+1];
		int i = si;
		int j = mid+1;
		int k = 0;

		while(i<=mid && j<=ei)
		{
			if(arr[i]<arr[j])
				temp[k++] = arr[i++];
			else 
				temp[k++] = arr[j++];
		}

		while(i<=mid)
		{
			temp[k++] = arr[i++];
		}
		while(j<=ei)
		{
			temp[k++] = arr[j++];
		}

		for(int t=si,r=0; r<temp.length; r++,t++)
		{
			arr[t] = temp[r];
		}
	}
	void mergeSort(int arr[],int si,int ei)
	{
		if(si>=ei)
			return;
		int mid = si+(ei-si)/2;
		mergeSort(arr,si,mid);
		mergeSort(arr,mid+1,ei);
		merge(arr,si,mid,ei);
	}

	int partition(int arr[],int si,int ei)
	{
		int pivot = arr[ei];
		int i = si -1;

		for(int j= si; j<ei; j++)
		{
			if(arr[j]<=pivot)
			{
				i++;
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		i++;
		int temp = arr[ei];
		arr[ei] = arr[i];
		arr[i] = pivot;

		return i;
	}

	void quickSort(int arr[],int si,int ei)
	{
		if(si>=ei) return;
		int idx = partition(arr,si,ei);
		quickSort(arr,si,idx-1);
		quickSort(arr,idx+1,ei);
	}

	int searchSortRoted(int arr[],int key)
	{
		int si = 0;
		int ei = arr.length-1;

		while(si<=ei)
		{
			int mid = si+((ei-si)>>1);

			if(arr[mid]==key){
				return mid;
			}
			else if(arr[mid]<=arr[ei])
			{
				if(arr[mid]<key && key<=arr[ei])
					si = mid+1;
				else
					ei = mid - 1;
			}
			else 
			{
				if(arr[mid]>key && key>=arr[si])
					ei = mid-1;
				else 
					si = mid+1;
			}
		}
		return -1;
	}
	public static void main(String args[])
	{
		DivedConquer obj = new DivedConquer();
		int arr[] = {4,5,6,7,0,1,2};
		System.out.println(obj.searchSortRoted(arr,0));
	}
}