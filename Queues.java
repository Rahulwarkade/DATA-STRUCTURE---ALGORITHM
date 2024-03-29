import java.util.*;
class Queues
{
	static class QueueArr
	{
		static int arr[];
		static int size;
		static int rear;

		QueueArr(int n)
		{
			arr = new int[n];
			size = n;
			rear = -1;
		}
		boolean isEmpty()
		{
			return rear == -1;
		}

		void add(int data)
		{
			if(rear==size-1)
			{
				System.out.println("queue is empty");
				return;
			}
			rear++;
			arr[rear] = data;
		}

		int remove()
		{
			if(isEmpty()) return -1;
			int front = arr[0];
			for(int i=0; i<rear; i++)
				arr[i] = arr[i+1];
			rear = rear -1;
			return front;
		}

		int peek()
		{
			if(isEmpty()) return -1;
			return arr[0];
		}

	}

	static class CirculerQueue
	{
		static int arr[];
		static int size;
		static int front;
		static int rear;

		CirculerQueue(int n)
		{
			arr = new int[n];
			size = n;
			front = rear = -1;
		}

		boolean isEmpty()
		{
			if(front==-1 && rear == -1) return true;
			return false;
		}

		boolean isFull()
		{
			return (rear+1)%size == front;
		}
		void add(int data)
		{
			if(isFull()) 
			{
				System.out.println("CirculerQueue is full");
				return;
			}
			if(front==-1)
				front = 0;
			rear = (rear+1)%size;
			arr[rear] = data;
		}

		int remove()
		{
			if(isEmpty()) return -1;
			int del = arr[front];

			if(front== rear)
			{
				front = rear = -1;
			}
			else 
			{
				front = (front+1)%size;
			}
			return del;
		}

		int peek()
		{
			if(isEmpty()) return -1;
			return arr[front];
		}
	}

	static class Node
	{
		int data ;
		Node next;

		Node(int data)
		{
			this.data = data;
			this.next = null;
		}
	}

	static class QueueLL
	{
		static Node head = null;
		static Node tail = null;

		boolean isEmpty()
		{
			return head==null;
		}

		void add(int data)
		{
			Node newNode = new Node(data);
			if(isEmpty()){
				head = tail = newNode;
				return;
			}

			tail.next = newNode;
			tail = newNode;
		}

		int remove()
		{
			if(isEmpty()) return -1;
			if(head==tail) 
			{
				int del = head.data;
				head = tail = null;
				return del;
			}
			int d = head.data;
			head = head.next;
			return d;
		}

		int peek()
		{
			if(isEmpty()) return -1;
			return head.data;
		}
	}

	static class QueueStack
	{
		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();

		boolean isEmpty()
		{
			return s1.isEmpty();
		}

		void add(int data)
		{
			while(!s1.isEmpty())
			{
				s2.push(s1.pop());
			}
			s1.push(data);

			while(!s2.isEmpty())
			{
				s1.push(s2.pop());
			}
		}

		int remove()
		{
			if(isEmpty()) return -1;

			return s1.pop();
		}

		int peek()
		{
			if(isEmpty()) return -1;
			return s1.peek();
		}

	}

	static class QueueStack2
	{
		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();

		boolean isEmpty()
		{
			return s1.isEmpty();
		}

		void add(int data)
		{
			s1.push(data);
		}

		int remove()
		{
			if(isEmpty()) return -1;
			while(!isEmpty())
			{
				s2.push(s1.pop());
			}
			int top = s2.pop();
			while(!s2.isEmpty())
			{
				s1.push(s2.pop());
			}
			return top;
		}
		int peek()
		{
			if(isEmpty()) return -1;
			while(!isEmpty())
			{
				s2.push(s1.pop());
			}
			int top = s2.peek();
			while(!s2.isEmpty())
			{
				s1.push(s2.pop());
			}
			return top;
		}

	}

	static class StackQueue
	{
		Queue<Integer> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();

		boolean isEmpty()
		{
			return q1.isEmpty() && q2.isEmpty();
		}

		void push(int data)
		{
			if(!q1.isEmpty())
				q1.add(data);
			else  
				q2.add(data);
		}

