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
	public static void main(String args[])
	{
	// Queues using array
		// QueueLL q = new QueueLL();
		// Queue<Integer> q = new LinkedList<>();
		// Queue<Integer> q = new ArrayDeque<>();

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

	}
}