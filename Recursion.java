
public class Recursion
{
	int arr[] = new int[26];
	void decreasingOrder(int n)
	{	if(n==-1)
		{
			return;
		}
		System.out.print(n+" ");
		decreasingOrder(n-1);
	}
	void increasingOrder(int n)
	{
		if(n==-1) return;
		increasingOrder(n-1);
		System.out.print(n+" ");
	}

	int factorial(int n)
	{
		if(n==1|| n==0)return 1;
		return n*factorial(n-1);
	}
	int sumOfNnum(int n)
	{
		if(n==1)return 1;
		return n + sumOfNnum(n-1);
	}
	int fibonacci(int n)
	{
		if(n==0 || n==1) return n;
		return fibonacci(n-1) + fibonacci(n-2);
	}

	boolean isSorted(int arr[],int i)
	{
		if(i==arr.length-1) return true;
		if(arr[i]>arr[i+1]) return false;
		return isSorted(arr,i+1);
	}
	int firstOcc(int arr[],int i,int key)
	{
		if(i==arr.length) return -1;
		if(arr[i]==key) return i;
		return firstOcc(arr,i+1,key);
	}
	int lastOcc(int arr[],int i,int key)
	{	int idx;
		if(i==arr.length) return -1;
		idx = lastOcc(arr,i+1,key);
		if(idx==-1 && arr[i]==key)
			return i;
		return idx;
	}

	int powOfX(int x,int n)
	{
		if(n==1) return x;
		return x*powOfX(x,n-1);
	}
	int powOfXOpt(int x,int n)
	{
		int ans =1;
		// if(n==1) return x;
		if(n==0) return 1;
		int nbyt = powOfXOpt(x,n/2);
		ans = nbyt*nbyt;
		if(n%2!=0)
			ans *= x;
		return ans;
	}
	int tillingPro(int n)
	{
		if(n==0 || n==1) return 1;
		return tillingPro(n-1)+tillingPro(n-2);
	}

	String removeDuplicates(String str,int idx,StringBuilder ans)
	{
		if(idx==str.length())
			return ans.toString();
		if(arr[str.charAt(idx)-'a']==0){
			ans.append(str.charAt(idx));
			arr[str.charAt(idx)-'a'] = 1;
		}

		return removeDuplicates(str,idx+1,ans);
	}

	int friendsPairing(int n)
	{
		if(n==1 || n==2) return n;
		return friendsPairing(n-1) + (n-1)*friendsPairing(n-2);
	}

	void binaryString(int n,int lastplace,String str)
	{
		if(n==0)
		{
			System.out.println(str);
			return;
		}
		binaryString(n-1,0,str+"0");
		if(lastplace==0)
			binaryString(n-1,1,str+"1");
	}
	public static void main(String args[])
	{
		Recursion ob = new Recursion();
		ob.decreasingOrder(10);
		// ob.increasingOrder(10);
		System.out.println(ob.factorial(5));
		System.out.println(ob.sumOfNnum(10));
		System.out.println(ob.fibonacci(6));
		int arr[] = {8,3,6,9,5,10,3,5,3};
		// System.out.println(ob.isSorted(arr,0));
		System.out.println(ob.firstOcc(arr,0,5));
		// System.out.println(ob.lastOcc(arr,0,5));
		// System.out.println(ob.tillingPro(3));
		// StringBuilder ans = new StringBuilder();
		// System.out.println(ob.removeDuplicates("appnnacollage",0,ans));
		// System.out.println(ob.friendsPairing(4));
		ob.binaryString(3,0,"");
	}
}