		int pop()
		{
			if(isEmpty()) return -1;
			int top = -1;
			if(!q1.isEmpty())
			{
				while(!q1.isEmpty())
				{
					top = q1.remove();
					if(q1.isEmpty())
					{
						break;
					}
					q2.add(top);
				}
			}
			else  
			{
				while(!q2.isEmpty())
				{
					top = q2.remove();
					if(q2.isEmpty())
					{
						break;
					}
					q1.add(top);
				}
			}

			return top;
		}

		int peek()
		{
			if(isEmpty()) return -1;
			int top = -1;
			if(!q1.isEmpty())
			{
				while(!q1.isEmpty())
				{
					top = q1.remove();
					q2.add(top);
				}
			}
			else  
			{
				while(!q2.isEmpty())
				{
					top = q2.remove();
					q1.add(top);
				}
			}

			return top;
		}
	}

	public static void firstNonRepeatingEl(String str)
	{
		Queue<Character> q = new LinkedList<>();
		int freq[] = new int[26];

		for(int i=0; i<str.length(); i++)
		{
			char ch = str.charAt(i);
			freq[ch-'a']++;
			q.add(ch);

			while(!q.isEmpty() && freq[q.peek()-'a']>1)
			{
				q.remove();
			}

			if(q.isEmpty())
				System.out.print(-1+" ");
			else  
				System.out.print(q.peek()+" ");
		}
	}

	public static void interleave(Queue<Integer> q)
	{
		int size = q.size();
		Queue<Integer> firsthalf = new LinkedList<>();

		for(int i=0; i<size/2; i++)
		{
			firsthalf.add(q.remove());
		}

		while(!firsthalf.isEmpty())
		{
			q.add(firsthalf.remove());
			q.add(q.remove());
		}
	}

	public static void reverse(Queue<Integer> q)
	{
		Stack<Integer> s = new Stack<>();
		while(!q.isEmpty())
		{
			s.push(q.remove());
		}

		while(!s.isEmpty())
		{
			q.add(s.pop());
		}
	}

	public static class StackDq
	{
		Deque<Integer> dq = new LinkedList<>();

		void push(int data)
		{
			dq.addLast(data);
		}

		int pop()
		{
			return dq.removeLast();
		}

		int peek()
		{
			return dq.getLast();
		}
	}

	public static class QueueDq
	{
		Deque<Integer> deque = new LinkedList<>();

		void add(int data)
		{
			deque.addLast(data);
		}

		int remove()
		{
			if(deque.isEmpty()) return -1;
			return deque.removeFirst();
		}

		int peek()
		{
			if(deque.isEmpty()) return -1;
			return deque.getFirst();
		}
	}
	public static void main(String args[])
	{
	// Queues using array
		QueueLL q = new QueueLL();
		Queue<Integer> q = new LinkedList<>();
		Queue<Integer> q = new ArrayDeque<>();

		StackQueue q = new StackQueue();
		q.push(4);
		q.push(3);
		q.push(2);
		System.out.println(q.pop());
		q.push(0);
		System.out.println(q.pop());
		q.push(1);

		while(!q.isEmpty())
		{
			System.out.println(q.peek());
			q.pop();
		}

// First non-repeating element in string 

		firstNonRepeatingEl("aabccxb");

//Interleave two halves of queue

		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);
		q.add(6);
		q.add(7);
		q.add(8);
		q.add(9);
		q.add(10);
		interleave(q);

// Queue Reversal

		reverse(q);
		while(!q.isEmpty())
		{
			System.out.print(q.peek()+" ");
			q.remove();
		}

// Double Ended queue => deque

		Deque<Integer> dq = new LinkedList<>();

		dq.addFirst(1);
		dq.addLast(2);
		dq.addFirst(3);
		dq.addLast(4);
		System.out.println(dq);
		dq.removeFirst();
		dq.removeLast();
		System.out.println(dq);
		System.out.println("get first = "+ dq.getFirst());
		System.out.println("get Last = "+ dq.getLast());

//Stack using Deque

		StackDq s = new StackDq();

		s.push(1);
		s.push(2);
		s.push(3);
		System.out.println("peek = "+s.peek());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());

//Queue using Deque	
		QueueDq q = new QueueDq();

		q.add(1);
		q.add(2);
		q.add(3);
		System.out.println("peek = "+q.peek());
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.remove());
	}
}