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
	public static void main(String args[])
	{
	// Queues using array
		// QueueLL q = new QueueLL();
		// Queue<Integer> q = new LinkedList<>();
		Queue<Integer> q = new ArrayDeque<>();
		q.add(4);
		q.add(3);
		q.add(2);
		System.out.println(q.remove());
		q.add(0);
		System.out.println(q.remove());
		q.add(1);

		while(!q.isEmpty())
		{
			System.out.println(q.peek());
			q.remove();
		}

	}
}