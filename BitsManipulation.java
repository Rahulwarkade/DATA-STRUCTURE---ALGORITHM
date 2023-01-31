import java.util.*;

public class BitsManipulation
{
	static int binaryAnd(int a,int b)
	{
		return a&b;
	}
	static int binaryOr(int a,int b)
	{
		return a|b;
	}
	static int binaryXor(int a,int b)
	{
		return a^b;
	}
	static int binaryOnesComplement(int a)
	{
		return ~a;
	}
	static int binaryLeftShift(int num ,int pos)
	{
		return num<<pos;
	}
	static int binaryRightShift(int num,int pos)
	{
		return num>>pos;
	}
	static String checkOddEven(int num)
	{
		return ((num&1)==0)?"Even":"Odd";
	}
	static int getIthBit(int n,int i)
	{
		int bitMask = 1<<i;

		return ((n&bitMask)!=0)?1:0;
	}
	static int setIthBit(int n,int i)
	{
		int bitMask = (1<<i);
		n |= bitMask;

		return n;
	}
	static int clearIthBit(int n,int i)
	{
		int bitMask = ~(1<<i);
		return (n&bitMask);
	}
	static int updateIthBit(int n,int i,int newBit)
	{
		// if(newBit!=0)
		// 	n = setIthBit(n,i);
		// else
		// 	n = clearIthBit(n,i);
		// return n;

		n = clearIthBit(n,i);
		int bitMask = newBit<<i;
		return (n|bitMask);
	}
	static int clearLastIbit(int n,int i)
	{
		int bitMask = (-1)<<i;
		return (n&bitMask);
	}
	static int clearBitInRange(int n,int i,int j)
	{
		int a = (-1)<<(j+1);
		int b = (1<<i) -1;
		int bitMask = a|b;
		return (n&bitMask);
	}
	static String isPowerOfTwo(int n)
	{
		return ((n&(n-1))==0)?"Power of Two":"Not a power of Two";
	}
	static int numberOfSetBits(int n)
	{
		int count = 0;
		while(n>0){
			if((n&1)!=0)
				count++;
			n >>= 1;
		}
		return count;
	}
	static int fastExpo(int a,int n)
	{
		int ans = 1; 

		while(n>0)
		{
			if((n&1)!=0)
				ans *= a;
			a *= a;
			n >>= 1;
		}

		return ans;
	}
	public static void main(String args[])
	{
		int a,b;
		Scanner jin = new Scanner(System.in);
		a = jin.nextInt();
		b = jin.nextInt();
		System.out.println(fastExpo(5,3));
	}
}