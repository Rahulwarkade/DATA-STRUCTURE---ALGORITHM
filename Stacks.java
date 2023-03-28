import java.util.*;

class Stacks
{
	static class StackList
	{
		ArrayList<Integer> list = new ArrayList<>();

		boolean isEmpty()
		{
			return list.size() == 0;
		}

		void push(int data)
		{
			list.add(data);
		}

		int pop()
		{
			if(isEmpty())
				return -1;
			int top = list.get(list.size()-1);
			list.remove(list.size()-1);
			return top;
		}

		int peek()
		{
			if(isEmpty()) return -1;
			return list.get(list.size()-1);
		}
	}

	static class Node 
	{
		int data;
		Node next;

		Node(int data)
		{
			this.data = data;
			this.next = null;
		}
	}
	static class StackLL
	{
		Node head = null;
		boolean isEmpty()
		{
			if(head==null)
				return true;
			else return false;
		}

		void push(int data)
		{
			Node newNode = new Node(data);
			newNode.next = head;
			head = newNode;
		}

		int pop()
		{
			if(isEmpty()) return -1;
			int del = head.data;
			head = head.next;
			return del;
		}

		int peek()
		{
			if(isEmpty()) return -1;
			return head.data;
		}
	}
	static class StackJCFll
	{
		LinkedList<Integer> ll = new LinkedList<>();

		boolean isEmpty()
		{
			return ll.size() == 0;
		}

		void push(int data)
		{
			ll.addFirst(data);
		}

		int pop()
		{
			if(isEmpty()) return -1;
			return ll.removeFirst();
		}
		int peek()
		{
			if(isEmpty()) return -1;
			int top = ll.removeFirst();
			ll.addFirst(top);
			return top;
		}
	}

	static void pushAtBottom(Stack<Integer> s,int data)
	{
		if(s.isEmpty())
		{
			s.push(data);
			return;
		}
		int top = s.pop();
		pushAtBottom(s,data);
		s.push(top);
	}

	static String revers(String str)
	{
		Stack<Character> st = new Stack<>();

		for(int i=0; i<str.length(); i++)
		{
			st.push(str.charAt(i));
		}

		StringBuilder ans = new StringBuilder();
		while(!st.isEmpty())
		{
		 ans.append(st.pop());
		}

		return ans.toString();
	}

	static void reverStack(Stack<Integer> obj)
	{
		if(obj.isEmpty())
		{
			return ;	
		}
		int top = obj.pop();
		reverStack(obj);
		pushAtBottom(obj,top);
	}
	static void printStack(Stack<Integer> obj)
	{
		while(!obj.isEmpty())
		{
			System.out.println(obj.peek());
			obj.pop();
		}
		System.out.println();
	}

	static void stockSpan(int stocks[],int span[])
	{
		Stack<Integer> st = new Stack<>();
		span[0] = 1;
		st.push(0);

		for(int i=1; i<stocks.length; i++)
		{
			int currtPrice = stocks[i];

			while(!st.isEmpty() && currtPrice>=stocks[st.peek()])
			{
				st.pop();
			}

			if(st.isEmpty())
			{
				span[i] = i+1;
			}
			else 
			{
				int prevHigh = st.peek();
				span[i] = i-prevHigh;
			}
			st.push(i);
		}
	}

	static void nextGreaterEl(int arr[],int nge[])
	{
		Stack<Integer> s = new Stack<>();

		for(int i = arr.length-1; i>=0; i--)
		{
			int curr = arr[i];

			while(!s.isEmpty() && curr>=arr[s.peek()])
			{
				s.pop();
			}

			if(s.isEmpty())
			{
				nge[i] = -1;
			}
			else  
			{
				nge[i] = arr[s.peek()];
			}
			s.push(i);
		}
	}

	static boolean vailidPar(String str)
	{
		Stack<Character> st = new Stack<>();
		for(int i=0; i<str.length(); i++)
		{
			char ch = str.charAt(i);
			if(ch=='{' || ch=='[' || ch=='(')
			{
				st.push(ch);
			}
			else 
			{
				if(st.isEmpty()) return false;

				if(ch==')' && st.peek()=='(' ||
				   ch=='}' && st.peek()=='{' ||
				   ch==']' && st.peek()=='[' )
				{
					st.pop();
				}
				else return false;
			}
		}
		if(st.isEmpty()) return true;
		return false;
	}
	public static void main(String args[])
	{
	// Stack implimentation using ArrayList
		// StackList sc = new StackList();
	// using LinkedList
		//StackLL sc = new StackLL();

	// using JCF LinkedList
		// StackJCFll sc = new StackJCFll();

	// inbuilt Stack usign JCF

	    // Stack<Integer> sc = new Stack<>();
		// sc.push(2);
		// sc.push(3);
		// sc.push(7);
		// sc.push(5);

		// pushAtBottom(sc,8);
		// printStack(sc);
		// reverStack(sc);
		// printStack(sc);

		// System.out.println(revers("Rahul"));

		// int stocks[] = {100,80,60,70,60,85,100};

		// int span[] = new int[stocks.length];

		// stockSpan(stocks,span);

		// for(int i=0; i<stocks.length; i++)
		// {
		// 	System.out.println("span of day "+(i)+" = "+ span[i]);
		// }

		// int arr[] = {6,8,0,1,3};
		// int nge[] = new int[arr.length];

		// nextGreaterEl(arr,nge);
		// for(int i=0; i<nge.length; i++)
		// 	System.out.println(arr[i]+" nge = "+nge[i]);

		String str = "({[]}())";
		if(vailidPar(str))
			System.out.println("Vailid parentheses");
		else 
			System.out.println("invailid parentheses");
	}
}