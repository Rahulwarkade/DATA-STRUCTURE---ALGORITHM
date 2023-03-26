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
	public static void main(String args[])
	{
		// StackList st = new StackList();
		// st.push(1);
		// st.push(3);
		// st.push(2);
		// st.push(4);

		// while(!st.isEmpty())
		// {
		// 	System.out.println(st.peek());
		// 	st.pop();
		// }

		StackLL sc = new StackLL();

		sc.push(2);
		sc.push(3);
		sc.push(7);
		sc.push(5);

		while(!sc.isEmpty())
		{
			System.out.println(sc.peek());
			sc.pop();
		}

	}
}